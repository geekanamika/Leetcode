class Solution {
    public int minDistance(String word1, String word2) {
        // return recur(word1.length(), word2.length(), word1, word2);
        return dpsol(word1, word2);
    }
    
    // brute force solution
    int recur(int m, int n, String a, String b) {
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        
        if(a.charAt(m-1) == b.charAt(n-1))
            return recur(m-1, n-1, a, b);
        int replace = recur(m - 1, n - 1, a, b);
        int insert = recur(m, n - 1, a, b);
        int delete = recur(m - 1, n, a, b);
        return 1 + Integer.min(replace, Integer.min(insert, delete));
    }
    
    // dp solution
    int dpsol(String a, String b) {
        int m = a.length();
        int n = b.length();
    
        int dp[][] = new int[m+1][n+1];
        
        // base case
        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = 1 + Integer.min(dp[i-1][j-1], 
                                               Integer.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}