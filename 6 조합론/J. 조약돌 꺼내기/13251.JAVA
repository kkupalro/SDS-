import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int M, K, T; // [1, 50]
    static int[] C;
    static double[] pb;
    static double ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = new int[51];
        pb = new double[51];

        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            C[i] = Integer.parseInt(st.nextToken());
            T += C[i];
        }

        K = Integer.parseInt(br.readLine());

        ans = 0.0;
        for (int i = 0; i < M; i++) {
            if (C[i] >= K) {
                pb[i] = 1.0;
                for (int k = 0; k < K; k++) {
                    pb[i] *= (double) (C[i] - k) / (T - k);
                }
            }
            ans += pb[i];
        }

        bw.write(Double.toString(ans));
        bw.flush();
        bw.close();

    }
}
