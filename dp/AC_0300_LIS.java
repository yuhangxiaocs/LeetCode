public class AC_0300_LIS {
    static public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n];  //初始化为0
        int maxLength = 0;  //这里设置为0就够了 不满足的话最后也+1 得到正确结果
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxLength)
                        maxLength = dp[i];
                }
        }
        // 由于初始化为0 这里要+1,因为最小也是1，一个元素
        return maxLength + 1;
    }

    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4, 5 };
        int result = lengthOfLIS(test);
        System.out.println(result);
    }
}