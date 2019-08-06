import java.io.*;
import java.util.*;

public class Main {
	static HashSet<String> hs; 
	static boolean visit[];
	static String arr[];
	static int N, K;
	static void solve(int idx, String s, int cnt) {
		if(cnt == K)
		{
			hs.add(s);
			return;
		}
		for(int i = 0; i < N; i++)
		{
			if(visit[i]) continue;
			visit[i] = true;
			solve(i, s+arr[i], cnt+1);
			visit[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        hs = new HashSet<>();
        arr = new String[N];
        visit = new boolean[N];
        for(int i = 0; i < N; i++)
        {
        	arr[i] = br.readLine();
        }
        for(int i = 0; i < N; i++)
        {
        	visit[i] = true;
        	solve(i, arr[i], 1);
        	visit[i] = false;
        }
        bw.write(hs.size() + "\n");
        bw.close();
	}
}
