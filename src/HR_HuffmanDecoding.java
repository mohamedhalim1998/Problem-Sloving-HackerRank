import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HR_HuffmanDecoding {
    // input is an array of frequencies, indexed by character code

        class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }


    void decode(String s, Node root) {
        StringBuilder out = new StringBuilder();
        Node curr = root;
        for (char c : s.toCharArray()) {

            if(c == '0'){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            if(curr.left == null && curr.right == null){
                out.append(curr.data);
                curr = root;
                continue;
            }
        }
        System.out.println(out);
    }

}