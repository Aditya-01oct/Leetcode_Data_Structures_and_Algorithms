class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size(), minSum = Integer.MAX_VALUE ;

        for(int i = 0; i < n; ++i) {

            int sum = 0 ;

            for(int j = i; j < Math.min(i + r, n); ++j) {

                sum += nums.get(j) ;

                if(j - i + 1 >= l && sum > 0 && sum < minSum) {
                    minSum = sum ;
                }

            }

        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum ;

    }
}
