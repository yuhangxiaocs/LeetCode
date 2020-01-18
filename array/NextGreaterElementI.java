import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    static public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            for (; j < nums2.length; j++)
                if (nums2[j] == nums1[i])
                    break;
            for (; j < nums2.length; j++)
                if (nums2[j] > nums1[i])
                    break;

            if (j < nums2.length)
                nums1[i] = nums2[j];
            else
                nums1[i] = -1;
        }
        return nums1;
    }

    /*
     * 这用用stack来辅助，用map来记录，减少时间复杂度
     * 对于[6, 5, 3, 7, 8]只要当前的比栈顶小就一直进去，相当于维护一个递减的顺序
     * 然后遇到一个大于栈顶的元素后，将所有小于当前的都pop出来，这些数和当前的数分别组成key 和value
     * 放到map中 效果就来了
     * 
     * 思路巧妙 gan！
     */
    static public int[] nextGreaterElement(int[] nums1, int[] nums2, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }

    public static void main(String[] args) {

        int[] nums1 = { 2, 4 }, nums2 = { 1, 2, 3, 4 };
        int[] res = nextGreaterElement(nums1, nums2, 4);
        System.out.println(Arrays.toString(res));
    }
}