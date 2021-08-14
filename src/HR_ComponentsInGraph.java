import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HR_ComponentsInGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                gb.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = componentsInGraph(gb);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        List<List<Integer>> graph = new ArrayList<>();
        int size = 0;
        for (List<Integer> list : gb) {
            for (int x : list) {
                size = Math.max(size, x);
            }
        }
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> list : gb) {
            int x = list.get(0) - 1;
            int y = list.get(1) - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        boolean[] visited = new boolean[size];
        int min = Integer.MAX_VALUE;
        int max = 2;
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                int n = dfs(graph, visited, i);
                if(n > 1)
                    min = Math.min(min, n);
                max = Math.max(max, n);
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(min);
        res.add(max);
        return res;
    }

    private static int dfs(List<List<Integer>> graph, boolean[] visited, int i) {
        int n = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if(visited[curr]){
                continue;
            }
            visited[curr] = true;
            n++;
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.push(x);
                }
            }
        }
        return n;
    }


}