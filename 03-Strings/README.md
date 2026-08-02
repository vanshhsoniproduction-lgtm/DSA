# 🔤 03-Strings Operations

Is folder mein basic to intermediate String manipulation patterns ke Java implementations aur Hinglish explanations hain.

---

## 📄 File Index

| File Name | Description |
| :--- | :--- |
| [`StringOperations.java`](StringOperations.java) | Reverse String, Check Palindrome, Check Anagrams. |

---

## 🧠 Visualizations & Hinglish Step-by-Step

### 1. Reverse String (`reverseString`)
**Logic**: Two pointers (`left` and `right`) to swap characters in a character array.

```text
Input: "hello"
CharArray: ['h', 'e', 'l', 'l', 'o']
L=0, R=4 -> Swap 'h' & 'o' -> ['o', 'e', 'l', 'l', 'h']
L=1, R=3 -> Swap 'e' & 'l' -> ['o', 'l', 'l', 'e', 'h']
Output: "olleh"
```

---

### 2. Check Palindrome (`isPalindrome`)
**Logic**: Check if a string reads the same forward and backward.

```text
Input: "racecar"
L=0 ('r'), R=6 ('r') -> Match!
L=1 ('a'), R=5 ('a') -> Match!
L=2 ('c'), R=4 ('c') -> Match!
L=3 ('e'), R=3 ('e') -> Center reached.
Result: true
```

---

### 3. Check Anagrams (`isAnagram`)
**Logic**: Check if two strings contain the exact same character frequencies. Sorting technique sorts character arrays and compares equality.

```text
Input: "listen" and "silent"
Sorted Array 1: ['e', 'i', 'l', 'n', 's', 't']
Sorted Array 2: ['e', 'i', 'l', 'n', 's', 't']
Arrays match -> Result: true
```
