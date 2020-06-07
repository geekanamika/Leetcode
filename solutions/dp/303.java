class NumArray {
    int array[];
    int n;
    public NumArray(int[] nums) {
        array = new int[nums.length];
        n = array.length;
        if(n == 0)
            return;
        array[0] = nums[0];
        if(n == 1) {
            return;
        }
        for(int i = 1; i < n; i++) {
            array[i] = array[i-1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(n == 0)
            return 0;
        if(i == 0)
            return array[j];
        return array[j] - array[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */