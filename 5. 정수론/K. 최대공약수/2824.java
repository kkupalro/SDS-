package K;

import java.io.*;
import java.util.*;

public class Main {
	static int a[];
	static int b[];
	static long result = 1l;
	static final int MOD = 1000000000;
	static int gcd(int a, int b)
	{
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		a = new int[1000];
		b = new int[1000];
		for(int i = 0; i < N; i++)
		{
			a[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++)
		{
			b[i] = Integer.parseInt(st.nextToken());
			for(int j = 0; j < N; j++)
			{
				if(b[i] == 1) break;
				if(a[j] == 1) continue;
				int d = gcd(b[i], a[j]);
				result = result * d;
				a[j] /= d;
				b[i] /= d;
				
				if(result > MOD)
				{
					result = result % MOD + MOD;
				}
			}
		}
		String s = null;
		s = Long.toString(result);
		if(result > MOD)
		{
			s = s.substring(1, s.length());
		}
		bw.write(s + "\n");
		bw.flush();
        bw.close();
	}
}
