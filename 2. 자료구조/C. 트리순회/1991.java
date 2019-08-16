package C;

import java.io.*;

class Tree {
	char data; Tree left; Tree right;
	Tree(char data) {
		this.data = data;
	}
}

public class Main {
	static Tree tree[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void preorder(Tree root) throws IOException {
		if(root != null)
		{
			bw.write(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	static void inorder(Tree root) throws IOException {
		if(root != null)
		{
			inorder(root.left);
			bw.write(root.data);
			inorder(root.right);
		}
	}
	static void postorder(Tree root) throws IOException {
		if(root != null)
		{
			postorder(root.left);
			postorder(root.right);
			bw.write(root.data);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Tree[N];
        for(int i = 0; i < N; i++)
        {
        	tree[i] = new Tree((char)('A' + i));
        }
        
        for(int i = 0; i < N; i++)
        {
        	char c[] = br.readLine().replaceAll(" ", "").toCharArray();
        	if(c[1] != '.') tree[c[0] - 'A'].left = tree[c[1] - 'A'];
        	if(c[2] != '.') tree[c[0] - 'A'].right = tree[c[2] - 'A'];
        }
        preorder(tree[0]);
        bw.write("\n");
        inorder(tree[0]);
        bw.write("\n");
        postorder(tree[0]);
        bw.write("\n");
        bw.flush();
	}

}