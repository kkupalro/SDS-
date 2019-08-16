package J;

import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static int[] A = new int[100001];
    static long[] tree = new long[400000];
    static int tsize;
    static void update(int i, int v) {
        i += tsize+1;
        tree[i] = v;
        i /= 2;
        while (0 < i) {
            tree[i] = tree[i*2] + tree[i*2+1];
            i /= 2;
        }
    }
    static long search(int s, int e) {
        s += tsize+1;
        e += tsize+1;
        long ret = 0;
        while (s <= e) {
            if (1 == s%2) ret += tree[s++];
            if (0 == e%2) ret += tree[e--];
            s /= 2; e /= 2;
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        for (tsize = 1; tsize < N; tsize*=2);
        for (int i = 1; i < 2*tsize; i++) tree[i] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            update(i, A[i]);
        }
        int x, y, a, b;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (x <= y) bw.write(search(x, y) + "\n");
            else bw.write(search(y, x) + "\n");
            update(a, b);
        }
        bw.flush();
        bw.close();
    }
}
