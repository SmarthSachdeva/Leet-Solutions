class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x; // handle 0 and 1
        long low = 1, high = x / 2;
        int ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2; // use long here
            long midSquared = mid * mid; // use long to avoid overflow

            if (midSquared <= x) {
                ans = (int) mid; // update ans to the largest mid
                low = mid + 1; // search in the upper half
            } else {
                high = mid - 1; // search in the lower half
            }
        }
        
        return ans;
    }
}
