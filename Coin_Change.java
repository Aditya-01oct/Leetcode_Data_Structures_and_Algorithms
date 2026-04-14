class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin);
            if (res >= 0 && res < minCount) {
                minCount = 1 + res;
            }
        }
        return (minCount == Integer.MAX_VALUE) ? -1 : minCount;
    }
}
