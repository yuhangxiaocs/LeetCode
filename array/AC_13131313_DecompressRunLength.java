import java.util.ArrayList;

public class AC_13131313_DecompressRunLength {

    static public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i * 2 < nums.length; i++) {
            for (int j = 0; j < nums[2 * i]; j++)
                arrayList.add(nums[2 * i + 1]);
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = arrayList.get(i);
        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4 };
        int[] t = decompressRLElist(array);
        for (int x : t)
            System.out.print(x + " ");
    }
}