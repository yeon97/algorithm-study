package dec2021.algo211222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2565_전깃줄 {
  static class Wire implements Comparable<Wire> {
    int f, e;

    public Wire(int f, int e) {
      super();
      this.f = f;
      this.e = e;
    }

    @Override
    public int compareTo(Wire o) {
      // TODO Auto-generated method stub
      return this.f - o.f;
    }

  }

  static int N, ans;
  static Wire[] wires;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    wires = new Wire[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      wires[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    // idea 먼저 앞쪽에 있는 순서 기준으로 정렬
    Arrays.sort(wires);
    
    ans = Integer.MAX_VALUE;
    
    backtracking(0, 0, 0);
    
    System.out.println(ans);

  }
  
  static void backtracking(int remove, int idx, int end) {
    if (ans < remove) {
      return;
    }
    
    if (idx == N) {
      ans = Math.min(ans, remove);
      return;
    }
    
    // 새로 삽입될 전깃줄의 B에 연결될 값이 이전 값보다 클 때
    if (wires[idx].e > end) {
      backtracking(remove, idx+1, wires[idx].e);
    }
    // 이번에 연결될 전깃줄을 연결하지 않을 때
    backtracking(remove+1, idx+1, end);
  }
}
