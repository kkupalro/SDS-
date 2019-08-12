package H;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int N;
    private static int[][] W;
    private static int[][] d;

    private static final int INF = (int) (1e9 + 1);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine().trim());
        W = new int[16][16];
        d = new int[16][1 << 16];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 1 << N; j++) {
                d[i][j] = INF;
            }
        }

        System.out.println(tsp(0, 1));
    }

    private static int tsp(int c, int v) {
        if (v == (1 << N) - 1) {
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if (d[c][v] != INF) {
            return d[c][v];
        }
        for (int i = 0; i < N; i++) {
            if ((v & (1 << i)) == 0 && W[c][i] != 0) {
                d[c][v] = Math.min(d[c][v], tsp(i, (v | (1 << i))) + W[c][i]);
            }
        }
        return d[c][v];
    }
}