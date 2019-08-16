package D;

import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 501;
	static int n, a, b;
	static int dTime[] = new int[MAX];
	static int mTime[] = new int[MAX];
	static int degree[] = new int[MAX];
	static LinkedList<Integer> ll[] = new LinkedList[MAX];
	static Queue<Integer> q;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        q = new LinkedList<Integer>();
        for(int i = 0; i < MAX; i++)
        {
        	ll[i] = new LinkedList<>();
        }
        for(int i = 1; i <= n; i++)
        {
        	st = new StringTokenizer(br.readLine(), " ");
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	dTime[i] = a;
        	mTime[i] = a;
        	while(b != -1)
        	{
        		ll[b].push(i);
        		degree[i]++;
        		b = Integer.parseInt(st.nextToken());
        	}
        }
        for(int i = 1; i <= n; i++)
        {
        	if(degree[i] == 0)
        	{
        		q.offer(i);
        	}
        }
        while(!q.isEmpty())
        {
        	int sum = q.poll();
        	for(Integer i : ll[sum])
        	{
        		degree[i] --;
        		if(degree[i] == 0)
        		{
        			q.offer(i);
        		}
        		mTime[i] = Math.max(mTime[i], mTime[sum] + dTime[i]);
        	}
        }
        for(int i = 1; i <= n; i++)
        {
        	bw.write(mTime[i] + "\n");
        }
        bw.flush();
        bw.close();
	}
}
