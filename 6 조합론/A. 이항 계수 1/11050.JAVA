import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 파스칼의 삼각형
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // NCK
        int dp[][] = new int[N+1][];
        for(int i = 0; i <= N; i++)
        {
        	dp[i] = new int[i+1];
        	dp[i][0] = 1;
        	dp[i][i] = 1;
        }
        
        for(int i = 1; i < dp.length; i++) {
        	for(int j = 1; j < dp[i].length-1; j++)
        	{
        		dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        	}
        }
        
        bw.write(dp[N][K]+"\n");
        bw.flush();
        bw.close();
        
        
	}
}

