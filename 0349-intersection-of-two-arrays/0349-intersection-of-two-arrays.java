class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap < Integer , Integer > hm = new HashMap <>();
        ArrayList <Integer> list = new ArrayList <> ();
        int v1 = 0;
        while(v1 < nums1.length){
            if(hm.containsKey(nums1[v1])){
                v1++;
            }
            else{
                hm.put(nums1[v1] , 1);
            }
        }

        for( int v : nums2){
            if(hm.containsKey(v)){
                list.add(v);
                hm.remove(v);
            }
        }
        int [] arr = new int [list.size()];
        for(int i = 0 ; i< arr.length ; i++){
            arr[i] = list.get(i);
            
        }   
        return arr;        
    }
    
}

