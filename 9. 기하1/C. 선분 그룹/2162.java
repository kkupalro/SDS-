package C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static int[] par;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    int N = Integer.parseInt(br.readLine().trim());
    Line[] l = new Line[N + 1];
    par = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      par[i] = i;
    }
    long x1, y1, x2, y2;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine().trim());

      x1 = (long) Integer.parseInt(st.nextToken());
      y1 = (long) Integer.parseInt(st.nextToken());
      x2 = (long) Integer.parseInt(st.nextToken());
      y2 = (long) Integer.parseInt(st.nextToken());

      l[i] = new Line(x1, y1, x2, y2);
    }
    int iPar, jPar;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (i == j)
          continue;
        iPar = find(i);
        jPar = find(j);

        if (iPar != jPar) {
          if (isCrossed(l[i], l[j])) {
            union(i, j);
          }
        }
      }
    }
    int[] count = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      count[par[i]]++;
    }
    int max = 0;
    int size = 0;
    for (int i = 1; i <= N; i++) {
      if (max < count[i])
        max = count[i];
      if (count[i] != 0) {
        size++;
      }
    }
    System.out.println(size);
    System.out.println(max);
  }

  private static boolean isCrossed(Line l1, Line l2) {
    long chk1 = CCW(l1.x1, l1.y1, l1.x2, l1.y2, l2.x1, l2.y1) * CCW(l1.x1, l1.y1, l1.x2, l1.y2, l2.x2, l2.y2);

    long chk2 = CCW(l2.x1, l2.y1, l2.x2, l2.y2, l1.x1, l1.y1) * CCW(l2.x1, l2.y1, l2.x2, l2.y2, l1.x2, l1.y2);

    if (chk1 == 0 && chk2 == 0) {
      return isOverlapped(l1, l2);
    }
    return chk1 <= 0 && chk2 <= 0;
  }

  private static boolean isOverlapped(Line l1, Line l2) {
    if (Math.max(l1.x1, l1.x2) < Math.min(l2.x1, l2.x2))
      return false;
    if (Math.min(l1.x1, l1.x2) > Math.max(l2.x1, l2.x2))
      return false;
    if (Math.max(l1.y1, l1.y2) < Math.min(l2.y1, l2.y2))
      return false;
    if (Math.min(l1.y1, l1.y2) > Math.max(l2.y1, l2.y2))
      return false;
    return true;
  }

  private static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
    long tmp = x1 * y2 + x2 * y3 + x3 * y1;
    tmp -= (y1 * x2 + y2 * x3 + y3 * x1);

    if (tmp < 0)
      return -1;
    if (tmp > 0)
      return 1;
    return 0;
  }

  private static void union(int i, int j) {
    int p = find(i);
    int q = find(j);

    if (p == q)
      return;

    par[q] = p;
  }

  private static int find(int i) {
    if (par[i] == i)
      return i;
    return par[i] = find(par[i]);
  }
}

class Line {
  long x1;
  long y1;
  long x2;
  long y2;

  public Line(long x1, long y1, long x2, long y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
}