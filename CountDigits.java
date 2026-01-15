//This is already a optimized code hence no need to optimize it.

class Solution {
    public int countDigits(int num) {
        int org = num,count = 0;
        while(org>0){
            int dig = org%10;
            if(num%dig == 0)
                count++;
            org/=10;
        }
        return count;
    }
}
