package G;

import java.io.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int arr[] = new int[10010];
	static void postorder(int l, int r) throws IOException {
		if(l > r) return;
		int root = l;
		int s = l, e = r;
		while(arr[s] >= arr[root]) s++;
		while(arr[e] > arr[root]) e--;
		postorder(s, e);
		postorder(e+1, r);
		bw.write(arr[root] +"\n");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x;
		while((x = br.readLine()) != null && x.length() > 0)
		{
			int num = Integer.parseInt(x);
			arr[n++] = num;	
		}
		postorder(0, n-1);
		bw.flush();
		bw.close();
	}
}
