import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String CCW(Long[][] p) {
		long a1 = 0;
		long b1 = 0;
		long ans = 0;
		String result = "";
		for(int i = 0;  i< N; i++)
		{
			ans += (p[i][0] * p[i+1][1]) - (p[i][1] * p[i+1][0]); 
		}
		ans = Math.abs(ans);
		if(ans % 2 == 0)
		{
			result = ans/2 + ".0";
		}
		else {
			result = ans/2 +".5";
		}
//		ans = Math.ceil(ans * 10);
//		ans /= 10;
		return result; 
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		Long arr[][] = new Long[N+1][2];
		for(int i = 0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Long.parseLong(st.nextToken());
			arr[i][1] = Long.parseLong(st.nextToken());
		}
		arr[N][0] = arr[0][0];
		arr[N][1] = arr[0][1];
		bw.write(CCW(arr) + "\n");
		bw.flush();
		bw.close();
	}
}
