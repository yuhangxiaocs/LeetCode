public class AC_0005_LPS {
    public String longestPalindrome(String s) {
        int N = s.length();
        int[][] dp = new int[N + 1][N + 1];
        // initialize dp
        for (int i = 0; i < N; i++)
            dp[i][i] = 1;
        for (int i = 0; i < N - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = 1;
            else
                dp[i][i + 1] = 0;

        // 

        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                if (s.charAt(j) == s.charAt(j + i))
                    dp[j][j + i] = 1;
                else
                    dp[j][j + i] = 0;

            }
        }

        int max = -99;
        int mi = 0, mj = 0;
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                if (dp[i][j] == 1 && (j - i + 1) > max) {
                    max = j - i + 1;
                    mi = i;
                    mj = j;
                }

        return "i " + mi + " j " + mj + " max " + max;
        // return s.substring(mi, mj + 1);
    }

    public static void main(String[] args) {
        String result = new AC_0005_LPS().longestPalindrome("cbbd");
        System.out.print(result);
    }
}

/*

        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                if (s.charAt(j) == s.charAt(j + i))
                    dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                else
                    dp[j][j + i] = dp[j + 1][j + i - 1];

            }
        }
        
        这样写，可以快速判断最大值，结果就在dp[0][N-1]上，但是不能判断具体在哪
        比如abbd，在算最外面的时候，会通过dp[0][3] = dp[1][2] = 2;
        这里更长的虽然不会继续更新，但是会把其中最好的结果保存下来;

 */