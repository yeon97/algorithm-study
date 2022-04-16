package dec2021.algo211226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 *  2021. 12. 26
 *  mem: 53008KB    time: 592
 */

public class Main_BJ_11779_최소비용구하기2 {
  static class Node implements Comparable<Node> {
    int e, cost;

    public Node(int e, int cost) {
      super();
      this.e = e;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      // TODO Auto-generated method stub
      return Integer.compare(this.cost, o.cost);
    }

  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n, m;
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    List<Node>[] buses = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      buses[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      buses[Integer.parseInt(st.nextToken())]
          .add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    int s, e;
    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.offer(new Node(s, 0));

    int[] dist = new int[n + 1];
    int[] course = new int[n + 1];
    boolean[] visited = new boolean[n + 1];
    Arrays.fill(dist, 1_000_000_001);
    dist[s] = 0;
    course[s] = 0;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (visited[now.e])
        continue;
      visited[now.e] = true;

      for (Node node : buses[now.e]) {
        if (dist[now.e] + node.cost < dist[node.e]) {
          dist[node.e] = dist[now.e] + node.cost;
          course[node.e] = now.e;
          queue.offer(new Node(node.e, dist[now.e] + node.cost));
        }
      }
    }

    sb.append(dist[e] + "\n");
    List<Integer> res = new ArrayList<>();
    int cur = e;
    while (cur != 0) {
      res.add(cur);
      cur = course[cur];
    }
    sb.append(res.size() + "\n");
    for (int i = res.size() - 1; i >= 0; i--) {
      sb.append(res.get(i) + " ");
    }

    System.out.println(sb);
  }
}
