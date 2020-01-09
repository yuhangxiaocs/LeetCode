public class AC_0746_climbstair_dp {

    /*
     *  p[n] = min(cost[n-1] + p[n-1], cost[n-2] + p[n-2])
     */
    static public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        if (N <= 2)
            return 0;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[N];
    }

    public static void main(String[] args) {

        int[] a = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        int result = minCostClimbingStairs(a);
        System.out.println(result);
    }
}