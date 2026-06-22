class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        for(int i=0; i<nums.length; i++){
            nums[left] = nums[i] * nums[i];
            left++;
        }
        Arrays.sort(nums);
        return nums;
    }
}