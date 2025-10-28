# 290. Word Pattern

## 🧩 Problem Description

Given a pattern and a string `s`, find if `s` follows the same pattern.

Here, "follow" means a **bijection** between a letter in `pattern` and a **non-empty word** in `s`:

- Each letter in the pattern maps to exactly one unique word in `s`.
- Each unique word in `s` maps to exactly one letter in the pattern.
- No two letters map to the same word, and no two words map to the same letter.

---

### 🔍 Examples

#### Example 1:

**Input:**

```

pattern = "abba"
s = "dog cat cat dog"

```

**Output:**

```

true

```

**Explanation:**

```

'a' → "dog"
'b' → "cat"

```

#### Example 2:

**Input:**

```

pattern = "abba"
s = "dog cat cat fish"

```

**Output:**

```

false

```

#### Example 3:

**Input:**

```

pattern = "aaaa"
s = "dog cat cat dog"

```

**Output:**

```

false

```

---

### ⚙️ Constraints

- `1 <= pattern.length <= 300`
- `pattern` contains only lowercase English letters.
- `1 <= s.length <= 3000`
- `s` contains only lowercase English letters and spaces `' '`.
- `s` does not contain leading or trailing spaces.
- Words in `s` are separated by a single space.

---

## 💡 Approach (based on your code)

1. **Split the input string** `s` into words using `" "`.
2. **Check if pattern length == number of words** — if not, return false.
3. Use a **HashMap<Character, String>** to map pattern characters to words.
4. For each character:
   - If the character is not mapped but the word is already used → invalid bijection.
   - If the character is not yet mapped, store the mapping.
   - If it’s already mapped, ensure the current word matches the stored one.
5. If all conditions pass → return true.

---

### ⏱️ Time Complexity

- **O(n)** where `n` = number of words (or pattern length).

### 💾 Space Complexity

- **O(n)** for storing the mappings.
