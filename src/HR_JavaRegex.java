import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

public class HR_JavaRegex {
    static class MyRegex {
        String pattern = "([0-1][0-9][0-9]|2[0-4][0-9]|25[0-5]|[0-9][0-9]|[0-9])\\." +
                         "([0-1][0-9][0-9]|2[0-4][0-9]|25[0-5]|[0-9][0-9]|[0-9])\\." +
                         "([0-1][0-9][0-9]|2[0-4][0-9]|25[0-5]|[0-9][0-9]|[0-9])\\." +
                         "([0-1][0-9][0-9]|2[0-4][0-9]|25[0-5]|[0-9][0-9]|[0-9])";
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}