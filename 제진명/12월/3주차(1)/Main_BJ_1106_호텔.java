import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  2021. 12. 14
 *  mem: 14320KB    time: 168ms
 */

public class Main_BJ_1106_호텔 {
  static int [][] arr;
  static int C, N, ans;
  static int [] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    C = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    
    arr = new int[N][2];
    int max = 0;
    
    for (int  i = 0 ; i < N ; i++) {
      st = new StringTokenizer(br.readLine());
      
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
      
      max = Math.max(max, arr[i][0]);
    }
    
    ans = Integer.MAX_VALUE;
    dp = new int[1101];
    
    Arrays.fill(dp, Integer.MAX_VALUE);
    
    dfs(0, 0);
    
    System.out.println(ans);
  }
  
  static void dfs(int cnt, int cost) {
    if (dp[cnt] > cost) {
      dp[cnt] = cost;
    } else {
      return;
    }
    if (cost >= ans) {
      return;
    }
    if (cnt >= C) {
      ans = Math.min(ans, cost);
      return;
    }
    
    for (int i = 0 ; i < N ; i++) {
      dfs(cnt+arr[i][1], cost+arr[i][0]);
    }
    
  }
}
