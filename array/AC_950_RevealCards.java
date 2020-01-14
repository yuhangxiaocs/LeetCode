import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AC_950_RevealCards {


    /*
        用队列来模拟过程即可
        95% 14% solution
    */
    static public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int len = deck.length;

        int[] res = new int[len];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < len; i++)
            q.add(i);

        for (int i = 0; i < len; i++) {
            res[q.poll()] = deck[i];
            q.add(q.poll());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] t = { 17, 13, 11, 2, 3, 5, 7 };
        deckRevealedIncreasing(t);
    }
}