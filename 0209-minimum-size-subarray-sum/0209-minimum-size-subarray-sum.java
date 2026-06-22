class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE, left = 0, sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum>=target){
                int length = i-left+1;
                sum -= nums[left];
                left++;
                minLength = Math.min(length,minLength);
            }
        }
        if(minLength>nums.length){
            minLength = 0;
        }
        return minLength;
    }
}