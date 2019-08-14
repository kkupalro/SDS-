package A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int result;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = " ";
        while((s = br.readLine()) != null && s.length() > 0)
        {	 
        		int N = Integer.parseInt(s);
                result = 0;
                long ans = 1;
                while(ans != 0)
                {        
                	if(N==1)
                	{
                		break;
                	}
                	ans = (ans*10+1) % N; 
                	result +=1;
                }
                bw.write(Integer.toString(result + 1) + "\n");
                bw.flush();
        }
        bw.close();
	}
}
