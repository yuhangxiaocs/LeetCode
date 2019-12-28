import java.util.Arrays;

public class AC_0674_NumofLIS {
    static public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;

        // dp：以i结尾的最长的递增序列长度
        // record：以i结尾的最长的递增序列的个数
        int[] dp = new int[n];
        int[] record = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(record, 1);

        int max = -1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j]) {
                    // 如果发现之前的比当前的长度长
                    // 那么更行dp，且这个时候由于是从j到i，所以到i的方式等于到j的方式
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        record[i] = record[j];
                        // 这里的意思是 如果有重复的等于 相当于有一条通往最大值的路径 就要加上这些新路径
                    } else if (dp[j] + 1 == dp[i])
                        record[i] += record[j];
                }
            // 记录最大长度用于后序的计算结果
            max = Math.max(max, dp[i]);
        }
        /* 这个程序要明确两点：
         * 1 最大值未必只出现一个地方（所以有下面的 if (dp[i] == max)判断 ）
         * 2 出现最大值的地方有可能是通过多种路径达到的最大值（所以要记录record数组 意思就是重复的路劲）
         */
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max)
                ans += record[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        // 1, 1, 2, 2, 2, 2, 3, 3, 3, 6, 6, 6
        int[] nums = { 1, 2, 4, 3, 5, 4, 7, 2 };
        int result = findNumberOfLIS(nums);
        System.out.println("\n" + result);
    }
}

/*

        for (int i : nums)
            System.out.print(i + " ");

        System.out.print("\n");

        for (int i : dp)
            System.out.print(i + " ");

        System.out.print("\n");

        for (int i : record)
            System.out.print(i + " ");

                    // 当序列递减时 返回序列长度
        boolean isDecrease = true;
        for (int i = 1; i < n; i++)
            if (nums[i] > nums[i - 1])
                isDecrease = false;
        if (isDecrease == true)
            return n;

*/