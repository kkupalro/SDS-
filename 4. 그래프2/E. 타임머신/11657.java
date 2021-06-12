import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int matrix[][];
    static long dist[];
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 도시의 갯수
        M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수
        matrix = new int[M][3];
        dist = new long[N+1];
        for(int i = 1; i <= N; i++)
        {
            dist[i] = INF;
        }
        dist[1] = 0;
        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[i][0] = a;
            matrix[i][1] = b;
            matrix[i][2] = c;
        }
        for(int v = 0; v < N-1; v++)
        {
            for(int w = 0; w < M; w++)
            {
                if(dist[matrix[w][0]] == INF) continue;
                if(dist[matrix[w][1]] > matrix[w][2] + dist[matrix[w][0]]) {
                    dist[matrix[w][1]] = matrix[w][2] + dist[matrix[w][0]];
                }
            }
        }
        boolean update =false;
        for(int w = 0; w < M; w++)
        {
            if(dist[matrix[w][0]] == INF) continue;
            if(dist[matrix[w][1]] > matrix[w][2] + dist[matrix[w][0]]) {
                update = true;
            }
        }
        if(!update)
        {
            for(int i = 2; i <= N; i++)
            {
                if(dist[i] == INF)
                {
                    bw.write("-1\n");
                }
                else 
                {
                    bw.write(Long.toString(dist[i])+"\n");
                }
            }
        }
        else
        {
            bw.write("-1\n");
        }
        bw.flush();
        br.close();
    }
}

