public class AC_1025_divisorgame_dp {

    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++)
                if (dp[i - j] == false && i % j == 0) {
                    dp[i] = true;
                    break;
                }
        }
        return dp[N];
    }

    public boolean divisorGame(int N, int second_solution) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        boolean result = new AC_1025_divisorgame_dp().divisorGame(100);
        System.out.println(result);
    }
}