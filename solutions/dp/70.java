class Solution {
    public int climbStairs(int n) {
        return dpsolWithVar(n);
    }
    
    
    public int bruteForce(int pos, int n) {
        // not possible, so return zero
        if(pos > n)
            return 0;
        // reached destination, return 1 distinct way
        if(pos == n)
            return 1;
        int count = 0;
        // add all distinct ways i
        count += bruteForce(pos+1, n);
        count += bruteForce(pos+2, n);
        return count;
    }
    
    public int dpsol(int n) {
        if(n <= 1)
            return 1;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    public int dpsolWithVar(int n) {
        if(n <= 1)
            return 1;
        int first = 1, second = 1;
    
        for(int i = 2; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
}