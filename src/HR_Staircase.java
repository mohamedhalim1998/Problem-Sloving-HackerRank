import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HR_Staircase {
    public static void staircase(int n) {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            for (int j = n - i; j > 0 ; j--) {
                out.append(' ');
            }
            for (int j = 0; j < i; j++) {
                out.append('#');
            }
            out.append('\n');
        }
        System.out.println(out);

    }

}