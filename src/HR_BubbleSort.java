import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HR_BubbleSort {
    public static void countSwaps(List<Integer> a) {
        int swap = 0;
        for (int i = 0; i < a.size(); i++) {

            for (int j = 0; j < a.size() - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a.get(j) > a.get(j + 1)) {
                    swap++;
                    int temp = a.get(j);

                    a.set(j, a.get(j + 1));
                    a.set(j + 1, temp);
                }
            }

        }
        System.out.printf("Array is sorted in %d swaps.\nFirst Element: %d\nLast Element: %d\n", swap, a.get(0), a.get(a.size() - 1));

    }

}