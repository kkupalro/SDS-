import java.io.*;
import java.util.*;

public class Main {
	static int N; // [1 ~ 1024]
	static int M; // [1 ~ 100,000]
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		int result[] = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			if(i == 1) dp[i] = dp[i-1] + num;
			else dp[i] = dp[i-1] + num;
		}
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken()); 
			int D = Integer.parseInt(st.nextToken());
			result[i] = dp[D] - dp[S-1];
		}
		for(int i = 0; i < M; i++)
		{
			bw.write(result[i] +"\n");
		}
		bw.flush();
		bw.close();
	}
}
