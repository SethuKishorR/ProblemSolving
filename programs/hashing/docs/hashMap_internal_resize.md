# HashMap Resize Explanation (Keys 0–30)

This guide explains the internal bitwise logic used by Java's `HashMap` during the resizing process, specifically tracking keys 0 through 30.

---

## Core Formula
HashMap determines the bucket index using the following bitwise operation:

> index = hash \& (capacity - 1)

> **Assumption:** For this example, we assume `hash(key) = key` (which is true for `Integer` in Java).

---

## 📍 Step 1: Initial Insertion (Capacity = 8)
* **Capacity - 1:** 7 (Binary: `0111`)
* **Formula:** `index = key & 7`



| Key | Binary  | key & 7 (Binary) |   Bucket Index    |
|:---:|:-------:|:----------------:|:-----------------:|
|  0  | `00000` |     `00000`      |       **0**       |
|  1  | `00001` |     `00001`      |       **1**       |
|  2  | `00010` |     `00010`      |       **2**       |
|  3  | `00011` |     `00011`      |       **3**       |
|  4  | `00100` |     `00100`      |       **4**       |
|  5  | `00101` |     `00101`      |       **5**       |
|  6  | `00110` |     `00110`      |       **6**       |
|  7  | `00111` |     `00111`      |       **7**       |
|  8  | `01000` |     `00000`      | **0** (Collision) |
|  9  | `01001` |     `00001`      |       **1**       |
| 10  | `01010` |     `00010`      |       **2**       |
| 11  | `01011` |     `00011`      |       **3**       |
| 12  | `01100` |     `00100`      |       **4**       |
| 13  | `01101` |     `00101`      |       **5**       |
| 14  | `01110` |     `00110`      |       **6**       |
| 15  | `01111` |     `00111`      |       **7**       |
| ... |   ...   |       ...        |        ...        |
| 30  | `11110` |     `00110`      |       **6**       |

### 📦 Buckets Before Resize (Cap 8)
* **Bucket 0:** 0 → 8 → 16 → 24
* **Bucket 1:** 1 → 9 → 17 → 25
* **Bucket 2:** 2 → 10 → 18 → 26
* **Bucket 3:** 3 → 11 → 19 → 27
* **Bucket 4:** 4 → 12 → 20 → 28
* **Bucket 5:** 5 → 13 → 21 → 29
* **Bucket 6:** 6 → 14 → 22 → 30
* **Bucket 7:** 7 → 15 → 23

---

## 🔄 Step 2: Resize Happens (8 → 16)
**Important:** Java does not recompute every hash. It checks only **one bit**: `key & oldCapacity`.
* **Old Capacity:** 8 (Binary: `1000`)

### ⚡ Splitting Rule
* If `(key & 8) == 0`: Element **stays** in the same bucket.
* If `(key & 8) != 0`: Element **moves** to `oldIndex + oldCapacity`.

#### Example: Bucket 0 (Keys: 0, 8, 16, 24)
* `0  & 8 = 0` → Stays at **Index 0**
* `8  & 8 = 8` → Moves to **Index 8**
* `16 & 8 = 0` → Stays at **Index 0**
* `24 & 8 = 8` → Moves to **Index 8**

#### Example: Bucket 6 (Keys: 6, 14, 22, 30)
* `6  & 8 = 0` → Stays at **Index 6**
* `14 & 8 = 8` → Moves to **Index 14**
* `22 & 8 = 0` → Stays at **Index 6**
* `30 & 8 = 8` → Moves to **Index 14**

### 📦 Buckets After Resize (Cap 16)
* **Bucket 0-7:** Stays (e.g., `0 → 16`, `1 → 17`, etc.)
* **Bucket 8-15:** Newly filled (e.g., `Bucket 8: 8 → 24`, `Bucket 14: 14 → 30`)

---

## 🔼 Step 3: Next Resize (16 → 32)
* **Old Capacity:** 16 (Binary: `10000`)
* **Rule:** If `(key & 16) == 0` stay, else move to `oldIndex + 16`.

| Key |  Calculation   | New Bucket Index |
|:---:|:--------------:|:----------------:|
|  0  |  `0 & 16 = 0`  |        0         |
| 16  | `16 & 16 = 16` |        16        |
|  6  |  `6 & 16 = 0`  |        6         |
| 22  | `22 & 16 = 16` |        22        |
| 14  | `14 & 16 = 0`  |        14        |
| 30  | `30 & 16 = 16` |        30        |

### 📦 Final Distribution (Cap 32)
Each key (0-30) now resides in its own bucket because the capacity (32) is greater than the range of unique keys.

---

## 📝 Final Notes
* **Gradual Resizing:** Doubling capacity ensures smooth redistribution.
* **Bitwise Efficiency:** Only the "next high bit" determines the move, making resizing extremely fast.
* **Power of 2:** This logic is why `HashMap` capacity must always be a power of 2.

**Final Stats for 31 elements (0–30):**
1. Initial Cap 8 → Resize to 16 after 6th insertion (0.75 Load Factor).
2. Cap 16 → Resize to 32 after 12th insertion.
3. **Final capacity = 32**, all elements stored with 0 collisions.

---

### 🌳 Treeification (Java 8 Optimization)
When a single bucket becomes a performance bottleneck, Java optimizes it further:
* **Threshold:** When a bucket reaches **8 elements**, it converts from a Linked List to a **Red-Black Tree**.
* **Condition:** This only happens if total capacity is $\ge 64$. If capacity is lower, it simply resizes.
* **Benefit:** Reduces search time from $O(n)$ to $O(\log n)$.



### ⚡ Performance Summary
| Operation        | Average Case | Worst Case (List) | Worst Case (Tree) |
|:-----------------|:-------------|:------------------|:------------------|
| **Search (get)** | $O(1)$       | $O(n)$            | $O(\log n)$       |
| **Insert (put)** | $O(1)$       | $O(n)$            | $O(\log n)$       |

### ⚠️ Security Note: Hash DOS
The reason for **Treeification** is to prevent **Hash Denial of Service** attacks, where an attacker sends specifically crafted keys that all result in the same `hashCode`, forcing the Map into $O(n)$ performance and slowing down the server.