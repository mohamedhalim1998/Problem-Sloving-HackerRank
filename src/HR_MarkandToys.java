import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HR_MarkandToys {

    public static int maximumToys(List<Integer> prices, int k) {
        Collections.sort(prices);
        int i = 0;

        while (i < prices.size() && k > 0) {
            if(k - prices.get(i) >= 0){
                k -= prices.get(i);
                i++;
            } else{
                break;
            }


        }
        return i;

    }
}