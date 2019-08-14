package L;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int t;
	static long gcd(long a, long b) {
		if(a < b) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(t-- > 0)
		{
			sb1.setLength(0);
			sb2.setLength(0);
			sb1.append(br.readLine());
			int b = 0, nb = 0;
			sb1.delete(0, 2);
			boolean k = false;
			for(char i : sb1.toString().toCharArray())
			{
				if(k && i != ')') b++;
				else if(i == '(') k = true;
				else if(i != ')' && i != '(') nb++;
			}
			for(int i = 0; i < sb1.length(); i++)
			{
				if(sb1.charAt(i) == '(')
				{
					sb1.deleteCharAt(sb1.length()-1);
					sb1.deleteCharAt(i);
					break;
				}
			}
			if(b == 0)
			{
				long x = Long.parseLong(sb1.toString()); 
				long y = (long) Math.pow(10, nb);
				long g = gcd(x,y);
				bw.write(x/g + "/" + y/g + "\n");
			}
			else {
				long x = 0;
				for(int i = 0; i < b; i++) sb2.append("9");
				for(int i = 0; i < nb; i++) sb2.append("0");
				if(nb == 0)
				{
					x = Long.parseLong(sb1.toString());
				}
				else {
					x = Long.parseLong(sb1.toString()) - Long.parseLong(sb1.substring(0, nb).toString());
				}
				long yy = Long.parseLong(sb2.toString());
				long g = gcd(x, yy);
				bw.write(x/g + "/" + yy/g + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
