public class LC_198_HouseRobber {

    // 100% 100%
    static public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        }
        return dp[len - 1];

    }

    public static void main(String[] args) {
        int[] t = { 1, 2, 3, 1 };
        System.out.println(rob(t));
    }
}