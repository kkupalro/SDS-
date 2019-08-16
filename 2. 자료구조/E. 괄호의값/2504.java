package E;

import java.io.*;
import java.util.*;

public class Main {
	static char c[];
	static Stack<Character> st;
	static int temp = 1;
	static int sum = 0;
	static boolean wrong = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        c = br.readLine().toCharArray();
        st = new Stack<Character>();
        for(int i = 0; i < c.length; i++)
        {
        	if (c[i] == '(') {
                temp *= 2;
                st.push('(');
            }
            else if (c[i] == '[') {
                temp *= 3;
                st.push('[');
            }
            else if (c[i] == ')') {
                if (st.empty() || st.peek() != '(') {
                    wrong = true;
                    break;
                }
                temp /= 2;
                st.pop();
                if (c[i - 1] == '(')
                    sum += temp*2;
            }
            else {
                if (st.empty() || st.peek() != '[') {
                    wrong = true;
                    break;
                }
                temp /= 3;
                st.pop();
                if (c[i - 1] == '[')
                    sum += temp*3;
            }
        }
        if(wrong || !st.isEmpty())
        {
        	bw.write(0 + "\n");
        }
        else bw.write(sum + "\n");
        bw.flush();
        bw.close();
	}
}
