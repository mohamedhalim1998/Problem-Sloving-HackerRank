import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HR_RepeatedString {
    public static long repeatedString(String s, long n) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a'){
                c++;
            }
        }
        long count = c * (n / s.length());
        for (int i = 0; i < n % s.length(); i++) {
            if(s.charAt(i) == 'a'){
                count++;
            }
        }
        return count;

    }


}