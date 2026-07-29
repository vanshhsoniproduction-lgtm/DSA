class Solution {
    public int findMin(int[] nums) {
        int min=1;
        int low = 0;
        int high = nums.length-1;
        if (high==0){return nums[0];}
        while(low<high){
            int mid = low + (high-low)/2;
            min = nums[mid];
            if(nums[mid]>nums[high]){
                // min at right [ mid ... high ]
                if(min>nums[high]){
                    min=nums[high];
                }
                low=mid+1;
            }else{
                // min at left [ low ... mid ]
                if(min>nums[low]){
                    min=nums[low];
                }
                high=mid;
            }
        }
        return min;
    }
}