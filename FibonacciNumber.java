//Brute force to find the fibonacci number.

class Solution {
    public int fib(int n) {
        int a=0,b=1;
        for(int i=1;i<n;i++){
            int temp=b;
            b=a+b;
            a=temp;
        }
        if(n<=1)
            return n;
        return b;
    }
}
