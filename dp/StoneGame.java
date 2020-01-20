public class StoneGame {

    /*
     * 这里的dp[i][j]表示在
     * 这里将问题进行了转化，如果另一个人得分 就将得分算为负数加到对手头上
     * 
     * 为什么这里就用二维dp呢，是和问题有关（废话），这里的问题不能单纯通过一边增加来增加
     * 它是两个方向都有可能的，就是选的时候，两边都可以 
     */
    static public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = piles[i];

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2 };
        boolean res = stoneGame(arr);
        System.out.println(res);
    }
}