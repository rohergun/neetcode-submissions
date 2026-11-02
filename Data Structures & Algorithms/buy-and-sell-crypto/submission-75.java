class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 1, maxP = 0;

        while (j < prices.length) {
            if (prices[i] < prices[j]) {
                int p = prices[j] - prices[i];
                maxP = Math.max(maxP, p);
            }
            else {
                i = j;
            }
            j++;
        }
        return maxP;
    }
}
