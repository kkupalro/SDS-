package F;

import java.io.*;

public class Main {
	static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] isPrime = new boolean[MAX+1];
		for(int i = 2; i <=  MAX; i++)
		{
			isPrime[i] = true;
		}
		// 에라토스테네스의 체
		for(int i = 2; i <= MAX; i++)
		{
			for(int j = i+i; j <= MAX; j+=i)
			{
				if(!isPrime[j]) continue;
				isPrime[j] = false;
			}
		}
		while(true) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = false;
			if(N == 0) break;
			for(int i = 2; i <= N / 2; i++)
			{
				if(isPrime[i] && isPrime[N-i])
				{
					bw.write(N + " = " + i + " + " + (N-i) + "\n");
					flag = true;
					break;
				}
			}
			if(!flag)
			{
				bw.write("Goldbach's conjecture is wrong.\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
