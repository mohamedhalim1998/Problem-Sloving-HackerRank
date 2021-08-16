import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class HR_JumpingOnClouds {
    public static int jumpingOnClouds(List<Integer> c) {
        int count = 0;
        int i;
        for (i = 0; i < c.size() - 2; i++) {
            if (c.get(i + 2) == 0) {
                i++;
            }
            count++;
        }
        if (i >= c.size() - 1)
            return count;
        return count + 1;
    }

}