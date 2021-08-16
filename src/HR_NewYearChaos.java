import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HR_NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static void minimumBribes(List<Integer> q) {
        int count = 0;
        for (int i = 0; i < q.size(); i++) {
            int diff = q.get(i) - (i + 1);
            if (diff > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++)
                if (q.get(j) > q.get(i)) count++;
        }
        System.out.println(count);

    }

}