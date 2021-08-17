import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HR_TwoStrings {
    public static String twoStrings(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set.add(c);
        }
        for(char c : s2.toCharArray()){
            if(set.contains(c)){
                return "YES";

            }
        }
        return "NO";

    }

}