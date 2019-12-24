public class AC_0005_Manacher {

    public static String Manacher(String string) {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            s.append("#");
            s.append(string.charAt(i));
        }
        s.append("#");
        int[] p = new int[s.length()];
        /*
         * C center
         * R right border
         * rad radius
         */
        int C = 0, R = -1, rad;
        for (int i = 0; i < s.length(); i++) {
            if (i <= R)
                rad = Math.min(p[2 * C - i], R - i);
            else
                rad = 0;
            // extend right border
            while (i + rad < s.length() && i - rad >= 0 && s.charAt(i + rad) == s.charAt(i - rad))
                rad++;

            // update result
            p[i] = rad;
            // check if update right border R and center C
            if (R < i + rad - 1) {
                R = i + rad - 1;
                C = i;
            }
        }

        System.out.print(s);
        return "";
    }

    public static void main(String[] args) {
        Manacher("abbq");
    }
}