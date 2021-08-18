import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HR_SortingComparator {
    public int compare(Player a, Player b) {
        if(a.score != b.score){
            return Integer.compare(b.score, a.score);
        } else {
            return a.name.compareTo(b.name);
        }
    }

    private class Player {
        String name;
        int score;
    }
}