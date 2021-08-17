import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class HR_RansomNote {
    public static void checkMagazine(List<String> magazine, List<String> note) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : magazine) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : note) {
            if (map.getOrDefault(s, 0) <= 0) {
                System.out.println("No");
                return;
            } else {
                map.put(s, map.getOrDefault(s, 0) - 1);
            }
        }
        System.out.println("Yes");

    }

}