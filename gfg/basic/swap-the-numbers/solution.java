class Solution {
    public void swap(int a, int b) {
        // code here

        int temp = a;
        a = b;
        b = temp;

        List<Integer> ans = new ArrayList<>();
        ans.add(a);
        ans.add(b);

        
        System.out.println(a + " " + b);
    }
}
