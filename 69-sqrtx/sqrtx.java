class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x; 
        long low = 1, high = x / 2;
        int ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2; 
            long midSquared = mid * mid; 
            if (midSquared <= x) {
                ans = (int) mid; 
                low = mid + 1; // search in the upper half
            } else {
                high = mid - 1; // search in the lower half
            }
        }
        
        return ans;
    }
}
