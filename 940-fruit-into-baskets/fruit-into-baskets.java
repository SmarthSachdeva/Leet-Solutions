class Solution {
    public int totalFruit(int[] fruits) {
    int i = 0, j = 0;
    int maxLen = 0;
    
    HashMap<Integer, Integer> hm = new HashMap<>();
    
    for (; j < fruits.length; j++) {
        int e = fruits[j];
        hm.put(e, hm.getOrDefault(e, 0) + 1); // Increase count
        
        while (hm.size() > 2) { // Shrink window when more than 2 types
            int f = fruits[i];
            hm.put(f, hm.get(f) - 1); 
            if (hm.get(f) == 0) {
                hm.remove(f); // Remove fruit type when count is zero
            }
            i++; // Move left pointer forward
        }
        
        maxLen = Math.max(maxLen, j - i + 1);
    }
    
    return maxLen;
}
}