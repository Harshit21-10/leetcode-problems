class Solution {
    public boolean search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return true;
            if(nums[left]>=nums[right]){
                if(nums[right]==target) return true;
                right--;
            }else{
                if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return false;
    }
}