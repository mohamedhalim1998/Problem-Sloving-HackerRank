import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class HR_SalesMatch {
    public static int sockMerchant(int n, List<Integer> ar) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int x : ar){
            if(set.contains(x)){
                set.remove(x);
                count++;
            } else {
                set.add(x);
            }
        }
        return count;

    }
}