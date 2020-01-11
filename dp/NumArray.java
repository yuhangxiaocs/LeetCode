public class NumArray {
    private int[] sumAt;

    // 这个方法中因为创建了数组 所以多了额外的空间复杂度
    public NumArray(int[] nums) {
        // 第一个存0，因为是要inclusive的和
        sumAt = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumAt[i + 1] = sum;
        }
    }
    // 这里之所以省空间 就是直接引用 而不需要new，没有引入额外的空间，就是常数空间
    public NumArray(int[] nums, int anothersolution) {
        sumAt = nums;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumAt[i] = sum;
        }

    }

    public int sumRange(int i, int j) {
        return sumAt[j + 1] - sumAt[i];
    }

    public int sumRange(int i, int j, int anothersolution) {
        return sumAt[j] - (i - 1 >= 0 ? sumAt[i - 1] : 0);
    }

    /*
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray obj = new NumArray(nums, 1);
        int result = obj.sumRange(0, 5, 0x8888);
        System.out.println(result);
    }
}