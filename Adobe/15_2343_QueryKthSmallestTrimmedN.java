class Solution {
     public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int resultSize = queries.length;
        int[] result = new int[resultSize];
        long[] tempArray = new long[nums.length];
        String[] numsCopy = new String[nums.length];
        int k = 0;
        while(k < resultSize){
            for(int m = 0; m < nums.length; m++){
                numsCopy[m] = nums[m];
            }
            int trimSize = queries[k][1];
            for(int i = 0; i < nums.length; i++){
                numsCopy[i] = trimString(numsCopy[i], trimSize);
                tempArray[i] = Long.parseLong(numsCopy[i]);
            }
            result[k] = findKthMinIndex(tempArray, queries[k][0]);
            k++;
        }
        return result;
    }

    private static String trimString(String str, int trimSize) {
        int strSize = str.length();
        return str.substring(strSize-trimSize);
    }

    private static int findKthMinIndex(long[] arr, int k){
        long[] arrCopy = new long[arr.length];
        for(int i = 0; i < arr.length; i++){
            arrCopy[i] = arr[i];
        }
        Arrays.sort(arrCopy);
        long kthMin = arrCopy[k-1];
        int kthMinIndex = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] == kthMin){
                kthMinIndex = j;
            }
        }
        return kthMinIndex;
    }
}
