import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElementII {


    /**
     * 用的还是1的思路，只不过这里map中的key放的是下标以防止重复 否则就会覆盖了
     * 
     * 
     * 
     * 之所以没用循环数组的%性质 是绝对浪费时间 但是这样一来就要用两倍的数组 空间就大了 实际上可以的
     */
    static public int[] nextGreaterElements(int[] nums) {
        int[] longnums = new int[nums.length * 2];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < longnums.length; i++) {
            longnums[i] = (i < nums.length) ? nums[i] : nums[i - nums.length];
            while (!stack.empty() && longnums[i] > longnums[stack.peek()])
                map.put(stack.pop(), longnums[i]);
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.getOrDefault(i, -1);
        }

        return nums;
    }
    
    /*
     * 高票答案思路
     *  public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }
     */

    // [120, 11, 120, 120, 123, 123, -1, 100, 100, 100]
    // [120, 11, 120, 120, 123, 123, -1, 100, 100, 100]
    public static void main(String[] args) {
        // 用第一题的解法就错了 第一题是说不重复 这里的第一个1后面是11第二个1后面是100所以覆盖了
        // int[] nums1 = { 100, 1, 11, 1, 120, 111, 123, 1, -1, -100 };
        int[] nums1 = { 1, 2, 1 };
        int[] res = nextGreaterElements(nums1);
        System.out.println(Arrays.toString(res));
    }
}