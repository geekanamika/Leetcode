class Solution {
    public int maxSubArray(int[] nums) {
        return kadens(nums);
    }
    
    public int kadens(int nums[]) {
        int max = Integer.MIN_VALUE, curr = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            curr += nums[i];
            if(curr > max)
                max = curr;
            if(curr < 0)
                curr = 0;
        }
        return max;
    }
    
    public int maxNSquareSol(int nums[]) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        int help[] = new int[n];
        help[0] = nums[0];
        for(int i = 1; i < n; i++) {
            help[i] = help[i-1] + nums[i];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int prev = i > 0 ? help[i-1] : 0;
                max = (help[j] - prev) > max ? (help[j] - prev) : max;
            }
        }
        return max;
    }
}