import java.util.Arrays;

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

    public static void main(String[] args) {

        int[] nums1 = { 2, 4 }, nums2 = { 1, 2, 3, 4 };
        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}