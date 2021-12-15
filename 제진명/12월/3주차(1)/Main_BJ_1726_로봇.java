import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  2021. 12. 15
 *  mem: 16284KB    time: 156ms
 */

public class Main_BJ_1726_로봇 {
  static int M, N, ans;
  static int [][] map;
  static int [][] D = {{0, -1},{-1, 0},{0, 1},{1, 0}}; // 서북동남 순
  static int sX, sY, sD;
  static int eX, eY, eD;
  static int [][][] visited;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    
    
    map = new int[M+1][N+1];
    visited = new int[M+1][N+1][4];
    
    for (int i = 1 ; i <= M ; i++) {
      for (int j = 1 ; j <= N ; j++) {
        for (int k = 0 ; k < 4 ; k++) {
          visited[i][j][k] = Integer.MAX_VALUE;
        }
      }
    }
    
    for (int i = 1 ; i <= M ; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1 ; j <= N ; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    st = new StringTokenizer(br.readLine());
    
    sX = Integer.parseInt(st.nextToken());
    sY = Integer.parseInt(st.nextToken());
    sD = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    
    eX = Integer.parseInt(st.nextToken());
    eY = Integer.parseInt(st.nextToken());
    eD = Integer.parseInt(st.nextToken());
    
    // 주어지는 순서는 동 서 남 북 이므로 1 -> 2, 2 -> 0, 3 -> 3, 4 -> 1
    
    if(sD == 1) sD = 2;
    else if(sD == 2) sD = 0;
    else if (sD == 4) sD = 1;
    
    if(eD == 1) eD = 2;
    else if(eD == 2) eD = 0;
    else if (eD == 4) eD = 1;
    
    ans = Integer.MAX_VALUE;
    
    bfs();
    
    System.out.println(ans);
  }
  
  static void bfs() {
    Queue<int []> queue = new LinkedList<>();
    
    queue.offer(new int [] {sX, sY, sD ,0});
    
    while(!queue.isEmpty()) {
      int [] now = queue.poll();
      if (visited[now[0]][now[1]][now[2]] <= now[3]) continue;
      visited[now[0]][now[1]][now[2]] = now[3];
      
      if (now[0] == eX && now[1] == eY && now[2] == eD) {
        ans = Math.min(ans, now[3]);
        continue;
      }
      
      // 왼쪽으로 회전
      queue.offer(new int [] {now[0], now[1], (now[2]+3)%4, now[3]+1});
      
      // 오른쪽으로 회전
      queue.offer(new int [] {now[0], now[1], (now[2]+1)%4, now[3]+1});
      
      // 바라보고 있는 방향으로 전진
      for (int i = 1 ; i <= 3 ; i++) {
        int nx = now[0] + D[now[2]][0]*i;
        int ny = now[1] + D[now[2]][1]*i;
        
        if (nx < 1 || ny < 1 || nx > M || ny > N || map[nx][ny] == 1) break;
        queue.offer(new int [] {nx, ny, now[2], now[3]+1});
      }
    }
  }
}







