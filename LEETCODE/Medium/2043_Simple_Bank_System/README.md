# 2043. Simple Bank System

## 🧩 Problem Description

You are asked to design a simple banking system that can handle basic transactions: deposit, withdraw, and transfer.  
There are `n` accounts numbered from `1` to `n`, each with an initial balance given in the array `balance`.

You need to implement the following operations:

- **`Bank(long[] balance)`** — Initialize the bank with the given balances.
- **`boolean transfer(int account1, int account2, long money)`** — Transfer `money` from `account1` to `account2`.
- **`boolean deposit(int account, long money)`** — Deposit `money` into `account`.
- **`boolean withdraw(int account, long money)`** — Withdraw `money` from `account`.

A transaction is **valid** if:

- The account numbers are within range `1 ≤ account ≤ n`.
- The account has enough funds for withdrawals or transfers.

---

## 🧠 Example

### Input

```

["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
[[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]

```

### Output

```

[null, true, true, true, false, false]

```

### Explanation

```java
Bank bank = new Bank([10, 100, 20, 50, 30]);
bank.withdraw(3, 10);    // true → Account 3: 20 - 10 = 10
bank.transfer(5, 1, 20); // true → Account 5: 30 - 20 = 10, Account 1: 10 + 20 = 30
bank.deposit(5, 20);     // true → Account 5: 10 + 20 = 30
bank.transfer(3, 4, 15); // false → Account 3 has only 10
bank.withdraw(10, 50);   // false → Account 10 doesn’t exist
```

---

## ⚙️ Constraints

- `n == balance.length`
- `1 <= n, account, account1, account2 <= 10^5`
- `0 <= balance[i], money <= 10^12`
- At most `10^4` operations will be performed.

---

## 💡 Approach

1. Store all account balances in an array `balance`.
2. Validate account indices before performing any operation.
3. For each method:

   - **withdraw:** check sufficient balance, subtract if valid.
   - **deposit:** add to the corresponding account.
   - **transfer:** perform withdraw + deposit if both accounts valid and source has enough balance.

All operations run in **O(1)** time complexity.

---

## 🧾 Code Implementation

```java
class Bank {
    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > balance.length || account2 > balance.length) {
            return false;
        }
        if (balance[account1 - 1] < money) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > balance.length) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > balance.length || balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}
```

---

## 🧪 Complexity Analysis

| Operation  | Time | Space |
| ---------- | ---- | ----- |
| deposit()  | O(1) | O(1)  |
| withdraw() | O(1) | O(1)  |
| transfer() | O(1) | O(1)  |

---

## 🏁 Summary

✅ Simple O(1) operations
✅ Edge cases handled for invalid accounts and insufficient balance
✅ Clean and efficient implementation
