package N;

import java.io.*;
import java.util.*;

class Player implements Comparable<Player> {
    public int i, a;
    @Override
    public int compareTo(Player other) {
        return this.a - other.a;
    }

}
public class Main {
    static void update(int i) {
        i += tsize-1;
        tree[i] = 1; i/=2;
        while (0 < i) {
            tree[i] = tree[i*2]+tree[i*2+1];
            i/=2;
        }
    }
    static int search(int s, int e) {
        s += tsize-1;
        e += tsize-1;
        int sum = 0;
        while (s <= e) {
            if (1 == s%2) sum += tree[s++];
            if (0 == e%2) sum += tree[e--];
            s/=2; e/=2;
        }
        return sum;
    }
    static int N;
    static Player[] P = new Player[500001];
    static int[] tree = new int[2000001];
    static int tsize;
    static int[] Answer = new int[500001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = new Player();
            P[i].i = i;
            P[i].a = Integer.parseInt(br.readLine());
        }
        Arrays.sort(P, 1, N+1);
        for (tsize = 1; tsize < N; tsize*=2);
        for (int i = 0; i < tsize*2; i++) tree[i] = 0;
        for (int i = 1; i <= N; i++) {
            int low = search(1, P[i].i-1);
            Answer[P[i].i] = P[i].i-low;
            update(P[i].i);
        }
        for (int i = 1; i <= N; i++) {
            bw.write(Answer[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}