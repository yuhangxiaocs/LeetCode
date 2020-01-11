// package dp;

public class LC_32_ValidParentheses {

    static public boolean match(char a, char b) {
        return (a == '(') && (b == ')');
    }

    static public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        int len = s.length();
        int[] dp = new int[len]; //默认都是0
        dp[0] = 0;
        int maxv = 0;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(')
                continue;
            if (s.charAt(i - 1) == '(')
                dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
            else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(')
                dp[i] = dp[i - 1] + (i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0) + 2;
            maxv = Math.max(maxv, dp[i]);
            // 这里其实少了个else dp[i] = 0但是由于默认值都是0，就省略了
        }
        return maxv;
    }

    public static void main(String[] args) {
        // System.out.println(longestValidParentheses("()((()"));
        // System.out.println(longestValidParentheses(")()())"));
        // System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("())"));
        // System.out.println(longestValidParentheses("("));
        System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));
        System.out.println(longestValidParentheses("()(())"));

    }
}

/*

        int len = s.length();
        int gap = 1;
        int max = 0;
        int[][] dp = new int[len][len];
        // init
        for (int i = 0; i + gap < len; i++) {
            if (match(s.charAt(i), s.charAt(i + gap))) {
                dp[i][i + gap] = 1;
                max = gap + 1;
            }
        }

        for (gap = 3; gap < len; gap += 2) {
            for (int i = 0; i + gap < len; i++) {
                int j = i + gap;
                if (match(s.charAt(i), s.charAt(j)) == true && (dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    max = gap + 1;
                } else if (match(s.charAt(i), s.charAt(i + 1)) == true && (dp[i + 2][j] == 1)) {
                    dp[i][j] = 1;
                    max = gap + 1;
                } else if (match(s.charAt(j - 1), s.charAt(j)) == true && (dp[i][j - 2] == 1)) {
                    dp[i][j] = 1;
                    max = gap + 1;
                }
            }
        }


        // 感觉上面是对的 至少少了一点 只要将各个区间合并就可以了

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(dp[i][j] == 1)
                {
                    for(int k=len;k>j;k--)
                    if(dp[j][k]==1)
                    dp[j]
                }
            }
        }


        System.out.print("  ");

        for (int i = 0; i < len; i++)
            System.out.print(i % 10 + " ");
        System.out.println();

        for (int i = 0; i < len; i++) {
            System.out.print(i + " ");

            for (int j = 0; j < len; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return max;

 */