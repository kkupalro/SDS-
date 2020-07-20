import java.io.*;
import java.util.*;

public class Main {
	static int lower_bound(int[] L, int l, int r, int val) {
		int mid = 0;
		int ans = 0;
		while(l<=r)
		{
			mid = (l + r) / 2;
			if(L[mid] < val)
			{
				l = mid + 1;
			}
			else
			{
				ans = mid;
				r = mid - 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N+1]; // 수열
		int L[] = new int[N+1]; // LIS 저장
		int P[] = new int[N+1]; // LIS 순번 저장
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++)
		{
			A[i] = Integer.parseInt(st.nextToken());
		}
		int size = 0;
		for(int i = 1; i <=N; i++)
		{
			if(L[size] < A[i])
			{
				// LIS 배열에 값이 A[i] 수열 보다 작으면
				size++; // 순번 늘림
				L[size] = A[i]; // LIS 저장
				P[i] = size; // LIS 순번에 저장함
			} else if(L[size] == A[i]) // LIS에 현재 저장되어있는 값과 수열의 현재값이 같을 경우 넘어감
			{
				continue;
			} else {
				int idx = lower_bound(L, 1, size, A[i]); // LIS에 저장된 수열보다 현재 A수열이 더 작을 경우 이분탐색
				L[idx] = A[i]; // LIS 배열에 현재 수열 저장 -> 이전에 해당자리에 위치한 수열 없어짐.
				P[i] = idx; // 현재 LIS 순번 저장하는 위치에 변경된 순번 저장.
			}
		}
		bw.write(size + "\n");
		Stack<Integer> s = new Stack<Integer>();
		for(int i = N; i >= 1; i--)
		{
			if(P[i] != size) continue;
			if(s.isEmpty())
			{
				s.push(A[i]);
				size--;
			} else {
				if(s.peek() > A[i])
				{
					s.push(A[i]);
					size--;
				}
			}
		}
		while(!s.isEmpty())
		{
			bw.write(s.pop() + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
