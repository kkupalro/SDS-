package I;

import java.io.*;
import java.util.*;

public class Main {
	static int N, H, Answer, freq;
	static int input[] = new int[200000];
	static int arr[] = new int[500000];
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++)
        {
        	input[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < N; i++)
        {
        	if((i % 2) == 0)
        	{
        		arr[0]++;
        		arr[input[i]]--;
        	}
        	else {
        		arr[H-input[i]]++;
        	}
        }
        for(int i = 1; i < H; i++)
        {
        	arr[i] += arr[i-1];
        }
        Answer = 200001;
        for(int i = 0; i < H; i++)
        {
        	if(Answer > arr[i]) {
        		Answer = arr[i];
        		freq = 1;
        	}
        	else if(Answer == arr[i]) {
        		freq++;
        	}
        }
        bw.write(Answer + " " + freq + "\n");
        bw.flush();
        bw.close();
	}
}
