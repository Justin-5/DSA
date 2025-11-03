
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        // Base case: if only one row, no zigzag pattern is formed
        if (numRows == 1) {
            return s;
        }

        // Create a list of StringBuilders for each row
        List<StringBuilder> zigzag = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            zigzag.add(new StringBuilder());
        }

        int curRow = 0;       // Current row index
        int direction = 1;    // 1 = down, -1 = up

        // Iterate through all characters in the input string
        for (char ch : s.toCharArray()) {
            zigzag.get(curRow).append(ch);

            // Change direction when reaching the top or bottom row
            if (curRow == numRows - 1) {
                direction = -1;
            }
            if (curRow == 0) {
                direction = 1;
            }

            curRow += direction;
        }

        // Combine all rows to form the final result
        StringBuilder zigZagString = new StringBuilder();
        for (StringBuilder str : zigzag) {
            zigZagString.append(str);
        }

        return zigZagString.toString();
    }
}
