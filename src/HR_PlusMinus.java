import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class HR_PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float[] res = new float[3];
        for (int x : arr) {
            if (x > 0) {
                res[0]++;
            } else if (x < 0) {
                res[1]++;
            } else {
                res[2]++;
            }
        }
        for (float x : res) {
            System.out.printf("%.06f\n", x / arr.size());
        }

    }
}