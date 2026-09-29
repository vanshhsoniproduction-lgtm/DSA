class Solution {
    public void moveZeroes(int[] nums) {
        int x = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[x];
                nums[x] = nums[i];
                nums[i] = temp;

                x++;
            }
        }
    }
}