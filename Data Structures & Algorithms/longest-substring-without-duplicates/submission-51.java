class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();

        int i = 0, res = 0;

        for (int j=0; j<s.length(); j++) {
            while (charSet.contains(s.charAt(j))) {
                charSet.remove(s.charAt(i));
                i++;
            }
            charSet.add(s.charAt(j));
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
