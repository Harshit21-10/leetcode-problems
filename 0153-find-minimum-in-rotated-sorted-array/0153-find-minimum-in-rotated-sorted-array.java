class Solution {
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[left]>nums[right]){
                left++;
            }else{
                if(nums[mid]<nums[left]){
                    left = mid;
                }else{
                    right= mid-1;
                }
            }
        }
        return nums[left];
    }
}