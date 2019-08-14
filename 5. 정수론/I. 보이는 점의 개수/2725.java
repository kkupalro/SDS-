package I;

import java.io.*;

public class Main {
	static int n, m, c;
	static int pi[] = new int[1001];
	static int prime[] = new int[500];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		prime[++c] = 2;
		int i, j;
		for(i = 3; i <= 999; i += 2)
		{
			for(j = 1; j <= c; j++)
			{
				if(i % prime[j] == 0)
					break;
			}
			if(j > c)
			{
				prime[++c] = i;
				pi[i] = i - 1;
			}
		}
		pi[1] = pi[2] = 1;
		for(i = 4; i <= 1000; i++)
		{
			if(pi[i] == 0)
			{
				int tmp = i;
				int fcnt = 1;
				for(j = 1; j <= c; j++)
				{
					if(tmp % prime[j] == 0)
					{
						while(tmp % prime[j] == 0)
						{
							tmp /= prime[j];
							fcnt *= prime[j];
						}
						break;
					}
				}
				if(tmp == 1)
				{
					pi[i] = i / prime[j] * pi[prime[j]];
				}
				else {
					pi[i] = pi[fcnt] * pi[i / fcnt];
				}
			}
		}
		m = Integer.parseInt(br.readLine());
		for(i = 1; i <= m; i++)
		{
			n = Integer.parseInt(br.readLine());
			int su = 0;
			for(j = 1; j <= n; j++)
			{
				su += pi[j];
			}
			bw.write(su * 2 + 1 + "\n");
		}
		bw.flush();
		bw.close();
	}
}