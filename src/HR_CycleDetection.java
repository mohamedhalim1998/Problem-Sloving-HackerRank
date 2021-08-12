import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class HR_CycleDetection {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }


    static boolean hasCycle(SinglyLinkedListNode head) {
        HashSet<SinglyLinkedListNode> set = new HashSet<>();
        while (head != null) {
            if(set.contains(head)){
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;

    }
}