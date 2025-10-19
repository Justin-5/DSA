// 12. Integer to Roman
// Approach: Greedy conversion using value-symbol mapping
// Time Complexity: O(1)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder res = new StringBuilder();

        for (int val : values) {
            while (num >= val) {
                res.append(romanMap.get(val));
                num -= val;
            }
        }

        return res.toString();
    }
}
