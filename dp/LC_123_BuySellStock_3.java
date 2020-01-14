import java.util.Arrays;

public class LC_123_BuySellStock_3 {

    // 99.48% 100% solution
    static public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int len = prices.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        int min = prices[0];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(prices[i] - min, max);
            dp1[i] = max;
        }

        int maxPro = Integer.MIN_VALUE;

        // 后半段最高价格
        max = Integer.MIN_VALUE;
        int maxsell = prices[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            maxsell = Math.max(maxsell, prices[i]);
            max = Math.max(max, maxsell - prices[i]);
            dp2[i] = max;

            // 计算最终价格 两段合并
            maxPro = Math.max(maxPro, dp2[i] + dp1[i]);
        }

        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));

        return maxPro;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 10 };

        // 3 5 7 
        System.out.print(maxProfit(prices));
    }

}

/*
    static public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int firstMax = 0;
        int secondMax = 0;
        int curSum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1])
                curSum += prices[i] - prices[i - 1];
            else if (curSum >= firstMax) {
                System.out.println(i);
                secondMax = firstMax;
                firstMax = curSum;
                curSum = 0;
            } else if (curSum >= secondMax) {
                secondMax = curSum;
                curSum = 0;
            }

            if (i == prices.length - 1) {
                if (curSum >= firstMax) {
                    System.out.println(i);
                    secondMax = firstMax;
                    firstMax = curSum;
                    curSum = 0;
                } else if (curSum >= secondMax) {
                    secondMax = curSum;
                    curSum = 0;
                }
            }
        }

        return firstMax + secondMax;

    }
 */