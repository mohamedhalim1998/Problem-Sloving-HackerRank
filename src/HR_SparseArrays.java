import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class HR_SparseArrays {
    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        Collections.sort(strings);
        List<Integer> res = new ArrayList<>();
        for (String q : queries) {
            int index = lessSearch(strings, q) + 1;
            int count = 0;
            while (index < strings.size() && strings.get(index).equals(q)) {
                count++;
                index++;
            }
            res.add(count);
        }
        return res;

    }

    static int lessSearch(List<String> arr, String x) {
        int start = 0, end = arr.size() - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid).compareTo(x) >= 0) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

}