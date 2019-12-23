public class Solution_1025 {

    public boolean divisorGame(int N) {
        if (N == 1)
            return false;
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++)
                if (i % j == 0 && dp[i - j] == false) {
                    dp[i] = true;
                    break;
                }

        }
        return dp[N];
    }

    public static void main(String[] args) {
        boolean result = new Solution_1025().divisorGame(100);
        System.out.println(result);
    }
}