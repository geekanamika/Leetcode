class Solution {
    public int numDecodings(String s) {
        return dpsol(s);
    }
    
    int dpsol(String s) {
       if(s.length() == 0 || s == null)
           return 0;
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= s.length(); i++) {
            // substring at i-1 (of 1 length)
            int first = Integer.parseInt(s.substring(i-1, i));
            // substring at i-1 to i-1 (of 2 length)
            int second = Integer.parseInt(s.substring(i-2, i));
            if(first >= 1 && first <= 9)
                dp[i] += dp[i-1];
            if(second >= 10 && second <= 26)
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}