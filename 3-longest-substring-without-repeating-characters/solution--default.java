class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        int max = 0;
        
        while (fast++ < chars.length - 1) {

            int duplicate = findDuplicate(chars, slow, fast);
            
            if (duplicate < 0) {
                int size = fast - slow;
                if (size > max) max = size;
            } else {
                slow = duplicate + 1;
            }                   
        }
        
        return max + 1;
    }
    
    private static int findDuplicate(char[] chars, int start, int end) {
        for (int i = start; i < end; i++) {
            if (chars[i] == chars[end]) return i;
        }
        
        return -1;
    }
}