package algo211214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  2021. 12. 14
 *  mem: 12384KB    time: 100ms
 */

public class Main_BJ_10819_차이를최대로 {
  static int N, ans;
  static int [] seq;
  static boolean [] visited;
  
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    
    seq = new int [N];
    visited = new boolean[N];
    
    for (int i = 0 ; i < N ; i++) {
      seq[i] = Integer.parseInt(st.nextToken());
    }
    
    backtracking(0, new int [N]);
    
    System.out.println(ans);
  }
  
  static void backtracking(int cnt, int [] res) {
    if (cnt == N) {
      int temp = 0;
      for (int i = 0 ; i < N-1 ; i++) {
        temp += Math.abs(res[i] - res[i+1]);
      }
      ans = Math.max(ans, temp);
      return;
    }
    
    for (int i = 0 ; i < N ; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      res[cnt] = seq[i];
      backtracking(cnt+1, res);
      visited[i] = false;
      res[cnt] = 0;
    }
  }
}
