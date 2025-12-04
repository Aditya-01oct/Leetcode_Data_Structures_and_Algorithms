//brute force to find the positive number.
class Solution {
    public boolean checkPerfectNumber(int num) {
        int rem = 0;
        for(int i=1;i<=num/2;i++){
            if(num%i==0){
                rem = rem+i;
            }
        }
        if(rem==num)
            return true;
        else
            return false;
    }
}
