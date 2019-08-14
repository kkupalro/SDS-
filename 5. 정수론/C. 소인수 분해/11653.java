package C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static Vector<Integer> v;
	static int N;
	static int result;
	static void solve(int r)
	{
		int cnt = 2;
		int ans = 0;
		while(r > 1)
		{
			// 나누어지면
			if(r % cnt == 0)
			{
				v.add(cnt);
				r = (r / cnt);
				cnt = 2;
			}
			else {
				cnt++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;        
        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        v = new Vector<>();
        result = 0;
        int N = Integer.parseInt(st.nextToken()); // 정점의 갯수
        solve(N);
        for(int i = 0; i < v.size(); i++)
        {
        	bw.write(Integer.toString(v.get(i)) + "\n");
        }
        bw.flush();
        bw.close();
        
        
	}
}
