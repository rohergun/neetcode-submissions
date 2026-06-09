class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), 0, target);
        return res;
    }
    
    // i current Index of nums, curr: current combination
    // total sum of numbers in curr
    public void dfs(int[] nums, int i, List<Integer> curr, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (int j=i; j<nums.length; j++){
            if (total + nums[j] > target) {
                return;
            }
            curr.add(nums[j]);
            dfs(nums, j, curr, total + nums[j], target);
            curr.remove(curr.size() - 1);
        }
    }
    
}
