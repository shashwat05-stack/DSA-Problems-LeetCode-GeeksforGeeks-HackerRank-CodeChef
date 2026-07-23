class Solution {
    public int reverse(int x) {
        int reverse = 0;

        while(x != 0){
            x = x/10;
            int digit = x % 10;
            
            reverse = reverse * 10 + digit;
            
        }
        return reverse;
    }
        }