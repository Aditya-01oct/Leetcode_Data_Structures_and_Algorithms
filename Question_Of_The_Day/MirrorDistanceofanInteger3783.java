class Solution {
    public int mirrorDistance(int n) {
        int org =n,rev = 0;
        while(n!=0){
            int rem = n%10;
            n/=10;
            rev = rev*10+rem;
        }
        if(org>rev){
            return org-rev;
        }
        else{
            return rev-org;
        }
    }
}
