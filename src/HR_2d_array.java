import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_2d_array {
    public static class Solution {

        // Complete the hourglassSum function below.
        static int hourglassSum(int[][] arr) {
            /*
            a b c
              d
            e f g
             */
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    Pair a = new Pair(i, j);
                    Pair b = new Pair(i, j + 1);
                    Pair c = new Pair(i, j + 2);
                    Pair d = new Pair(i + 1, j + 1);
                    Pair e = new Pair(i + 2, j);
                    Pair f = new Pair(i + 2, j + 1);
                    Pair g = new Pair(i + 2, j + 2);
                    if (valid(a, b, c, d, e, f, g)) {
                        max = Math.max(max, sum(arr, a, b, c, d, e, f, g));
                    }

                }
            }

            return max;
        }

        private static int sum(int[][] arr, Pair... pairs) {
            int s = 0;
            for (Pair p : pairs) {
                s += arr[p.x][p.y];
            }
            return s;
        }

        static boolean valid(Pair... pairs) {
            boolean res = true;
            for (Pair p : pairs)
                res = res &&  p.x >= 0 && p.y >= 0 && p.x < 6 && p.y < 6;
            return res;
        }

        static class Pair {
            int x, y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
      //      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int[][] arr = new int[6][6];

            for (int i = 0; i < 6; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 6; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    arr[i][j] = arrItem;
                }
            }

            int result = hourglassSum(arr);

            System.out.println(result);

            scanner.close();
        }
    }

}
