class Solution {
    public int longestConsecutive(int[] a) {
        HashMap < Integer, Boolean> hm = new HashMap();
        for (int val : a) {
            hm.put(val, true);
        }

        for (int val : a) {
            if (hm.containsKey(val - 1)) {
                hm.put(val, false);
            }
        }
        int mh = 0;
        int mval = 0;
        for (int val : a) {
            if (hm.get(val) == true)
            {
                int lh = 1;
                int lval = val;
                while (hm.containsKey(lval + lh)) {
                    lh++;
                }
                if (lh > mh) {
                    mh = lh;
                    mval = val;
                }
            }
        }
        return mh;
    }
}