class Solution {
    public int nthDay(int d, int n) {
        // code here
        n = n % 7;
        return (d - n + 7) % 7;
    }
}