import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HR_CheckBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    static Node root = new Node(4, new Node(2, new Node(5), new Node(3)), new Node(6));

    public static void main(String[] args) {
        boolean res = checkBST(root);
        System.out.println(res);
    }


    static boolean checkBST(Node root) {
        List<Integer> list = new ArrayList<>();
      traverse(root, list);
      for(int i = 1; i < list.size();i++){
          if(list.get(i) <= list.get(i -1)){
              return false;
          }
      }
      return true;
    }
    public static void traverse(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traverse(node.left, list);
        list.add(node.data);
        traverse(node.right, list);

    }
}