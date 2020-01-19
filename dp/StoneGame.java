public class StoneGame {


    static public boolean stoneGame(int[] piles) {
        
        int[] dp = new int[piles.length];
        dp[1] = Math.max(piles[0], piles[1]);
        dp[0] = 0;
        for (int i = 2; i < dp.length; i+=2) {
            dp[i] = 
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {};
        boolean res = stoneGame(arr);
        System.out.println(res);
    }
}