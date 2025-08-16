class Solution {
    public int maximum69Number (int num) {
        int temp = num;
        int len = String.valueOf(num).length();  // find number of digits
        int[] digitArray = new int[len];         // store digits in array

        // Convert number into array of digits
        for (int i = len - 1; i >= 0; i--) {
            digitArray[i] = temp % 10;
            temp /= 10;
        }

        // Change the first '6' to '9' (from left to right)
        for (int i = 0; i < len; i++) {
            if (digitArray[i] == 6) {
                digitArray[i] = 9;
                break; // only one change allowed
            }
        }

        // Reconstruct the number from the modified digit array
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result * 10 + digitArray[i];
        }

        return result;
    }
}
