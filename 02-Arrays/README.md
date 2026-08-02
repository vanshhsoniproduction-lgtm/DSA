# 📊 02-Arrays Operations & Traversal Tricks

Is folder mein 1D aur 2D arrays ke operations, traversal patterns (Snake order, Column-wise), aur matrix transformations ka Hinglish documentation aur visual step-by-step guidance hai.

---

## 📄 File Index

| File Name | Key Concepts & Patterns |
| :--- | :--- |
| [`Array1DBasics.java`](Array1DBasics.java) | Two-pointer array reversal, Min/Max finding in single pass. |
| [`Array2DOperations.java`](Array2DOperations.java) | Row-wise & Col-wise Snake traversal, Col-wise standard traversal, In-place matrix transpose, Row-wise maximum logic. |

---

## 🧠 Deep-Dive Visualizations & Hinglish Step-by-Step

### 1. 2D Array Visual Structure (Grid Representation)

Memory me 2D Array basically arrays ka ek array hota hai (`arr[row][col]`).

```text
Indices:     Col 0   Col 1   Col 2   Col 3
Row 0 --->  [ (0,0)   (0,1)   (0,2)   (0,3) ]
Row 1 --->  [ (1,0)   (1,1)   (1,2)   (1,3) ]
Row 2 --->  [ (2,0)   (2,1)   (2,2)   (2,3) ]
Row 3 --->  [ (3,0)   (3,1)   (3,2)   (3,3) ]
```

---

### 2. Snake Order Printing (Row-Wise) (`printSnakeRowWise`)

**Logic & Pattern**:  
- Even Rows (`row % 2 == 0`) -> Left to Right travel karo (`j = 0` to `col - 1`).
- Odd Rows (`row % 2 != 0`) -> Right to Left travel karo (`j = col - 1` down to `0`).

#### Step-by-Step Visualization:

Given Matrix:
```text
[ 2, 8, 3, 4 ]   Row 0 (Even)  -->  Travel: 2 -> 8 -> 3 -> 4
[ 7, 2, 1, 6 ]   Row 1 (Odd)   <--  Travel: 6 -> 1 -> 2 -> 7
[ 5, 5, 4, 1 ]   Row 2 (Even)  -->  Travel: 5 -> 5 -> 4 -> 1
[ 3, 1, 8, 2 ]   Row 3 (Odd)   <--  Travel: 2 -> 8 -> 1 -> 3
```

**Printed Output Stream**:  
`2 8 3 4` -> `6 1 2 7` -> `5 5 4 1` -> `2 8 1 3`

---

### 3. Snake Order Printing (Column-Wise) (`printSnakeColWise`)

**Logic & Pattern**:  
- Outer loop columns check karega (`j`).
- Even Cols (`j % 2 == 0`) -> Top to Bottom travel karo (`i = 0` to `row - 1`).
- Odd Cols (`j % 2 != 0`) -> Bottom to Top travel karo (`i = row - 1` down to `0`).

#### Step-by-Step Visualization:

Given Matrix:
```text
[ 2, 8, 3, 4 ]
[ 7, 2, 1, 6 ]
[ 5, 5, 4, 1 ]
[ 3, 1, 8, 2 ]
  |  ^  |  ^
  |  |  |  |
  C0 C1 C2 C3
```

- **Col 0 (Even)**: Top to Bottom $\rightarrow$ `2, 7, 5, 3`
- **Col 1 (Odd)**: Bottom to Top $\uparrow$ `1, 5, 2, 8`
- **Col 2 (Even)**: Top to Bottom $\rightarrow$ `3, 1, 4, 8`
- **Col 3 (Odd)**: Bottom to Top $\uparrow$ `2, 6, 1, 4`

---

### 4. Transposing Square Matrix In-Place (`transposeMatrix`)

**Concept**:  
Matrix ke elements ko unke main diagonal (`i == j`) ke along flip kar dete hain (`arr[i][j]` ko `arr[j][i]` ke saath swap karte hain).

> ⚠️ **Key Tip**: Swap loop humesha `j = i + 1` se start hota hai, otherwise elements do baar swap hoke wapas original position par aa jayenge!

#### Step-by-Step Visualization:

```text
Original Matrix:
[ 2, 8, 3, 4 ]
[ 7, 2, 1, 6 ]
[ 5, 5, 4, 1 ]
[ 3, 1, 8, 2 ]

Swapping Process:
- i=0: Swap (0,1)<->(1,0) [8 <-> 7], Swap (0,2)<->(2,0) [3 <-> 5], Swap (0,3)<->(3,0) [4 <-> 3]
- i=1: Swap (1,2)<->(2,1) [1 <-> 5], Swap (1,3)<->(3,1) [6 <-> 1]
- i=2: Swap (2,3)<->(3,2) [1 <-> 8]

Transposed Result:
[ 2, 7, 5, 3 ]
[ 8, 2, 5, 1 ]
[ 3, 1, 4, 8 ]
[ 4, 6, 1, 2 ]
```

---

### 5. Find Minimum of Row Maximums (`findMinOfRowMaxs`)

**Concept**:  
1. Pehle har row ka sabse bada (maximum) element identify karke ek `maxs[]` array mein store karo.
2. Us `maxs[]` array mein se sabse chota (minimum) value select karo.

#### Step-by-Step Visualization:

```text
Matrix:
Row 0: [2, 8, 3, 4] -> Max = 8
Row 1: [7, 2, 1, 6] -> Max = 7
Row 2: [5, 5, 4, 1] -> Max = 5
Row 3: [3, 1, 8, 2] -> Max = 8

Collected Maxima Array: maxs = [8, 7, 5, 8]
Minimum in maxs = 5
```

---

### 6. 1D Array Reversal (Two-Pointer Approach) (`Array1DBasics.java`)

**Logic**:  
- `left` pointer index `0` par rakho, `right` pointer index `n-1` par.
- Dono index ke elements ko swap karo, phir `left++` aur `right--` karo jab tak `left < right`.

#### Step-by-Step Visualization:

```text
Initial Array: [10, 20, 5, 40, 30]  (L=0, R=4)
- Swap 10 & 30 -> [30, 20, 5, 40, 10] (L=1, R=3)
- Swap 20 & 40 -> [30, 40, 5, 20, 10] (L=2, R=2)
- L == R -> Stop condition!
Reversed Result: [30, 40, 5, 20, 10]
```
