class Solution {
    public int countGoodSubstrings(String s) {
        int cnt = 0;
        
        // Use a sliding window approach
        for (int i = 0; i <= s.length() - 3; i++) {
            String sub = s.substring(i, i + 3);  // Get a substring of length 3
            // Check if all characters in the substring are unique
            if (sub.charAt(0) != sub.charAt(1) && sub.charAt(0) != sub.charAt(2) && sub.charAt(1) != sub.charAt(2)) {
                cnt++;  // Count the substring if all characters are unique
            }
        }
        
        return cnt;
    }
}
