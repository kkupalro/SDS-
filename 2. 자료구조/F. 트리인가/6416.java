package F;

import java.io.*;
import java.util.*;

public class Main {
	static int a, b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		HashSet<Integer> s = new HashSet<Integer>();
		int k = 1;
		boolean ok = false;
		while(true) 
		{
			s.clear();
			int sum = 0;
			st = new StringTokenizer(br.readLine(), " ");
			while(true)
			{
				if(!st.hasMoreTokens())
				{
					st = new StringTokenizer(br.readLine(), " ");
				}
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(a == 0 && b == 0) 
					break;
				if(a < 0 && b < 0) {					
					ok = true;
					break;
				}
				s.add(b);
				s.add(a);
				sum++;
			}
			if(ok) break;
			if(sum == 0 || sum == s.size()-1) 
				bw.write("Case " + k + " is a tree.\n");
			else 
				bw.write("Case " + k + " is not a tree.\n");
			k++;
		}
		bw.flush();
		bw.close();
	}
}
