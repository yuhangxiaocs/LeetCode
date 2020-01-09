package dp;

import java.util.Arrays;

public class LC_62_uniquePath {

    static public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1)
            return 1;
        int[][] dp = new int[m][n];
        // init
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    static public int uniquePaths(int m, int n, int solutionwithLessSpace) {
        if (m <= 1 || n <= 1)
            return 1;
        int[] dp = new int[n];
        // init
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            // 注意 每次在使用i-1时实际上i—1已经变成当前行了
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    static public int F(int n) {
        if (n <= 1)
            return 1;
        int result = 1;
        while (n >= 1) {
            result *= n;
            --n;
        }
        return result;
    }

    // 组合数
    static public int Combination(int m, int n) {
        System.out.println(F(m));
        System.out.println(F(n));
        System.out.println(F(m - n));
        return F(m) / (F(n) * F(m - n));
    }

    static public int uniquePaths(int m, int n, String x) {
        if (m <= 1 || n <= 1)
            return 1;
        return Combination(m + n - 2, m - 1);
    }

    public static void main(String[] args) {
        int result = uniquePaths(0, 0);
        result = uniquePaths(3, 2, 1);
        result = uniquePaths(10, 10, "s");
        System.out.println(result);
    }
}