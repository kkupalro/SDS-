package E;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int result;
	static long x[];
	static long y[];
	static long d[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			result = 1;
			x = new long[4];
			y = new long[4];
			d = new long[6];
			for(int i = 0; i < 4; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				x[i] = Long.parseLong(st.nextToken());
				y[i] = Long.parseLong(st.nextToken());
			}
			int idx = 0;
			for(int i = 0; i < 4; i++)
			{
				for(int j = i+1; j< 4; j++)
				{
					d[idx] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
					idx++;
				}
			}
			Arrays.sort(d);
			for(int i = 0; i<5; i++)
			{
				if(i==3)
				{
					continue;
				}
				if(d[i] != d[i+1])
				{
					result = 0;
				}
			}
			bw.write(result + "\n");
			bw.flush();
		}
		bw.close();
	}
}

