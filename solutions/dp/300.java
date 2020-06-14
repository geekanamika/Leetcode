class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int lis[] = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            lis[i] = 1;
        }
        int max = 1;
        for(int j = 1; j < nums.length; j++) {
            for(int i = 0; i < j; i++) {
                if(nums[j] > nums[i] && (lis[i]+1) > lis[j]) {
                    lis[j] = lis[i]+1;
                    max = max < lis[j] ? lis[j] : max;
                }
                    
            }
        }
        return max;
    }
}