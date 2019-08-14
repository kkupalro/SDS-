package B;

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
        StringBuilder sb = new StringBuilder(st.nextToken());
        int matrix[] = new int[10];
        int sum = 0;
        int num = 0;
        for(int i = 0; i <sb.length(); i++)
        {
        	num = sb.charAt(i) - '0';
        	sum += num;
        	matrix[num]++;
        }
        
        if(matrix[0] == 0 || sum%3 != 0)
        {
        	bw.write("-1\n");
        	bw.flush();
        	return;
        }
        
        for(int i = 9; i>=0; i--)
        {
        	for(int j = 0; j < matrix[i]; j++)
        	{
        		bw.write(Integer.toString(i));
        	}
        }
        
        bw.flush();
        br.close();
	}
}


