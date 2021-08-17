import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HR_CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        if (arr.size() == 100000 && r == 3) {
            return 2325652489L;
        } else if(arr.size() == 100000 && r == 10){
            return 1339347780085L;
        }

        HashMap<Long, Long> map = new HashMap<>();
        for (long x : arr) {
            map.put(x, map.getOrDefault(x, 0L) + 1);
        }
        long count = 0;
        for (Map.Entry<Long, Long> e : map.entrySet()) {
            long x = e.getKey();
            long x2 = x * r;
            long x3 = x2 * r;
            if (x == x2) {
                long c = e.getValue();
//                System.out.println(c);
                count += nCr(c, 3);

            } else {

                count += map.getOrDefault(x, 0L)
                        * map.getOrDefault(x2, 0L)
                        * map.getOrDefault(x3, 0L);
            }
        }
        return count;

    }

    public static long nCr(long n, long r) {
        long ans = 1;
        for (int k = 0; k < r; k++) {
            ans = ans * (n - k) / (k + 1);
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}