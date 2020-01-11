public class LC_1277_CountSquareMatrix {

    // 54 100 solution
    static public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // dp表示以[i][j]为右下角的正方形的个数
        int[][] dp = new int[m][n];
        int total = 0;
        // init
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == 1 ? 1 : 0;
            total += dp[i][0];
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == 1 ? 1 : 0;
            total += dp[0][i];
        }
        // 减去重复计算的第一个元素
        if (matrix[0][0] == 1)
            total--;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1)
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                total += dp[i][j];
            }
        }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return total;
    }

    public static void main(String[] args) {
        int[][] matrix = { 
            { 1}, 
            };
        System.out.println(countSquares(matrix));
    }
}