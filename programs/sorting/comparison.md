# 📚 Quick-Study: Elementary Sorting Algorithms

A condensed comparison table of the three primary $O(n^2)$ sorting algorithms in Java.

| Feature          | Bubble Sort                | Selection Sort                  | Insertion Sort                 |
|:-----------------|:---------------------------|:--------------------------------|:-------------------------------|
| **Main Logic**   | **Swap** adjacent elements | **Select** minimum & swap       | **Shift** & insert at spot     |
| **Best Case**    | $O(n)$ (with flag)         | $O(n^2)$                        | $O(n)$                         |
| **Average Case** | $O(n^2)$                   | $O(n^2)$                        | $O(n^2)$                       |
| **Worst Case**   | $O(n^2)$                   | $O(n^2)$                        | $O(n^2)$                       |
| **Space**        | $O(1)$ (In-place)          | $O(1)$ (In-place)               | $O(1)$ (In-place)              |
| **Stability**    | ✅ **Stable**               | ❌ **Unstable**                  | ✅ **Stable**                   |
| **Adaptive?**    | Yes                        | No                              | Yes                            |
| **Key Strength** | Very simple to code        | Fewest swaps (memory efficient) | Fastest for nearly sorted data |

---

## 🔍 Visualizing the Movement

### Bubble Sort
Think of **bubbles in a drink**: The largest values slowly rise to the end of the array.


### Selection Sort
Think of a **scout**: It scans the whole unsorted list to find the absolute smallest, then moves it to the front once.


### Insertion Sort
Think of **sorting playing cards**: You pick a card and slide it into its correct position among the cards already in your hand.


---

## 🧠 Interview Cheat Sheet

* **Stable Sort:** Keeps the relative order of duplicate elements (Bubble & Insertion).
* **Unstable Sort:** May change the relative order of duplicates (Selection).
* **In-place:** Uses constant extra space ($O(1)$).
* **Adaptive:** Gets faster if the input is already partially sorted (Bubble & Insertion).

---

* Bubble Sort → compares & swaps adjacent elements
* Selection Sort → selects minimum and swaps once per pass
* Insertion Sort → shifts elements and inserts key
* All three are **in-place** and mainly used for **learning and small inputs**
