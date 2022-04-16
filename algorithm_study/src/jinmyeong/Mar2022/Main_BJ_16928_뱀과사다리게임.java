package mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BJ_16928_뱀과사다리게임 {
  
  static int N, M;
  static Map<Integer, Integer> ladders;
  static Map<Integer, Integer> snakes;
  static int[] visited;
  static int ans;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    ladders = new HashMap<Integer, Integer>();
    snakes = new HashMap<Integer, Integer>();
    
    for (int i = 0 ; i < N ; i++) {
      st = new StringTokenizer(br.readLine());
      ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    
    for (int i = 0 ; i < M ; i++) {
      st = new StringTokenizer(br.readLine());
      snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    
    visited = new int[101];
    Arrays.fill(visited, 987654321);
    visited[0] = 0;
    
    ans = 987654321;
    backtracking(1, 0);
    System.out.println(ans);
  }
  
  static void backtracking(int now, int cnt) {
    if (now > 100) return;
    if (now == 100) {
      ans = cnt;
      return;
    }
    
    if (visited[now] <= cnt) return;
    else visited[now] = cnt;
    
    if (cnt >= ans) return;
    
    for (int i = 1 ; i < 7 ; i++) {
      int next = now+i;
      if (ladders.containsKey(next)) next = ladders.get(next);
      if (snakes.containsKey(next)) next = snakes.get(next);
      
      backtracking(next, cnt+1);
    }
  }
}
