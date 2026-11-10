class Solution
{
    public int climbStairs(int n, int[] costs)
    {
        int r = 0;
        
        for(int i=0, f=0, s=0, t; i<n; i++, f=s, s=r, r=t)
            t = costs[i] + Math.min(Math.min(f+9,s+4),r+1);
        
        return r;
    }
}
