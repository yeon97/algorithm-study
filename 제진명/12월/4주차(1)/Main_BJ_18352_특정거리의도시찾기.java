package dec2021.algo211222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_18352_특정거리의도시찾기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N, M, K, X;
    final int INF = 987654321;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    List<Integer>[] nodes = new ArrayList[N + 1];

    for (int i = 1; i < N + 1; i++) {
      nodes[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      nodes[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
    }

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { X, 0 });

    int[] dist = new int[N + 1];
    Arrays.fill(dist, INF);

    while (!queue.isEmpty()) {
      int [] now = queue.poll();
      
      if (dist[now[0]] <= now[1]) continue;
      dist[now[0]] = now[1];
      
      for (int e : nodes[now[0]]) {
        queue.offer(new int [] {e, now[1]+1});
      }
    }
    
    boolean flag = false;
    
    for (int i = 1 ; i < N+1 ; i++) {
      if(dist[i] == K) {
        flag = true;
        System.out.println(i);
      }
    }
    if(!flag) System.out.println(-1);
  }
}
