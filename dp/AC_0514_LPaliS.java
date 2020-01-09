package dp;

public class AC_0514_LPaliS {

    static public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1 == 0 || len2 == 0)
            return 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++) {
                // 注意下标-1
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        return dp[len1][len2];
    }

    static public int longestPalindromeSubseq(String s) {
        StringBuilder s1 = new StringBuilder(s);
        s1.reverse();
        return longestCommonSubsequence(s, new String(s1));

    }

    public static void main(String[] args) {
        int result = longestPalindromeSubseq("abbd");
        System.out.println(result);
    }
}