class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
       int n = nums.length;
       if(n==0) return new ArrayList();
       Arrays.sort(nums);
       int[] count = new int[n];
       Arrays.fill(count,1);
       for(int i=1; i<n; i++){
           for(int j=i-1; j>=0; j--){
               if(nums[i]%nums[j]==0)
               count[i] = Math.max(count[i], count[j]+1);
           }
       }
       int maxIndex = 0;
       for(int i=1; i<n; i++){
           maxIndex = count[i]>count[maxIndex]? i : maxIndex;
       } 
       List<Integer>result = new ArrayList();
       int temp = nums[maxIndex];
       int currCount = count[maxIndex];
       for(int i=maxIndex; i>=0; i--){
           if(temp%nums[i]==0 && currCount==count[i]){
               result.add(nums[i]);
               temp = nums[i];
               currCount --;

           }
       }
       return result;
    }
}
