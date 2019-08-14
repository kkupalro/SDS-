package M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long gcd(long A, long B) {
		if(B == 0) return A;
		return gcd(B, A%B);
	}
	static long extended_gcd(long A, long B) {
		long r, q, tmpA = A, t, t1 = 0, t2 = 1;
		while(B != 0) {
			q = A / B;
			r = A % B;
			t = t1 - q * t2;
			A = B;
			B = r;
			t1 = t2;
			t2 = t;
		}
		while(t1 < 0) t1 += tmpA;
		return t1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			long K = Long.parseLong(st.nextToken());
			long C = Long.parseLong(st.nextToken());
			if(C == 1)
			{
				if(K + 1 > 1e9)
				{
					bw.write("IMPOSSIBLE\n");
				}
				else bw.write(K + 1 + "\n");
				continue;
			}
			else if(K==1) {
				bw.write("1\n");
				continue;
			}
			else if(gcd(K,C) != 1)
			{
				bw.write("IMPOSSIBLE\n");
				continue;
			}
			//   y:우리가 구하고자하는 답, x: K*x개를 사야함
	        //   C*y = K*x + 1
	        //   C*y - K*x = 1 or C*y % K = 1 (단 C,K는 서로소)
			long ans = extended_gcd(K,C);
			if(ans > 1e9)
			{
				bw.write("IMPOSSIBLE\n");
			}
			else bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
	}
}