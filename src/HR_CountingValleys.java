import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HR_CountingValleys {
    public static int countingValleys(int steps, String path) {
        int l = 0;
        int count = 0;
        int p = 0;
        for (int i = 0; i < steps; i++) {
            p = l;
            if(path.charAt(i) == 'D'){
                l--;
            } else {
                l++;
            }
            if(l < 0 && p >= 0){
                count++;
            }
        }
        return count;

    }
}