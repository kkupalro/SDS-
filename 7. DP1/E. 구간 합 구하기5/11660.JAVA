import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N; // [1 ~ 1024]
	static int M; // [1 ~ 100,000]
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		int result[] = new int[M];
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++)
			{
				int num = Integer.parseInt(st.nextToken());
				if(i == 1) dp[i][j] = dp[i][j-1] + num;
				else if(j==1) dp[i][j] = dp[i-1][j] + num;
				else dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + num;
			}
		}
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()); 
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			result[i] = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
		}
		for(int i = 0; i < M; i++)
		{
			bw.write(result[i] +"\n");
		}
		bw.flush();
		bw.close();
	}
}