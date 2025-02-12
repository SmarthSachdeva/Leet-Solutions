class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int i = 0 , j = 0;
        int cnt = 0;

        while(j < 3 && j < s.length()){

            char ch = s.charAt(j);
            hm.put(ch , hm.getOrDefault(ch , 0) + 1);
            j++;
        }

        if(hm.size() == 3) cnt++;

        while(j < s.length() ){

            char ch = s.charAt(i);
            hm.put(ch , hm.get(ch) - 1);
            if(hm.get(ch) == 0){
                hm.remove(ch);
            }
            i++;

            char ch2 = s.charAt(j);
            hm.put(ch2 , hm.getOrDefault(ch2 , 0) + 1);
            j++;

            if(hm.size() == 3) cnt++;
        }
        return cnt;
    }
}