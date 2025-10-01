# 1518. Water Bottles

## Problem Statement

You start with `numBottles` full water bottles.

- Each time you drink a bottle, it becomes an empty bottle.
- You can exchange `numExchange` empty bottles for **1 full bottle**.

Return the **maximum number of bottles you can drink**.

---

## Examples

### Example 1

```

Input: numBottles = 9, numExchange = 3
Output: 13
Explanation:

* Drink the 9 full bottles → 9 empty bottles.
* Exchange 9 / 3 = 3 empty bottles → 3 new full bottles.
* Drink 3 → 3 more empty bottles.
* Exchange 3 / 3 = 1 → 1 new full bottle.
* Drink 1 → Done.
  Total = 9 + 3 + 1 = 13.

```

### Example 2

```

Input: numBottles = 15, numExchange = 4
Output: 19
Explanation:

* Drink 15 full bottles → 15 empty.
* Exchange 15 / 4 = 3 → 3 full bottles, 15 % 4 = 3 leftover empty.
* Drink 3 → 3 more empty bottles (now 6 empty).
* Exchange 6 / 4 = 1 → 1 full bottle, 2 leftover empty.
* Drink 1 → Done.
  Total = 15 + 3 + 1 = 19.

```

---

## Constraints

- `1 <= numBottles <= 100`
- `2 <= numExchange <= 100`

---

## Approach

### Intuition

This is a **simulation problem**:

1. Drink all available bottles → add to count, track empty bottles.
2. While the number of empty bottles ≥ `numExchange`:
   - Exchange them for new bottles.
   - Drink the new bottles.
   - Update leftover empty bottles.
3. Stop when you can’t exchange anymore.

---

### Algorithm

1. Initialize:
   - `drankBottles = numBottles` (since we drink all initial bottles).
   - `emptyBottles = numBottles`.
2. While `emptyBottles >= numExchange`:
   - Compute `newBottles = emptyBottles / numExchange`.
   - Add `newBottles` to `drankBottles`.
   - Update `emptyBottles = (emptyBottles % numExchange) + newBottles`.
3. Return `drankBottles`.

---

## Complexity

- **Time Complexity:** `O(numBottles)` in the worst case (gradual exchanges).
- **Space Complexity:** `O(1)` (constant extra memory).
