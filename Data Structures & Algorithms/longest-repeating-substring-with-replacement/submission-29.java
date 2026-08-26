class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();

        for (char c: s.toCharArray()) {
            charSet.add(c);
        }

        int res = 0;

        for (char c: charSet) {
            int count = 0, i = 0;
            
            for (int j=0; j<s.length(); j++) {
                if (s.charAt(j) == c) {
                    count++;
                }

                while ((j - i + 1) - count > k) {
                    if (s.charAt(i) == c) {
                        count--;
                    }
                    i++;
                }
                res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}
