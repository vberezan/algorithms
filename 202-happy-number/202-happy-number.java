class Solution {
    int x = 0;
    
    public boolean isHappy(int n) {
        int slow = n;
        int fast = next(n);
        
        while (fast > 1 && slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        
        return fast == 1;
    }
    
    private static int next(int n) {
        int result = 0;
        
        while (n > 0) {
            int last = n % 10;
            n = n / 10;
            
            result += Math.pow(last, 2);
        }
        
        return result;
    }
}