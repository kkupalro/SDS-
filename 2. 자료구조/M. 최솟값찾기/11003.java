package M;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int data[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int result[] = new int[N];
		for(int i = 0; i < N; i++)
		{
			while(!dq.isEmpty() && dq.getFirst() <= i - L)
				dq.pollFirst();
			data[i] = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && data[dq.peekLast()] >= data[i])
				dq.pollLast();
			dq.offer(i);
			result[i] = data[dq.peekFirst()];
		}
		for(int i = 0; i < N; i++)
		{
			bw.write(Integer.toString(result[i]) + " ");
		}		
		bw.flush();
		bw.close();
	}
}
