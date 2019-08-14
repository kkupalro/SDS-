package E;

import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt, result, sum, tail, head;
	static int MAX = 4000000;
	static int arr[] = new int[MAX];
	static int prime[] = new int[MAX];
	static void eratosthenes() {
		int sqrt = (int) Math.sqrt(MAX);
		for(int i = 2; i < sqrt; i++)
		{
			// n제곱근 까지만 체크해도 n까지 체크됨. 배수는 제곱부터 시작되기 때문에
			if(arr[i] == 0)
			{
				for(int j = i + i; j < MAX; j+=i)
				{
					arr[j]++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		eratosthenes();
		// N까지 모든 소수를 저장함.
		for(int i = 2; i < MAX; i++)
		{
			if(arr[i] == 0)
			{
				prime[cnt++] = i;
			}
		}
		// 투포인터로 N과 동일한 값 개수를 카운팅
		while(head <= cnt) {
			if(sum < N)
			{
				sum += prime[head++];
				continue;
			}
			if(sum == N)
			{
				result++;
			}
			sum -= prime[tail++];
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
