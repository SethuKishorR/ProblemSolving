# Merge Sort – Visual Debugger & Interview Notes

---

## 🧩 Initial State
**Input Array:**
`[38, 27, 43, 3, 9, 82, 10]`

---

## 1) Divide Phase (Top-Down)
Merge Sort follows the **Divide and Conquer** strategy. It recursively splits the array until each segment contains exactly one element (the base case).

> **Midpoint Formula:** $mid = \lfloor \frac{left + right}{2} \rfloor$

### Visual Representation

```text
L0:          [38, 27, 43, 3, 9, 82, 10]
                    /                \
L1:         [38, 27, 43, 3]          [9, 82, 10]
            /           \            /        \
L2:     [38, 27]       [43, 3]    [9, 82]     [10]
        /      \       /     \    /     \       |
L3:   [38]    [27]   [43]    [3] [9]    [82]   [10]
```

## 2) Merge Phase (Core Logic – Debug Style)

Sorting occurs by comparing elements from two sorted sub-arrays using **two pointers**:
* `i` $\rightarrow$ tracks the **Left** sub-array
* `j` $\rightarrow$ tracks the **Right** sub-array



### 🛠 The Rules:
1.  **Compare** `left[i]` and `right[j]`
2.  **Pick** the smaller value for the result array
3.  **Move** the corresponding pointer (`i++` or `j++`)
4.  **Cleanup:** Once one sub-array is exhausted, copy all remaining elements from the other.

---

## 3) Example Merge (Step-by-Step)

**Merging:** `Left = [27, 38]` | `Right = [3, 43]`

| Step       | Comparison     | Action                | Result Array      |
|:-----------|:---------------|:----------------------|:------------------|
| **Step 1** | $27 > 3$       | Pick **3** from Right | `[3]`             |
| **Step 2** | $27 < 43$      | Pick **27** from Left | `[3, 27]`         |
| **Step 3** | $38 < 43$      | Pick **38** from Left | `[3, 27, 38]`     |
| **Step 4** | Left exhausted | Copy remaining **43** | `[3, 27, 38, 43]` |

**Final Result:** `[3, 27, 38, 43]`

## 4) Full Reconstruction Trace

The algorithm builds the final sorted array by merging sub-arrays from the bottom up.

| Sequence   | Operation       | Sub-Arrays                        | Resulting Segment            |
|:-----------|:----------------|:----------------------------------|:-----------------------------|
| **Step 1** | Merge           | `[38]` and `[27]`                 | `[27, 38]`                   |
| **Step 2** | Merge           | `[43]` and `[3]`                  | `[3, 43]`                    |
| **Step 3** | Merge           | `[27, 38]` and `[3, 43]`          | `[3, 27, 38, 43]`            |
| **Step 4** | Merge           | `[9]` and `[82]`                  | `[9, 82]`                    |
| **Step 5** | Merge           | `[9, 82]` and `[10]`              | `[9, 10, 82]`                |
| **Step 6** | **Final Merge** | `[3, 27, 38, 43]` + `[9, 10, 82]` | `[3, 9, 10, 27, 38, 43, 82]` |

---

## 5) Final Sorted Output

`[3, 9, 10, 27, 38, 43, 82]`

--------------------------------------------------
## 6) Complexity Analysis (Interview Ready)
--------------------------------------------------

Time Complexity:
- Best Case:    O(n log n)
- Average Case: O(n log n)
- Worst Case:   O(n log n)

Space Complexity:
- O(n) (extra arrays used during merge)

Stability:
- YES (preserves order of equal elements)

--------------------------------------------------
## 7) When to Use Merge Sort?
--------------------------------------------------

✔ Large datasets  
✔ Linked Lists  
✔ When stable sorting is required  
✔ When worst-case performance must be guaranteed

✘ Uses extra memory  
✘ Not in-place

--------------------------------------------------
## 8) Interview One-Liners
--------------------------------------------------

- Merge Sort follows Divide and Conquer.
- Always runs in O(n log n).
- Stable but not in-place.
- Preferred for large data and linked lists.