import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        Map<Integer, ArrayList> map = new HashMap<Integer, ArrayList>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (map.get(groupSizes[i]) == null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                map.put(groupSizes[i], arrayList);
            }

            else
                map.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> res;
        for(int size:map.keySet()){
            for(int i=0;i<map.get(size).size();i+=size)

        }

    }

    public static void main(String[] args) {

    }
}