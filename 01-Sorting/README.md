# 🔀 01-Sorting Algorithms

Is folder mein saare foundational array sorting algorithms implementation aur Hinglish dry-run documentations hain.

---

## 📄 File Index & Algorithms

| File Name | Time Complexity (Avg/Worst) | Space Complexity | Explanation |
| :--- | :---: | :---: | :--- |
| [`SelectionSort.java`](SelectionSort.java) | $O(n^2)$ | $O(1)$ | Unsorted part se minimum element dhoondo aur current index par swap karo. |
| [`BubbleSort.java`](BubbleSort.java) | $O(n^2)$ | $O(1)$ | Consecutive elements compare karke largest element ko array ke end tak bubble out karo. |
| [`InsertionSort.java`](InsertionSort.java) | $O(n^2)$ | $O(1)$ | Playing cards ki tarah left side ke sorted subarray mein current element ko insert karo. |
| [`MergeSort.java`](MergeSort.java) | $O(n \log n)$ | $O(n)$ | Divide & Conquer technique se array half-half divide karo, sort karo aur merge karo. |
| [`QuickSort.java`](QuickSort.java) | $O(n \log n)$ | $O(\log n)$ | Pivot select karke array ko partition karo such that left side elements < pivot < right side. |

---

## 📊 Deep-Dive Visualizations & Hinglish Step-by-Step

### 1. Selection Sort (`SelectionSort.java`)
**Concept**:  
Har pass mein unsorted array part me se sabse chota (minimum) element khojo aur use unsorted portion ke pehle index par place kar do.

#### Step-by-Step Visualization (Example Array: `[64, 25, 12, 22, 11]`):

```text
Initial Array: [64, 25, 12, 22, 11]

Pass 1:
  - Search min from index 0 to 4. Min element = 11 (at index 4).
  - Swap 64 (index 0) with 11 (index 4).
  - Array state: [11 | 25, 12, 22, 64]
                 ^^ (Sorted boundary)

Pass 2:
  - Search min from index 1 to 4. Min element = 12 (at index 2).
  - Swap 25 (index 1) with 12 (index 2).
  - Array state: [11, 12 | 25, 22, 64]

Pass 3:
  - Search min from index 2 to 4. Min element = 22 (at index 3).
  - Swap 25 (index 2) with 22 (index 3).
  - Array state: [11, 12, 22 | 25, 64]

Pass 4:
  - Search min from index 3 to 4. Min element = 25 (already at index 3).
  - No swap required.
  - Final Sorted Array: [11, 12, 22, 25, 64]
```

---

### 2. Bubble Sort (`BubbleSort.java`)
**Concept**:  
Paas wale do numbers ko compare karo (`arr[j] > arr[j+1]`). Agar left bada hai toh swap kar do. Har inner loop ke baad sabse bada number end mein settle (bubble out) ho jata hai.

#### Step-by-Step Visualization (Example Array: `[5, 1, 4, 2, 8]`):

```text
Initial Array: [5, 1, 4, 2, 8]

Pass 1:
  - Compare (5, 1) -> 5 > 1 -> Swap -> [1, 5, 4, 2, 8]
  - Compare (5, 4) -> 5 > 4 -> Swap -> [1, 4, 5, 2, 8]
  - Compare (5, 2) -> 5 > 2 -> Swap -> [1, 4, 2, 5, 8]
  - Compare (5, 8) -> 5 < 8 -> No swap -> [1, 4, 2, 5, 8]
  - Largest element 8 end mein settle ho gaya.

Pass 2:
  - Compare (1, 4) -> No swap -> [1, 4, 2, 5, 8]
  - Compare (4, 2) -> Swap -> [1, 2, 4, 5, 8]
  - Compare (4, 5) -> No swap -> [1, 2, 4, 5, 8]

Pass 3:
  - Check array: Already sorted! (Optimized flag stops early).
  - Final Sorted Array: [1, 2, 4, 5, 8]
```

---

### 3. Insertion Sort (`InsertionSort.java`)
**Concept**:  
Unsorted array se ek element pick karo aur left side ke sorted region me tab tak shift karte raho jab tak ki uski sahi jagah na mil jaye.

#### Step-by-Step Visualization (Example Array: `[12, 11, 13, 5, 6]`):

```text
Initial Array: [12 | 11, 13, 5, 6]   (Index 0 sorted single element)

Pick 11 (Index 1):
  - Compare with 12: 12 > 11 -> Shift 12 right -> [12, 12, 13, 5, 6]
  - Place 11 at index 0 -> [11, 12 | 13, 5, 6]

Pick 13 (Index 2):
  - Compare with 12: 13 > 12 -> No shift needed.
  - Array state: [11, 12, 13 | 5, 6]

Pick 5 (Index 3):
  - Shift 13, 12, 11 rightwards.
  - Place 5 at index 0 -> [5, 11, 12, 13 | 6]

Pick 6 (Index 4):
  - Shift 13, 12, 11 rightwards.
  - Place 6 at index 1 -> [5, 6, 11, 12, 13]
```

---

### 4. Merge Sort (`MergeSort.java`)
**Concept**:  
Divide and Conquer strategy. Main array ko binary tree ki tarah middle se half split karo jab tak single elements bachen. Then unhe compare karke merge karo.

#### Step-by-Step Visualization (Example Array: `[38, 27, 43, 3]`):

```text
Split Phase (Divide):
                   [38, 27, 43, 3]
                   /             \
             [38, 27]           [43, 3]
             /      \           /     \
           [38]    [27]       [43]    [3]

Merge Phase (Conquer):
           [38]    [27]       [43]    [3]
             \      /           \     /
             [27, 38]           [3, 43]
                   \             /
                   [3, 27, 38, 43]
```

---

### 5. Quick Sort (`QuickSort.java`)
**Concept**:  
Ek `pivot` element (e.g. Last element) choose karo. Array ko aise rearrange karo ki saare `pivot se chote elements` pivot ke left me aa jaye aur `pivot se bade elements` pivot ke right me. Then same recursive call apply karo.

#### Step-by-Step Visualization (Example Array: `[10, 7, 8, 9, 1, 5]`):

```text
Initial Array: [10, 7, 8, 9, 1, 5], Pivot = 5

Partitioning Process:
  - Compare 10 (< 5? No)
  - Compare 7  (< 5? No)
  - Compare 8  (< 5? No)
  - Compare 9  (< 5? No)
  - Compare 1  (< 5? Yes) -> Swap 10 with 1 -> [1, 7, 8, 9, 10, 5]
  - End of loop: Place Pivot 5 at correct spot (index 1) -> Swap 7 with 5.

After First Partition:
  Left Subarray:  [1]
  Pivot Settle:   5 (at index 1)
  Right Subarray: [8, 9, 10, 7]

Recursively process left & right sub-arrays until sorted!
Final Array: [1, 5, 7, 8, 9, 10]
```
