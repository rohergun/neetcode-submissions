class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i: nums) {
            numSet.add(i);
        }

        int res = 0;
        for (int i: nums) {
            if (!numSet.contains(i - 1)) {
                int len = 1;
                while (numSet.contains(i + len)) {
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
