# 3100. Water Bottles II

## Problem Statement

You are given:

- `numBottles`: the number of full water bottles initially.
- `numExchange`: the number of empty bottles needed to exchange for **1 full water bottle**.

Rules:

1. You may drink any full bottle → it becomes an empty bottle.
2. You can exchange **exactly `numExchange` empty bottles** for 1 full bottle.
3. After each exchange, `numExchange` increases by **1**.
4. You cannot exchange multiple times at the same value of `numExchange`.

Return the **maximum number of water bottles you can drink**.

---

## Examples

### Example 1

```

Input: numBottles = 13, numExchange = 6
Output: 15

```

### Example 2

```

Input: numBottles = 10, numExchange = 3
Output: 13

```

---

## Constraints

- `1 <= numBottles <= 100`
- `1 <= numExchange <= 100`

---

## Approach

### Intuition

- Start with `numBottles` (all can be drunk directly).
- Each time you collect enough empty bottles to meet the current `numExchange`, you can exchange them for **1 new bottle**.
- After every exchange:
  - `numExchange` increases by 1 (making future exchanges harder).
  - You drink that new bottle, which adds to the total.
- Stop when you don’t have enough empty bottles to meet the current `numExchange`.

---

### Algorithm

1. Initialize:
   - `drunkBottles = numBottles`
   - `emptyBottles = numBottles`
2. While `emptyBottles >= numExchange`:
   - Spend `numExchange` empty bottles.
   - Increase `numExchange` by 1.
   - Drink one new bottle (`drunkBottles++`).
   - Add that bottle’s empty back (`emptyBottles++`).
3. Return `drunkBottles`.

---

## Dry Run

### Input:

```

numBottles = 10, numExchange = 3

```

Steps:

| Step | Full Bottles | Empty Bottles | numExchange | Drank |
| ---- | ------------ | ------------- | ----------- | ----- |
| Init | 10           | 10            | 3           | 10    |
| 1    | 0            | 7             | 4           | 11    |
| 2    | 0            | 4             | 5           | 12    |
| 3    | 0            | 0             | 6           | 13    |

Stop → **Answer = 13**

---

## Complexity

- **Time Complexity:** `O(n)` in the worst case (each exchange reduces empty bottles and increases `numExchange`).
- **Space Complexity:** `O(1)` (only counters used).
