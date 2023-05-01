class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double avg , sum=0, count=0;
        
        for(int i=1;i<salary.length-1;i++){
            count++;
            sum = sum+ salary[i];
            
        }
        avg = sum/count;
       return avg;
}  
    }
   