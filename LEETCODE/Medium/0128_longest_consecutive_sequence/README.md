### 📑 README Entry

| #   | Problem Name                    | Difficulty | Key Idea                                                                                                                                | Solution Link                                       |
| --- | ------------------------------- | ---------- | --------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------- |
| 128 | Longest Consecutive Sequence 🔗 | Medium     | Two approaches:<br>① **Sort-based (O(n log n))** – sort & count streaks<br>② **HashSet (O(n))** – detect starts of sequences and expand | [Java](./solutions/LongestConsecutiveSequence.java) |

---

### 📝 Explanation for README

#### **Approach 1: Sorting-based (O(n log n))**

1. Sort the array.
2. Iterate and count consecutive streaks.
3. Skip duplicates to avoid breaking sequences.
4. Track the maximum streak length.
   ➡️ Simple but slower due to sorting.

#### **Approach 2: HashSet-based (O(n))**

1. Insert all numbers into a HashSet.
2. For each number, check if it’s the **start** of a sequence (`num-1` not in set).
3. Expand forward (`num+1, num+2...`) and count streak length.
4. Keep track of the maximum.
   ➡️ Efficient linear solution without sorting.

---

⚡ With this, your repo entry will be **readable + educational**: shows both the suboptimal and optimal approach.

Do you also want me to **update your earlier problems (Top K Frequent Elements, Valid Sudoku)** to include multi-approach explanations in README if multiple methods exist?
