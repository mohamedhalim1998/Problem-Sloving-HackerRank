import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HR_FrequencyQueries {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> value = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (List<Integer> list : queries) {
            int x = list.get(0);
            int y = list.get(1);
            if (x == 1) {
                map.put(y, map.getOrDefault(y, 0) + 1);
                int a = map.get(y);
                value.put(a, value.getOrDefault(a, 0) + 1);
                if (value.containsKey(a - 1)) {
                    value.put(a - 1, value.get(a - 1) - 1);
                }
            } else if (x == 2) {
                if (map.containsKey(y)) {
                    map.put(y, map.getOrDefault(y, 0) - 1);

                    int a = map.get(y);
                    value.put(a, value.getOrDefault(a, 0) + 1);
                    value.put(a - 1, value.get(a + 1) - 1);
                }

            } else {
                if (value.getOrDefault(y, 0) > 0 || y == 0) {
                    res.add(1);
                } else {
                    res.add(0);
                }
            }
        }
        return res;

    }
}