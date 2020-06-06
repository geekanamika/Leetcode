class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return dpsol(cost);
    }
    
    public int bruteforce(int[] costs, int index, int cost) {
        if(index >= costs.length)
            return cost;
        int cost1 = bruteforce(costs, index + 1, cost + costs[index]);
        int cost2 = bruteforce(costs, index + 2, cost + costs[index]);
        return Integer.min(cost1, cost2);
    }
    
    public int dpsol(int[] cost) {
        int n = cost.length;
        if(n <= 2 )
            return 0;
        int dp[] = new int[n];
        
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i = 2; i < n; i++) {
            dp[i] = cost[i] + Integer.min(dp[i-1], dp[i-2]);
        }
        return Integer.min(dp[n-1], dp[n-2]);
    }
}