class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            int m = (i + j) / 2;
            if (nums[m] > nums[j]){
                i = m + 1;
            }
            else{
                j = m;
            }
        }
        int pivot = i;
        i = 0;
        j = nums.length - 1;

        if (target >= nums[pivot] && target <= nums[j]){
            i = pivot;
        }
        else{
            j = pivot - 1;
        }

        while (i <= j){
            int m = (i + j) / 2;
            if (target > nums[m]){
                i = m + 1;
            }
            else if (target < nums[m]){
                j = m - 1;
            }
            else{
                return m;
            }
        }
        return -1;
    }   
}