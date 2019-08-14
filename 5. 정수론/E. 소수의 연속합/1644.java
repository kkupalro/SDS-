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
			// n������ ������ üũ�ص� n���� üũ��. ����� �������� ���۵Ǳ� ������
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
		// N���� ��� �Ҽ��� ������.
		for(int i = 2; i < MAX; i++)
		{
			if(arr[i] == 0)
			{
				prime[cnt++] = i;
			}
		}
		// �������ͷ� N�� ������ �� ������ ī����
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
