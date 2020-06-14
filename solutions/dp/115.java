class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int dp[][] = new int[m+1][n+1];
        // when n = 0, i.e t is empty string, one subsequence
        for(int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        // when s is empty, no subsequence possible
        for(int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i-1) != t.charAt(j-1))
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
    
    
}