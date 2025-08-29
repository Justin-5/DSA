# 🚗 LeetCode 853. Car Fleet

### 📌 Problem Statement

There are `n` cars driving towards a **target position**.  
Each car has a **starting position** and a **speed**.

- Cars cannot pass one another.
- A faster car can catch up to a slower one and form a **fleet** (moving together at the slower car's speed).
- If they meet exactly at the target, they still form a fleet.

Return the **number of car fleets** that will arrive at the target.

🔗 [Problem Link](https://leetcode.com/problems/car-fleet/)

---

### 💡 Example

**Input:**

target = 12
position = [10,8,0,5,3]
speed = [2,4,1,1,3]
Output:
3
Explanation:

Cars at 10 & 8 meet at 12 → 1 fleet.

Car at 0 never catches anyone → 1 fleet.

Cars at 5 & 3 meet at 6 → 1 fleet.
Total fleets = 3.

⚙️ Approach
Compute time for each car to reach target.
time[i]=target−position[i]/speed[i]

​

Sort cars by position descending (cars closer to target first).

Use a stack to track fleets:

If a car takes longer than the fleet ahead → forms new fleet.

Else → merges with the fleet ahead.

Return size of stack as number of fleets.

🛠️ Complexity
Time: O(n log n) (sorting)

Space: O(n) (stack)

```

```
