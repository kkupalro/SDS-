package L;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] y = new int[50000];
    static int[] r = new int[50000];
    static int[] tree = new int[200000];
    static int tsize;
    static void update(int i, int v) {
        i += tsize;
        tree[i] = v;
        i /= 2;
        while (0 < i) {
            tree[i] = Math.max(tree[i*2], tree[i*2+1]);
            i /= 2;
        }
    }

    static int search(int s, int e) {
        s += tsize;
        e += tsize;
        int ret = 0;
        while (s <= e) {
            if (1 == s%2) ret = Math.max(ret, tree[s++]);
            if (0 == e%2) ret = Math.max(ret, tree[e--]);
            s /= 2; e /= 2;
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        for (tsize = 1; tsize < n; tsize*=2);
        for (int i = 1; i < 2*tsize; i++) tree[i] = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            y[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
            update(i, r[i]);
        }
        int X, Y;
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            int yi = Arrays.binarySearch(y, 0, n, Y);
            int xi = Arrays.binarySearch(y, 0, n, X);

            if (0 <= yi && 0 <= xi) {
                if (r[yi] < r[xi]) bw.write("false\n");
                else if (r[xi] <= search(yi+1, xi-1)) bw.write("false\n");
                else {
                    if (X-Y == xi-yi) bw.write("true\n");
                    else bw.write("maybe\n");
                }
            }
            else if (0 > yi && 0 > xi) {
                if (1000000000 == search(-1*yi-1, -1*xi-2)) bw.write("false\n");
                else bw.write("maybe\n");
            }
            else if (0 > yi) {
                if (r[xi] <= search(-1*yi-1, xi-1)) bw.write("false\n");
                else bw.write("maybe\n");
            }
            else if (0 > xi) {
                if (r[yi] <= search(yi+1, -1*xi-2)) bw.write("false\n");
                else bw.write("maybe\n");
            }
            bw.flush();
        }
        bw.flush();
        bw.close();
    }
}