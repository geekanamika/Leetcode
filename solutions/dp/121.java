class Solution {
    public int maxProfit(int[] prices) {
        return dpsol(prices);
    }
    
    public int bruteForce(int[] prices) {
        int profit = 0;
        int n = prices.length;
        if(n < 2)
            return profit;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i+1; j < n; j++) {
                if(prices[j] - prices[i] > profit)
                    profit = prices[j] - prices[i];
            }
        }
        return profit;
    }
    
    // idea is to maximise arr[j] - arr[i] where i < j
    // maintain max found from right and maintain profit along with it to avoid multiple traversals
    public int dpsol(int arr[]) {
        int n = arr.length;
        if(n < 2)
            return 0;
        int profit = 0, max = arr[n-1];
        int i = n-2;
        while(i >= 0) {
            if(max - arr[i] > profit)
                profit = max - arr[i];
            max = arr[i] > max ? arr[i] : max;
            i--;
        }
        return profit;
    }
}