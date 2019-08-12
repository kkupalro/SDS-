package J;

import java.io.*;
import java.util.*;

public class Main {

    static int N, W;
    static int[] r = new int[1001];
    static int[] c = new int[1001];
    static int[] S = new int[1001];
    static int[][] DP = new int[1001][1001];
    static int[][] DP2 = new int[1001][1001];

    static int MinDist;
    static int[] Answer = new int[1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            if (1 == i) continue;

            S[i] = S[i-1] + Math.abs(r[i]-r[i-1])+Math.abs(c[i]-c[i-1]);
        }

        MinDist = Integer.MAX_VALUE;
        int car1 = 0, car2 = 0, dist;

        DP[1][0] = (r[1]-1)+(c[1]-1);
        DP[0][1] = (N-r[1])+(N-c[1]);
        DP[W][0] = DP[1][0] + (S[W]-S[1]);
        DP[0][W] = DP[0][1] + (S[W]-S[1]);
        if (MinDist > DP[W][0]) { MinDist = DP[W][0]; car1 = W; car2 = 0; }
        if (MinDist > DP[0][W]) { MinDist = DP[0][W]; car1 = 0; car2 = W; }

        for (int i = 1; i < W; i++) {
            DP[i+1][i] = DP[0][1] + (S[i]-S[1]) + (r[i+1]-1)+(c[i+1]-1); DP2[i+1][i] = 0;
            DP[i][i+1] = DP[1][0] + (S[i]-S[1]) + (N-r[i+1])+(N-c[i+1]); DP2[i][i+1] = 0;
            for (int j = 1; j < i; j++) {
                dist = (S[i]-S[j+1]) + (Math.abs(r[i+1]-r[j])+Math.abs(c[i+1]-c[j]));
                if (DP[i+1][i] > DP[j][j+1] + dist) {
                    DP[i+1][i] = DP[j][j+1] + dist; DP2[i+1][i] = j;
                }
                if (DP[i][i+1] > DP[j+1][j] + dist) {
                    DP[i][i+1] = DP[j+1][j] + dist; DP2[i][i+1] = j;
                }
            }
            DP[W][i] = DP[i+1][i] + (S[W]-S[i+1]);
            DP[i][W] = DP[i][i+1] + (S[W]-S[i+1]);
            if (MinDist > DP[W][i]) { MinDist = DP[W][i]; car1 = W; car2 = i; }
            if (MinDist > DP[i][W]) { MinDist = DP[i][W]; car1 = i; car2 = W; }
        }

        for (int i = W; i > 0; i--) {
            if (car1 == car2) continue;
            else if (car1 > car2) { Answer[i] = 1; car1 = (car1 == car2+1)? DP2[car1][car2] : car1-1; }
            else if (car1 < car2) { Answer[i] = 2; car2 = (car1+1 == car2)? DP2[car1][car2] : car2-1; }
        }

        bw.write(MinDist + "\n");
        for (int i = 1; i <= W; i++) {
            bw.write(Answer[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
