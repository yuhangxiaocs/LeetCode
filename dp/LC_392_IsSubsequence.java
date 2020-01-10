// package dp;

public class LC_392_IsSubsequence {

    static public boolean isSubsequence(String s, String t) {
        // 算法题的边界值是一定要考虑的 测试样例一定有边界
        if(s.length()==0)
            return true;
        if(t.length()==0)
            return false;
        int k = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(k))
                k++;
            if (k == s.length())
                break;
        }
        return k == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("", "ahbgdc"));
        System.out.println(isSubsequence("axc", ""));
        System.out.println(isSubsequence("agc", "ahbgdc"));

    }
}