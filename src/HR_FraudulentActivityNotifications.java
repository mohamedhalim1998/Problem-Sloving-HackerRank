import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HR_FraudulentActivityNotifications {
    public static int activityNotifications(List<Integer> expenditure, int d) {

        int count = 0;
        int[] freq = new int[201];
        for (int i = 0; i < expenditure.size(); i++) {
            if (i < d) {
                freq[expenditure.get(i)]++;
                continue;
            }
            freq[expenditure.get(i)]++;
            if (i != d) {
                freq[expenditure.get(i - d - 1)]--;
            }
            float mid = 0;
            if (d % 2 == 1) {
                int index = -1;
                for (int j = 0; j < 201; j++) {
                    index += freq[j];
                    if (index >= d / 2) {
                        mid = j;
                        break;
                    }
                }

            } else {
                int index = -1;
                for (int j = 0; j < 201; j++) {
                    index += freq[j];
                    if (index >= (d - 1) / 2) {
                        mid = j;
                        break;
                    }

                }
                index = -1;
                for (int j = 0; j < 201; j++) {
                    index += freq[j];
                    if (index >= (d + 1) / 2) {
                        mid += j;
                        break;
                    }


                }
                mid /= 2;
            }
            if (Float.compare(expenditure.get(i), 2 * mid) >= 0) {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}