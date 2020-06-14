class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dpsol(text1, text2);
    }
    
    int dpsol(String a, String b) {
        int m = a.length();
        int n = b.length();
        if(m == 0 || n == 0)
            return 0;
        int dp[][] = new int[m+1][n+1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}