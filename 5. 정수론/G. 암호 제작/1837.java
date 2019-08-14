package G;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int MAXN = 1000003;
	static int e[] = new int[MAXN];
	static String p = null;
	static int k;
	static void eratosthenes() {
		for(int i = 2; i < MAXN; i++)
		{
			if(e[i] == 0) {
				for(int j = i + i; j < MAXN; j+=i)
				{
					e[j]++;
				}
			}
		}
	}
	static boolean division(int x) {
		int ret = 0;
		for(int i = 0; i < p.length(); i++) {
			ret *= 10;
			ret += (p.charAt(i) - '0');
			ret %= x;
		}
		if(ret == 0) {
			return true;
		}
		else return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		p = st.nextToken();
		k = Integer.parseInt(st.nextToken());
		eratosthenes();
		for(int i = 2; i < k; i++)
		{
			if(e[i] == 0) {
				if(division(i)) {
					bw.write("BAD " + i + "\n");
					bw.flush();
					return;
				}
			}
		}
		bw.write("GOOD\n" );
		bw.flush();
		bw.close();
	}
}
