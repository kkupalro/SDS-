package J;

import java.io.*;
import java.util.*;

public class Main {
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int a, b, c, d;
		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		int top = a*d+c*b;
		int bottom = b*d;
		int common = gcd(bottom, top);
		
		bw.write(top/common + " " + bottom/common + "\n");
		bw.flush();
		bw.close();
	}
}