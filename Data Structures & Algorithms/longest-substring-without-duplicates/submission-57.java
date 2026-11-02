class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int longest = 0, i = 0;

        for (int j=0; j<s.length(); j++) {
            while (charSet.contains(s.charAt(j))) {
                charSet.remove(s.charAt(i));
                i++;
            }
            charSet.add(s.charAt(j));
            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }
}
