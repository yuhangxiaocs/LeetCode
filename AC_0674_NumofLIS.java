import java.util.Arrays;

public class AC_0674_NumofLIS {
    static public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;

        int[] dp = new int[n];
        int[] record = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(record, 1);

        int max = -1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        record[i] = record[j];
                    } else if (dp[j] + 1 == dp[i])
                        record[i] += record[j];
                }
            max = Math.max(max, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max)
                ans += record[i];
        }

        for (int i : nums)
            System.out.print(i + " ");

        System.out.print("\n");

        for (int i : dp)
            System.out.print(i + " ");

        System.out.print("\n");

        for (int i : record)
            System.out.print(i + " ");

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