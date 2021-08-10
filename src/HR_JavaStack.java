import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class HR_JavaStack {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean res = true;
            for (char x : input.toCharArray()) {
                if ("({[".contains("" + x)) {
                    stack.push(x);
                } else if (x == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        res = false;
                        break;
                    }
                    stack.pop();
                } else if (x == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        res = false;                        break;
                    }
                    stack.pop();
                } else if (x == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        res = false;                        break;
                    }
                    stack.pop();
                }

            }
            if(!stack.isEmpty()){
                res = false;
            }
            System.out.println(res);
        }

    }
}