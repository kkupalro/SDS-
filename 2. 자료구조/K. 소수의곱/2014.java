package K;

import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int k = Integer.parseInt(st.nextToken());
	        int n = Integer.parseInt(st.nextToken());
	        long s[] = new long[k+1];
	        PriorityQueue<Long> q = new PriorityQueue<Long>();
	        st = new StringTokenizer(br.readLine());
	        for(int i = 1; i <= k; i++)
	        {
	        	s[i] = Long.parseLong(st.nextToken());
	        	q.add(s[i]);
	        }
	        	        	
	        long ans = 0;
	        for(int i = 0; i < n; i++)
	        {
	        	ans = q.poll();
	        	for(int j = 1; j <= k; j++)
	        	{
	        		q.add(ans*s[j]);
	        		if(ans % s[j] == 0) {
	        			break;
	        		}
	        	}
	        }
	        bw.write(ans + "\n");
	        bw.flush();
	        bw.close();
	 }
}
