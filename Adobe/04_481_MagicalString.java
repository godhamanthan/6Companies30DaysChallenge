class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        else if (n < 4) return 1;
        
        int[] magStr = new int[n+1];
        magStr[0] = 1; magStr[1] = 2; magStr[2] = 2;
        int head = 2, tail = 3, num = 1, ret = 1;
        while (tail < n) {
            for (int i=0; i<magStr[head]; i++) {
                magStr[tail] = num;
                if (num == 1 && tail<n)   ret++;
                tail++;
            }
            head++;
            num = 3 - num; // flip the num
        }
        return ret;
    }
}
