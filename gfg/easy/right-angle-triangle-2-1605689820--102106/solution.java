class Solution {
    public void printPattern(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i || i == n-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}