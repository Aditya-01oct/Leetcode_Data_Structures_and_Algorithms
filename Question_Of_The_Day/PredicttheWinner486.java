class Solution {

    public int helper(int[] nums, int i , int j, Integer[][] dp, int turn){
        if(i > j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int max = 0;

        if(turn % 2 != 0){
            max = Math.min(helper(nums, i + 1, j, dp, turn + 1), helper(nums, i, j - 1, dp, turn + 1));
        }else{
            max = Math.max(nums[i] + helper(nums, i+1 , j, dp, turn+1), nums[j] + helper(nums, i, j-1, dp, turn + 1));
        }

        return dp[i][j] = max;
    }


    public boolean predictTheWinner(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];

        int score = helper(nums, 0 , nums.length - 1, dp, 0);

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int required = sum%2 == 0 ? sum/2 : (sum + 1)/2;
        if(score >= required) return true;
        return false;
    }
}
