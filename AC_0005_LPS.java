public class AC_0005_LPS {
    public String longestPalindrome(String s) {
        int N = s.length();
        int[][] dp = new int[N + 1][N + 1];
        // initialize dp
        for (int i = 0; i < N; i++)
            dp[i][i] = 1;
        for (int i = 0; i < N - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = 2;
        // 

        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                if (s.charAt(j) == s.charAt(j + i))
                    dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                else
                    dp[j][j + i] = dp[j + 1][j + i - 1];

            }
        }

        int max = -99;
        int mi = 0, mj = 0;
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    mi = i;
                    mj = j;
                }

        return "i " + mi + " j " + mj + " max " + max;
    }

    public static void main(String[] args) {
        String result = new AC_0005_LPS().longestPalindrome("accaaaaa");
        System.out.print(result);
    }
}