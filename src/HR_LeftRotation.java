import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HR_LeftRotation {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = d; i < d + a.size(); i++){
            int index = i;
            if(index >= a.size()){
                index -= a.size();
            }
            res.add(a.get(index));
        }
        return res;

    }

}