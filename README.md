# 🚀 Java DSA Training Ground & Practice History

Welcome to my Java Data Structures & Algorithms (DSA) repository!  
Yeh repo meri daily practice, foundational concepts, topic-wise code snippets, and LeetCode problem solutions ko organized way mein store karti hai.

---

## 📂 Repository Structure

```text
JAVA DSA/
├── 01-Sorting/                  # Sorting algorithms with Hinglish explanations & dry runs
│   ├── README.md
│   ├── SelectionSort.java
│   ├── BubbleSort.java
│   ├── InsertionSort.java
│   ├── MergeSort.java
│   └── QuickSort.java
├── 02-Arrays/                   # 1D & 2D Array operations, snake traversal, transposing, etc.
│   ├── README.md
│   ├── Array1DBasics.java
│   └── Array2DOperations.java
├── 03-Strings/                  # String algorithms and manipulation
│   ├── README.md
│   └── StringOperations.java
├── 1-two-sum/                   # LeetCode Solutions (Auto-synced via LeetSync)
├── 153-find-minimum-in-rotated-sorted-array/
├── 2-add-two-numbers/
├── 21-merge-two-sorted-lists/
├── 35-search-insert-position/
├── 69-sqrtx/
├── 74-search-a-2d-matrix/
├── 792-binary-search/
├── 8-string-to-integer-atoi/
└── 81-search-in-rotated-sorted-array-ii/
```

---

## 📌 Topic Overview

### 1. 01-Sorting
- **Selection Sort**: Find minimum element in unsorted part and swap with front.
- **Bubble Sort**: Adjacent elements compare karo aur large element target boundary tak push karo.
- **Insertion Sort**: Card-sorting analogy — current element ko left side ke sorted subarray mein correct spot par insert karo.
- **Merge Sort**: Divide and Conquer algorithm ($O(n \log n)$) — array split karo, recursively sort karo, and merge karo.
- **Quick Sort**: Pivot element choose karke partitioning logic se quick sorting perform karo.

Detailed step-by-step Hinglish explanations and dry-run visual representations are available inside [`01-Sorting/README.md`](01-Sorting/README.md).

### 2. 02-Arrays
- **1D Arrays**: Reversing array, finding min and max elements.
- **2D Arrays**: Standard printing, Row-wise Snake Printing, Column-wise Snake Printing, Column-wise printing, In-place Matrix Transposition, Finding minimum of row maximums.

Detailed step-by-step Hinglish explanations and dry-run visual representations are available inside [`02-Arrays/README.md`](02-Arrays/README.md).

### 3. 03-Strings
- Reversing string, checking palindrome logic, and anagram verification.

---

## 🛠️ How to Run Locally

```bash
# Compile all java files in a module
javac 01-Sorting/*.java
javac 02-Arrays/*.java
javac 03-Strings/*.java

# Run a specific class using classpath flag
java -cp 01-Sorting SelectionSort
java -cp 02-Arrays Array2DOperations
java -cp 03-Strings StringOperations
```

---

Happy Coding & Keep Grinding! 💪
