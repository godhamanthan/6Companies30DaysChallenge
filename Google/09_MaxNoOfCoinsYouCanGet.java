class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len = piles.length;
        int count = len / 3;
        int res = 0;
        int i = 0;
        int j = len - 1;
        while (i < j && count != 0) {
            if (j - 1 >= i) {
                res += piles[j - 1];
                count--;
            }
            i++;
            j -= 2;
        }
        return res;
    }
}
