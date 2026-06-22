class Solution {
    public int findClosestNumber(int[] nums) {
       
        int minVal = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int diff =Math.abs(nums[i] - 0);
            if(nums[i] == 0) return 0;
            if(diff<Math.abs(minVal)){
                minVal = nums[i];
            }else if(diff == Math.abs(minVal)){
                minVal = Math.max(minVal, nums[i]);
            }
        }
        return minVal;
    }
}