package Jan2022.algo20220102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  2021. 1. 2
 *  mem: 298220KB   time: 944ms
 */

public class Main_BJ_14502_연구소 {
  static class Virus {
    int x, y;

    public Virus(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }

  }

  static int N, M, ans, safeArea;
  static int[][] map;
  static List<Virus> viruses;
  static int[][] D = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    viruses = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2)
          viruses.add(new Virus(i, j));
        else if (map[i][j] == 0) {
          safeArea++;
        }
      }
    }
    
    dfs(0);
    
    System.out.println(ans);
  }

  static void dfs(int cnt) {
    if (cnt == 3) {
      ans = Math.max(ans, safeArea-3-spreadVirus());
      return;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0)
          continue;
        map[i][j] = 1;
        dfs(cnt + 1);
        map[i][j] = 0;
      }
    }
  }

  static int spreadVirus() {
    Queue<Virus> queue = new LinkedList<>();

    int [][] copyMap = new int [N][M];
    for (int i = 0 ; i < N ; i++) {
      copyMap[i] = map[i].clone();
    }
    
    
    boolean[][] visited = new boolean[N][M];
    
    int numOfVirus = 0;
    
    for (Virus v : viruses) {
      queue.offer(v);
      visited[v.x][v.y] = true;
    }

    while (!queue.isEmpty()) {
      Virus now = queue.poll();
      
      for (int d = 0 ; d < 4 ; d++) {
        int nx = now.x + D[d][0];
        int ny = now.y + D[d][1];
        
        if (nx < 0 || ny < 0 || nx >= N || ny >= M || copyMap[nx][ny] != 0 || visited[nx][ny]) continue;
        copyMap[nx][ny] = 2;
        visited[nx][ny] = true;
        numOfVirus++;
        queue.offer(new Virus(nx, ny));
      }
    }
    return numOfVirus;
  }
}
