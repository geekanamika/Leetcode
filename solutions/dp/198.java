class Solution {
    public int rob(int[] nums) {
        //return bruteForce(nums, 0, 0);
        return dpsol(nums);
    }
    
    public int bruteForce(int nums[], int pos, int amount) {
        if(pos >= nums.length){
            return amount;
        }
        
        // select pos'th home and go ahead
        int a = bruteForce(nums, pos+2, amount+nums[pos]);
        // skip robbing this house
        int b = bruteForce(nums, pos+1, amount);
        return Integer.max(a, b);
    }
    
    int dpsol(int nums[]) {
        // if no house is present
        if(nums.length == 0)
            return 0;
        // only one house present, so rob the house
        else if(nums.length == 1)
            return nums[0];
        
        // if two houses are present, decide which one has more money and then rob
        nums[1] = Integer.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++) {
            // either rob i-2 & current house or only rob previous(i-1) house
            nums[i] = Integer.max(nums[i]+nums[i-2], nums[i-1]);
        }
        // saving money in houses so last house will contain all the money
        return nums[nums.length -1];
    }
}