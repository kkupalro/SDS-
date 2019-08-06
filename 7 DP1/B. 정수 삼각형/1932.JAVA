import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int result = 0;
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][];
        for(int i = 1; i <= N; i++)
        {
        	dp[i] = new int[i+1];
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 1; j <= i; j++)
        	{
        		dp[i][j] = Integer.parseInt(st.nextToken()); 
        	}        	
        }
        
        for(int i = 2; i <= N; i++)
        {
        	for(int j = 1; j <= i; j++)
        	{
        		if(j == 1)
        		{
        			dp[i][j] = dp[i][j] + dp[i-1][j];
        		}
        		else if(j == i)
        		{
        			dp[i][j] = dp[i][j] + dp[i-1][j-1];
        		}
        		else {
        			dp[i][j] = dp[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
        		}
        		
        		result = Math.max(result, dp[i][j]); 
        	}        	
        }
		bw.write(Integer.toString(result) +"\n");
		bw.flush();
		bw.close();
	}
}
