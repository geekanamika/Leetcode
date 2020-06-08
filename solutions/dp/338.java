class Solution {
    public int[] countBits(int num) {
        return dpsol(num);
    }
    
    public int[] dpsol(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        if(num == 0)
            return dp;
        int offset = 1;
        
        // dp[i] = dp[i - offset] + 1;
        for(int i = 1; i <= num; i++) {
            if(i == 2 * offset)
                offset = offset * 2;
            dp[i] = dp[i - offset] + 1;
        }
        return dp;
    }
    
    // total time is n * log n(base 2)
    public int[] bruteforce(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if(num == 0)
            return res;
        int count = 1;
        while(count <= num) {
            res[count] = getx(count);
            count++;
        }
        return res;
    }
    
    // executes in log n(base 2)
    public int getx(int curr) {
        int count = 0;
        while(curr > 0) {
            if((curr&1) == 1 )
                count++;
            curr = curr >> 1;
        }
        return count;
    }
}