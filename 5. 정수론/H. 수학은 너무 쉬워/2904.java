package H;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, sum, cnt, result;
	static final int MAX = 1000001;
	static int isPrime[] = new int[MAX];
	static int input[] = new int[MAX];
	static int answer[] = new int[MAX];
	static int p[] = new int[MAX];
	static int gcd = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for(int i = 2; i < 1000001; i++)
		{
			if(isPrime[i] == 0)
			{
				p[cnt++] = i;
				for(int j = i+i; j < 1000001; j+=i)
				{
					isPrime[j] = 1;
				}
			}
		}
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			input[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < cnt; i++)
		{
			sum = 0;
			for(int j = 0; j < N; j++)
			{
				int tmp = input[j];
				answer[j] = 0;
				while(tmp % p[i] == 0)
				{
					answer[j]++;
					tmp /= p[i];
				}
				sum += answer[j];
			}
			for(int j = 0; j < sum / N; j++)
			{
				gcd *= p[i];
			}
			for(int j = 0; j < N; j++)
			{
				result += Math.max(sum / N - answer[j], 0);
			}
		}
		bw.write(gcd + " " + result +"\n");
		bw.flush();
		bw.close();
	}
}
