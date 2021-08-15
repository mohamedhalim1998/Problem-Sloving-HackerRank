import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Helper {

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void printArrayInLine(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void printArrayInLine(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static int log2(int N) {

        return (int) (Math.log(N) / Math.log(2));
    }


    public static int[] sort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int half = a.length / 2;
        int[] first = Arrays.copyOfRange(a, 0, half);
        int[] second = Arrays.copyOfRange(a, half, a.length);

        return merge(sort(first), sort(second));
    }

    private static int[] merge(int[] first, int[] second) {
        int[] res = new int[first.length + second.length];
        for (int i = 0, j = 0, k = 0; i < res.length; i++) {
            if (j < first.length && k < second.length) {
                res[i] = first[j] < second[k] ? first[j++] : second[k++];
            } else if (j < first.length) {
                res[i] = first[j++];
            } else {
                res[i] = second[k++];
            }
        }
        return res;
    }

    public static char[] sort(char[] a) {
        if (a.length <= 1) {
            return a;
        }
        int half = a.length / 2;
        char[] first = Arrays.copyOfRange(a, 0, half);
        char[] second = Arrays.copyOfRange(a, half, a.length);

        return merge(sort(first), sort(second));
    }

    private static char[] merge(char[] first, char[] second) {
        char[] res = new char[first.length + second.length];
        for (int i = 0, j = 0, k = 0; i < res.length; i++) {
            if (j < first.length && k < second.length) {
                res[i] = first[j] < second[k] ? first[j++] : second[k++];
            } else if (j < first.length) {
                res[i] = first[j++];
            } else {
                res[i] = second[k++];
            }
        }
        return res;
    }

    static int greaterSearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > x) {
                end = mid - 1;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    static int lessSearch(Integer[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    public static long nCr(long n, long r) {
        long ans = 1;
        for (int k = 0; k < r; k++) {
            ans = ans * (n - k) / (k + 1);
        }

        return ans;
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    static ArrayList<Long> divisors(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        return list;
    }

    int[] neighbors = {0, 1,
            0, -1,
            1, 0,
            -1, 0,
            -1, -1,
            -1, 1,
            1, -1,
            1, 1};

    static void bitmask(int n) {
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }


    static class Pair implements Comparable<Pair> {
        int index, value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(pair.value, value);
        }
    }
}