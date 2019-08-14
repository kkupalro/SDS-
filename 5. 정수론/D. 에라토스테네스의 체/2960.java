package D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;        
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean check[] = new boolean[N+1];
        
        int cnt = 0;
        for(int i = 2; i <= N; i++)
        {
        	for(int j = i; j <= N; j += i)
        	{
        		if(check[j]) continue;
        		check[j] = true;
        		cnt++;
        		if(cnt == K)
        		{
        			bw.write(j+"\n");
        			break;
        		}
        	}
        }
        bw.flush();
        br.close();
	}
}


