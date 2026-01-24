# Big O Complexity Cheat Sheet



[Image of Big O complexity chart]


---

## 1. Constant Time: $O(1)$
- **Description:** Operation takes the same time regardless of input size.
- **Example:** Accessing array element by index, HashMap `get`/`put`.
- **Space:** $O(1)$

---

## 2. Logarithmic Time: $O(\log n)$
- **Description:** Input size reduces by a constant factor each step (divide & conquer).
- **Example:** Binary Search.
- **Space:** $O(1)$ (iterative) / $O(\log n)$ (recursive).

---

## 3. Linear Time: $O(n)$
- **Description:** Single pass through $n$ elements.
- **Example:** Linear Search, finding max/min in an array.
- **Space:** $O(1)$

---

## 4. Linearithmic Time: $O(n \log n)$
- **Description:** Combination of linear pass + logarithmic division.
- **Example:** Merge Sort, Heap Sort, Quick Sort (average).
- **Space:** $O(n)$ (MergeSort) / $O(\log n)$ (QuickSort recursive).

---

## 5. Quadratic Time: $O(n^2)$
- **Description:** Nested loops over the input.
- **Example:** Bubble Sort, Selection Sort, Insertion Sort (worst).
- **Space:** $O(1)$

---

## 6. Cubic Time: $O(n^3)$
- **Description:** Three nested loops.
- **Example:** Matrix multiplication (naive), Floyd-Warshall.
- **Space:** $O(1)$

---

## 7. Exponential Time: $O(2^n)$
- **Description:** Growth doubles with each addition to the input data set.
- **Example:** Recursive Fibonacci (naive), subset generation.
- **Space:** $O(n)$ (recursion stack).

---

## 8. Factorial Time: $O(n!)$
- **Description:** Grows in proportion to the factorial of the input size (all permutations).
- **Example:** Traveling Salesman (brute force).
- **Space:** $O(n)$ (recursion).

---

## 9. Amortized Time
- **Description:** Average time taken per operation over a long sequence.
- **Example:** `ArrayList.add()` (Amortized $O(1)$), HashMap resize (Average $O(1)$).

---

## 10. Space Complexity Patterns
- **$O(1)$** → Constant extra space.
- **$O(n)$** → Linear extra space (e.g., creating a copy of an array).
- **$O(n^2)$** → 2D arrays, Dynamic Programming tables.
- **$O(\log n)$** → Recursion stack for divide & conquer.

---

## Quick Reference Table

| Algorithm / Operation | Best          | Average       | Worst         | Space       |
|:----------------------|:--------------|:--------------|:--------------|:------------|
| Array Access          | $O(1)$        | $O(1)$        | $O(1)$        | $O(1)$      |
| Linear Search         | $O(1)$        | $O(n)$        | $O(n)$        | $O(1)$      |
| Binary Search         | $O(1)$        | $O(\log n)$   | $O(\log n)$   | $O(1)$      |
| Bubble Sort           | $O(n)$        | $O(n^2)$      | $O(n^2)$      | $O(1)$      |
| Selection Sort        | $O(n^2)$      | $O(n^2)$      | $O(n^2)$      | $O(1)$      |
| Insertion Sort        | $O(n)$        | $O(n^2)$      | $O(n^2)$      | $O(1)$      |
| Merge Sort            | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | $O(n)$      |
| Quick Sort            | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$      | $O(\log n)$ |
| Heap Sort             | $O(n \log n)$ | $O(n \log n)$ | $O(n \log n)$ | $O(1)$      |
| HashMap get/put       | $O(1)$        | $O(1)$        | $O(n)$        | $O(n)$      |
| HashSet add/contains  | $O(1)$        | $O(1)$        | $O(n)$        | $O(n)$      |
| Fibonacci (recursive) | $O(2^n)$      | $O(2^n)$      | $O(2^n)$      | $O(n)$      |
| Traveling Salesman    | $O(n!)$       | $O(n!)$       | $O(n!)$       | $O(n)$      |

---

**Tips for Learning:**
1. **Loops:** Identify single loops ($O(n)$) vs nested loops ($O(n^2)$).
2. **Division:** Identify divide & conquer patterns ($O(\log n)$ or $O(n \log n)$).
3. **Recursion:** Check the height of the recursion tree to spot exponential growth.
4. **Data Structures:** Memorize the Big O for standard operations on Arrays, Lists, and HashMaps.