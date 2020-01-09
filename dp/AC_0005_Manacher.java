package dp;

public class AC_0005_Manacher {

    public static String Manacher(String s) {

        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            newString.append("#");
            newString.append(s.charAt(i));
        }
        newString.append("#");
        int[] p = new int[newString.length()];
        /*
         * C: center
         * R: right border
         * rad: radius
         */
        int C = 0, R = -1, rad;
        int maxC = -99, maxRad = -99;// in order to find the specfic solution
        for (int i = 0; i < newString.length(); i++) {
            if (i <= R)
                rad = Math.min(p[2 * C - i], R - i);
            else
                rad = 0;
            // extend right border
            while (i + rad + 1 < newString.length() && i - rad - 1 >= 0
                    && newString.charAt(i + rad + 1) == newString.charAt(i - rad - 1))
                rad++;

            // update result
            p[i] = rad;
            // check if update right border R and center C
            if (R < i + rad) {
                R = i + rad;
                C = i;
                if (rad > maxRad) {
                    maxRad = rad;
                    maxC = C;
                }
            }
        }
        int left = maxC - maxRad;
        return s.substring(left / 2, left / 2 + maxRad);
    }

    public static void main(String[] args) {
        String s = Manacher("aba");
        System.out.print(s);
    }
}

// 0 1 0 1 4 1 0 1 0
// 0 1 0 1 4 1 0 1 0
