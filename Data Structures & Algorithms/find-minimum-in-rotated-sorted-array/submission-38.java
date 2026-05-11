class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            int m = (i + j) / 2;
            if (nums[m] < nums[j]){
                j = m;
            }
            else{
                i = m + 1;
            }
        }
        return nums[i];
    }
}
