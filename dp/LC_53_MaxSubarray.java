public class LC_53_MaxSubarray {

    // 要求连续 如果都是负数 返回负数
    static public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum > maxSum)
                maxSum = sum;
                // 这样设计就既可以统计整数可以统计负数
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = { -2, -1, 0, 1, 2, -1, 8 };
        System.out.println(maxSubArray(array));

    }
}