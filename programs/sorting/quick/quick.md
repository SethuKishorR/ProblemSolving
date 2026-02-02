# ⚡ QUICK SORT – STEP BY STEP DEBUGGING (PARTITION LOGIC)

### 🛠 Algorithm Configuration
* **Method:** Quick Sort
* **Pivot:** FIRST element of sub-array (`arr[start]`)
* **Pointers:** `i` (left seeker), `j` (right seeker)

---

### 📋 INITIAL STATE
**Call:** `quickSort(arr, 0, 4)`

| Index        |   0   | 1 | 2 | 3 |  4  |
|:-------------|:-----:|:-:|:-:|:-:|:---:|
| **Array**    | **4** | 2 | 5 | 1 |  3  |
| **Pointers** |  `i`  |   |   |   | `j` |

---

### 🔍 PARTITION 1 (start = 0, end = 4)
**Pivot Value:** `4`



#### **STEP 1: Move Pointer `i`** *Goal: Find element > Pivot (`arr[i] > 4`)*
* `i = 0` → `arr[0] = 4` (≤ 4) ✅ `i++`
* `i = 1` → `arr[1] = 2` (≤ 4) ✅ `i++`
* `i = 2` → `arr[2] = 5` (≤ 4) ❌ **STOP**
* **Current i = 2**

#### **STEP 2: Move Pointer `j`** *Goal: Find element ≤ Pivot (`arr[j] <= 4`)*
* `j = 4` → `arr[4] = 3` ( > 4) ❌ **STOP**
* **Current j = 4**

#### **STEP 3: Swap `arr[i]` and `arr[j]`**
*Since `i < j` (2 < 4), swap values at indices 2 and 4.*
* **Array becomes:** `[4, 2, 3, 1, 5]`

---

#### **STEP 4: Repeat Movements**
* **Move `i`:**
    * `i = 2` → `arr[2] = 3` (≤ 4) ✅ `i++`
    * `i = 3` → `arr[3] = 1` (≤ 4) ✅ `i++`
    * `i = 4` → `arr[4] = 5` (≤ 4) ❌ **STOP**
* **Move `j`:**
    * `j = 4` → `arr[4] = 5` (> 4) ✅ `j--`
    * `j = 3` → `arr[3] = 1` (> 4) ❌ **STOP**

> **Exit Condition:** `i (4) >= j (3)` ➔ **EXIT LOOP**

---

#### **STEP 5: Final Pivot Placement**
*Swap Pivot (`arr[0]`) with `arr[j]` (`arr[3]`)*
* **Swap:** `4` ↔ `1`
* **Final Array for this step:** `[1, 2, 3, 4, 5]`

**Result:** Pivot `4` is now locked at **Index 3**.

---

### 🔄 RECURSIVE CALLS
The array is split around the pivot (Index 3):
1.  **Left Sub-array:** `quickSort(arr, 0, 2)` ➔ `[1, 2, 3]`
2.  **Right Sub-array:** `quickSort(arr, 4, 4)` ➔ `[5]` (Base case reached)

---

### ✅ FINAL SORTED ARRAY
`[1, 2, 3, 4, 5]`

---

### 💡 KEY OBSERVATIONS
* **Correctness:** Pivot is placed in its final sorted position every time.
* **Partitioning:** Elements to the left are $\le$ pivot; elements to the right are $>$ pivot.
* **Efficiency:** Performed **in-place** (no extra memory).

> **One-Line Summary:** Quick Sort = Partition (place pivot correctly) + Recursion.