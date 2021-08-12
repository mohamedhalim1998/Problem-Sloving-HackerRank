import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class HR_QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 1) {
                int e = scanner.nextInt();
                s1.add(e);
            } else if (x == 2) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.add(s1.pop());
                    }
                }
                s2.pop();
            } else {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.add(s1.pop());
                    }
                }
                System.out.println(s2.peek());
            }
        }
    }

}