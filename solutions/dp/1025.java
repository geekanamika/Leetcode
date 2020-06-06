class Solution {
    public boolean divisorGame(int N) {
        return N%2 == 0;
    }
    
    public boolean bruteForce(int n) {
        // base case, whoever will start with 1 loses, starts with 2 will always win
        if(n == 1)
            return false;
        else if(n == 2)
            return true;
        
        // alice tries to give opponent a number which will make her lose
        for(int x = 1; x < n; x++) {
            if(n % x == 0 && !bruteForce(n - x))
                return true;
        }
        // if all combinations makes bob win, alice will lose game
        return false;
    }
    
    public boolean dpsol(int n) {
        if(n == 1)
            return false;
        else if(n == 2)
            return true;
        boolean dp[] = new boolean[n+1];
        dp[1] = false;
        dp[2] = true;
        
        for(int i = 3; i <= n; i++) {
            // checks all combinations to give bob losing game
            for(int j = 1; j < i; j++) {
                if(i % j == 0 && !dp[i-j]) {
                    dp[i] = true; 
                    break;
                }
            }
        }
        return dp[n];
        
    }
}