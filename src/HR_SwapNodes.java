import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HR_SwapNodes {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> result = swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x : queries) {
            List<Integer> list = new ArrayList<>();
            swapNode(indexes, x, 1, 0);
            traverse(indexes, list, 0);
            res.add(list);

        }
        return res;

    }

    public static void swapNode(List<List<Integer>> indexes, int k, int h, int curr) {
        if (curr >= indexes.size() || curr < 0) {
            return;
        }
        if (h % k == 0) {
            int left = indexes.get(curr).get(0);
            int right = indexes.get(curr).get(1);
            indexes.get(curr).set(0, right);
            indexes.get(curr).set(1, left);
        }
        swapNode(indexes, k,h+1, indexes.get(curr).get(0) - 1);
        swapNode(indexes, k,h+1, indexes.get(curr).get(1) - 1);
    }

    public static void traverse(List<List<Integer>> indexes, List<Integer> list, int k) {
        if (k >= indexes.size() || k < 0) {
            return;
        }
        traverse(indexes, list, indexes.get(k).get(0) - 1);
        list.add(k + 1);
        traverse(indexes, list, indexes.get(k).get(1) - 1);

    }


}