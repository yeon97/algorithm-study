package dec2021.algo211225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  2021. 12. 25
 *  mem: 14936  time: 176ms
 */

public class Main_BJ_1405_미친로봇 {
  static int N;
  static int [][] D = {{0, 1},{0, -1},{-1, 0},{1, 0}};
  static double [] per;
  static boolean [][] visited;
  static double ans;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    per = new double[4];
    
    visited = new boolean [N*2+1][N*2+1];
    
    for (int i = 0 ; i < 4 ; i++) {
      per[i] = Double.parseDouble(st.nextToken())*0.01;
    }
    
    visited[N][N] = true;
    
    dfs(0, N, N, 1);
    
    System.out.println(ans);
  }
  static void dfs(int cnt, int x, int y, double res) {
    if (cnt == N) {
      ans += res;
      return;
    }
    
    for (int i = 0 ; i < 4 ; i++) {
      if (per[i] == 0) {
        continue;
      }
      int nx = x + D[i][0];
      int ny = y + D[i][1];
      
      if (visited[nx][ny]) continue;
      
      visited[nx][ny] = true;      
      dfs(cnt+1 , nx, ny, res*per[i]);
      visited[nx][ny] = false;
    }
  }
  
}
