import java.util.HashMap;
import  java.util.Map;
public class main {
    // Class Solution that contains the method to convert Roman numeral to Integer
class Solution {
    public int romanToInt(String s) {

        // Step 1: Create a HashMap to store Roman numeral characters and their integer values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);     // Value of I
        roman.put('V', 5);     // Value of V
        roman.put('X', 10);    // Value of X
        roman.put('L', 50);    // Value of L
        roman.put('C', 100);   // Value of C
        roman.put('D', 500);   // Value of D
        roman.put('M', 1000);  // Value of M

        // Step 2: Initialize variables
        int result = 0;           // To store the final integer value
        int size = s.length();    // Length of the Roman numeral string
        int cur = 0;              // Current Roman numeral value in loop
        int prev = 0;             // Next Roman numeral value in loop (used for comparison)

        // Step 3: Start from the last character in the string
        // Assign the value of the last character directly to result
        result = roman.get(s.charAt(size - 1));

        // Step 4: Loop from the second last character to the first character (right to left)
        for (int i = size - 2; i >= 0; i--) {

            // Get the value of the current Roman numeral
            cur = roman.get(s.charAt(i));

            // Get the value of the numeral to the right of the current one
            prev = roman.get(s.charAt(i + 1));

            // Step 5: Check subtraction rule
            // If the current numeral is less than the numeral on its right, subtract it
            if (cur < prev) {
                result -= cur;
            }
            // Otherwise, add it
            else {
                result += cur;
            }
        }

        // Step 6: Return the computed integer value
        return result;
    }
}

}
