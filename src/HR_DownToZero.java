import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class HR_DownToZero {
    static int[] moves = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= 1000000; ++i) {
            int least = moves[i - 1];
            for (int j = 2; j * j <= i; ++j) {
                if (i % j == 0) {
                    least = Math.min(least, moves[i / j]);
                }
            }
            moves[i] = ++least;
        }

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int downToZero(int n) {


        return moves[n];
    }

}