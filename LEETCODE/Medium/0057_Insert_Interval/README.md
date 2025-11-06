# 57. Insert Interval

## 🧩 Problem Description

You are given an array of **non-overlapping intervals** `intervals` where  
`intervals[i] = [starti, endi]` represents the start and end of the _i-th_ interval.  
The array is sorted in ascending order by start time.

You are also given another interval `newInterval = [start, end]`.

Insert `newInterval` into `intervals` such that:

- The result is still sorted by start time.
- The result still has **no overlapping intervals** (merge overlapping ones if needed).

Return the final array of merged intervals.

---

## 🔍 Example 1

**Input**

```

intervals = [[1,3],[6,9]]
newInterval = [2,5]

```

**Output**

```

[[1,5],[6,9]]

```

**Explanation**
The new interval `[2,5]` overlaps with `[1,3]`, so we merge them into `[1,5]`.

---

## 🔍 Example 2

**Input**

```

intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]

```

**Output**

```

[[1,2],[3,10],[12,16]]

```

**Explanation**
The new interval `[4,8]` overlaps with `[3,5],[6,7],[8,10]`, so we merge them into `[3,10]`.

---

## ⚙️ Constraints

- `0 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= starti <= endi <= 10^5`
- `intervals` is sorted by `starti` in ascending order.
- `newInterval.length == 2`
- `0 <= start <= end <= 10^5`

---

## 💡 Approach — Three-Phase Linear Scan (O(n))

We process the intervals in **three phases**:

1. **Add non-overlapping intervals before the new interval.**  
   These intervals end before the new interval starts.

2. **Merge all overlapping intervals** with the new interval.  
   Expand `newInterval` by taking the `min(start)` and `max(end)` of overlapping intervals.

3. **Add all remaining intervals** that start after the new interval ends.

---

### Steps

1. Initialize `mergedInterval = []` list.
2. Iterate through all intervals:
   - Add all intervals ending **before** `newInterval` starts.
   - Merge all intervals **overlapping** with `newInterval`.
   - Add the updated `newInterval`.
   - Add all intervals starting **after** `newInterval` ends.
3. Convert `List<int[]>` back to a 2D array and return.

---

## 🧮 Example Walkthrough

**Input**

```

intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]

```

| Step | Action                                                   | Result                   |
| ---- | -------------------------------------------------------- | ------------------------ |
| 1    | Add intervals before new interval (`[1,2]`)              | `[[1,2]]`                |
| 2    | Merge `[3,5]`, `[6,7]`, `[8,10]` with `[4,8]` → `[3,10]` | `[[1,2],[3,10]]`         |
| 3    | Add remaining `[12,16]`                                  | `[[1,2],[3,10],[12,16]]` |

✅ **Final Answer:** `[[1,2],[3,10],[12,16]]`

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                            |
| --------- | ---------- | -------------------------------------- |
| **Time**  | `O(n)`     | Each interval is visited once          |
| **Space** | `O(n)`     | Output list stores up to all intervals |
