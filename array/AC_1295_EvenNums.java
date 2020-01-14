public class AC_1295_EvenNums {

    /*
        给出一个数组，返回偶数位的数字个数，如[1,23,45,666]返回2，因为23和45是偶数位
        就是枚举而已 没什么方法提高速度
     */
    static public int findNumbers(int[] nums) {
        int evendigits = 0;
        for (int i = 0; i < nums.length; i++) {
            int digits = 0;
            while (nums[i] != 0) {
                nums[i] /= 10;
                digits++;
            }
            if (digits % 2 == 0)
                evendigits++;
        }

        return evendigits;
    }

    public static void main(String[] args) {
        int[] array = { 12, 345, 2, 6, 7896 };
        System.out.println(findNumbers(array));

    }
}