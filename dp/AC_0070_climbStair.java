package dp;

public class AC_0070_climbStair {

    static public int climbStairs(int n) {
        if (n == 1 || n == 0)
            return 1;
        if (n == 2)
            return 2;
        // 优化存储空间 不需要使用数组 所以空间是常量 
        int a = 1; //dp[0]
        int b = 2; //dp[1]
        int c = 0; //dp[i]
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int result = climbStairs(3);
        System.out.println(result);
    }
}