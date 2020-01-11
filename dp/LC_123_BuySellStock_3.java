public class LC_123_BuySellStock_3 {

    static public int maxProfit(int[] prices) {
       
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };

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