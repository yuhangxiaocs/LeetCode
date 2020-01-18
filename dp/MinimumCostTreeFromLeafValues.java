import java.util.Stack;

public class MinimumCostTreeFromLeafValues {

    static public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        // 放一个哨兵
        stack.push(Integer.MAX_VALUE);
        // 用stack维护一个递减的顺序
        for (int a : arr) {
            while (a >= stack.peek()) {
                // 中间的就可以移除了 因为它是要求最大的乘积 所以这里没有用了
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }

            stack.push(a);
        }

        // 必须要是一个pop一个peek
        while (stack.size() > 2)
            res += stack.pop() * stack.peek();

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 15, 13, 5, 3, 15 };
        int result = mctFromLeafValues(arr);
        System.out.println(result);
    }
}

/*
    * 这个思路不对哦！！！ 

   static public int mctFromLeafValues(int[] arr) {
       if (arr == null || arr.length < 2)
           return 0;

       // 到i为止最大的元素
       int[] max = new int[arr.length];
       int maxV = Integer.MIN_VALUE;
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] > maxV)
               maxV = arr[i];
           max[i] = maxV;
       }

       int[] dp = new int[arr.length];

       dp[0] = 0;
       dp[1] = arr[0] * arr[1];

       for (int i = 2; i < arr.length; i++) {

           dp[i] = Math.min(dp[i - 1] + max[i - 1] * arr[i],
                   dp[i - 2] + max[i - 2] * Math.max(arr[i], arr[i - 1]) + arr[i - 1] * arr[i]);
       }
       for (int i : dp) {
           System.out.print(i + " ");
       }
       return dp[arr.length - 1];
   }
   
   
*/