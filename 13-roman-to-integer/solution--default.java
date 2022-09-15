class Solution {
    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int n = number(s.charAt(i));
            
            if (n < number(s.charAt(i + 1))) result -= n;
            else result += n;
        }
     
        return result + number(s.charAt(s.length() - 1));
    }
    
    private static int number(char ch) {                
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}