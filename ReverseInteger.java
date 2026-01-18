class Solution {
    public int reverse(int x) {
        int rem=0,num=0;
        while(x!=0){
            rem = x%10;
            if (num > Integer.MAX_VALUE / 10 || 
               (num == Integer.MAX_VALUE / 10 && rem > 7))
                return 0;
            if (num < Integer.MIN_VALUE / 10 || 
               (num == Integer.MIN_VALUE / 10 && rem < -8))
                return 0;
            num = num*10+rem;
            x/=10;
        }
        return num;
    }
}
