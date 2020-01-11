public class LC_309_BuySellStock_2 {

    static public int maxProfit(int[] prices) {
        int sold = 0;
        int rest = 0;
        int hold = Integer.MIN_VALUE;

        for (int price : prices) {
            int prev_sold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prev_sold);
        }

        return Math.max(rest, sold);
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.print(maxProfit(prices));
    }
}