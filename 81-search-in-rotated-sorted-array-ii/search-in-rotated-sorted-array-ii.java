class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){ 
                return true; 
            }
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            mid = low + (high - low) / 2;
            if(nums[low]<=nums[mid]){
                // left sorted
                if(nums[low]<=target && target<nums[mid]){
                    // target in left sorted
                    high = mid - 1;
                }else{
                    // target in right
                    low = mid + 1;
                }
            }else{
                // right sorted
                if(nums[mid]<target && target<=nums[high]){
                    // target in right 
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }

            }
        }
        return false;
    }
}