class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        
        // Find the largest width W <= sqrt(area) that divides the area evenly
        while (area % w != 0) {
            w--;
        }
        
        // Length L will automatically be area / W, satisfying L >= W
        return new int[]{area / w, w};
    }
}