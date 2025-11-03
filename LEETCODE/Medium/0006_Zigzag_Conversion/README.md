# 6. Zigzag Conversion

## 🧩 Problem Description

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this:

```

P   A   H   N
A P L S I I G
Y   I   R

```

Then we read line by line: `"PAHNAPLSIIGYIR"`.

Write the code that will take a string and make this conversion given a number of rows:

```

string convert(string s, int numRows);

```

---

## 🔍 Example 1

**Input**

```

s = "PAYPALISHIRING", numRows = 3

```

**Output**

```

"PAHNAPLSIIGYIR"

```

---

## 🔍 Example 2

**Input**

```

s = "PAYPALISHIRING", numRows = 4

```

**Output**

```

"PINALSIGYAHRPI"

```

**Explanation**

```

P     I    N
A   L S  I G
Y A   H R
P     I

```

---

## 🔍 Example 3

**Input**

```

s = "A", numRows = 1

```

**Output**

```

"A"

```

---

## ⚙️ Constraints

- `1 <= s.length <= 1000`
- `s` consists of English letters (both cases), ',' and '.'
- `1 <= numRows <= 1000`

---

## 💡 Approach

We simulate the zigzag writing process by maintaining a list of `StringBuilder`s — one for each row.

### Steps:

1. Initialize `numRows` StringBuilders.
2. Traverse the string character by character:
   - Append each character to the current row.
   - Move **downward** (row index increases) until the last row.
   - Then switch direction and move **upward** (row index decreases) until the first row.
3. Finally, concatenate all rows to get the zigzag string.

---

## 🧮 Example Walkthrough

**Input:** `s = "PAYPALISHIRING", numRows = 3`

| Character | Row | Direction | Zigzag State    |
| --------- | --- | --------- | --------------- |
| P         | 0   | ↓         | P               |
| A         | 1   | ↓         | P A             |
| Y         | 2   | ↑         | PA Y            |
| P         | 1   | ↑         | PA YP           |
| A         | 0   | ↓         | PAA YP          |
| L         | 1   | ↓         | PAA LYP         |
| I         | 2   | ↑         | PAAL YPI        |
| S         | 1   | ↑         | PAAL YPIS       |
| H         | 0   | ↓         | PAALH YPIS      |
| I         | 1   | ↓         | PAALH YPISI     |
| R         | 2   | ↑         | PAALH YPISIR    |
| I         | 1   | ↑         | PAALH YPISIRI   |
| N         | 0   | ↓         | PAALHN YPISIRI  |
| G         | 1   | ↓         | PAALHN YPISIRIG |

Concatenating row-wise: `"PAHNAPLSIIGYIR"`

---

## ⏱️ Complexity Analysis

| Complexity | Explanation                             |
| ---------- | --------------------------------------- |
| **Time**   | `O(n)` — traverse each character once   |
| **Space**  | `O(n)` — store intermediate zigzag rows |
