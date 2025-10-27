

class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int[] deviceCount = new int[m];
        
        // Count the number of security devices ('1') in each row
        for (int i = 0; i < m; i++) {
            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    deviceCount[i]++;
                }
            }
        }

        int totalBeams = 0;
        int prevDevices = 0;

        // Calculate beams between consecutive non-empty rows
        for (int i = 0; i < m; i++) {
            if (deviceCount[i] == 0) continue; // skip rows with no devices
            totalBeams += prevDevices * deviceCount[i];
            prevDevices = deviceCount[i];
        }

        return totalBeams;
    }
}
