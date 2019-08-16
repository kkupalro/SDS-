package H;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] tree = new int[4000004];
    static int tsize;
    static void update(int i, int v) {
        i += tsize;
        tree[i] += v;
        i /= 2;
        while (0 < i) {
            tree[i] = tree[i*2] + tree[i*2+1];
            i /= 2;
        }
    }
    static int search(int r) {
        int i = 1;
        tree[i]--;
        while (tsize > i) {
            if (tree[i*2] >= r) { i = i*2; tree[i]--; }
            else { r -= tree[i*2]; i = i*2+1; tree[i]--; }
        }
        return i-tsize;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        for (tsize = 1; tsize < 1000001; tsize*=2);
        for (int i = 1; i < 2*tsize; i++) tree[i] = 0;
        N = Integer.parseInt(br.readLine());
        int A, B, C;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            switch (A) {
            case 1:
                bw.write(search(B) + "\n");
                break;
            case 2:
                C = Integer.parseInt(st.nextToken());
                update(B, C);
                break;
            }   
        }
        bw.flush();
        bw.close();
    }
}