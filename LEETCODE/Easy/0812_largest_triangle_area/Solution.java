class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;

        // Try every combination of three points
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    
                    // Apply shoelace formula
                    double curArea = 0.5 * Math.abs(
                        points[i][0] * (points[j][1] - points[k][1]) +
                        points[j][0] * (points[k][1] - points[i][1]) +
                        points[k][0] * (points[i][1] - points[j][1])
                    );
                    
                    // Update maximum area
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }
}
