class Solution {
    public int solve(int i, int j, int k, Integer[][][] dp, int[][] coins) {
        if (i == coins.length || j == coins[0].length) {
            return Integer.MIN_VALUE;
        } 
        if (i == coins.length - 1 && j == coins[0].length - 1) {
            if(coins[i][j] < 0 && k < 2){
                return 0;
            }
            return coins[i][j];
        } 
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        int down = solve(i + 1, j, k, dp, coins); 
        int right = solve(i, j + 1, k, dp, coins); 
        int take = coins[i][j] + Math.max(down, right);
        int not = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && k < 2) {
            int skipDown = solve(i + 1, j, k + 1, dp, coins); 
            int skipRight = solve(i, j + 1, k + 1, dp, coins); 
            not = Math.max(skipDown, skipRight);
        }
        return dp[i][j][k] = Math.max(take, not); 
    }
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        Integer dp[][][] = new Integer[m][n][3];
        return solve(0, 0, 0, dp, coins);
    }
}
