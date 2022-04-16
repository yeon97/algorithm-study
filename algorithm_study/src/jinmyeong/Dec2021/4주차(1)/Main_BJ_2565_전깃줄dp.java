package dec2021.algo211222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2565_전깃줄dp {
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
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int N;
    
    N = Integer.parseInt(br.readLine());
    
    Wire [] wires = new Wire[N];
    
    for (int i = 0 ; i < N ; i++) {
      st = new StringTokenizer(br.readLine());
      wires[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    
    Arrays.sort(wires);
    
    int [] dp = new int[N+1];
    
    Arrays.fill(dp, 1);
    
    int max = 0;
    
    for (int i = 0 ; i < N ; i++) {
      for (int j = i ; j < N ; j++) {
        if (wires[i].e < wires[j].e) {
          dp[j] = Math.max(dp[j], dp[i]+1);
          max = Math.max(max, dp[j]);
        }
      }
    }
    
    System.out.println(N-max);
  }
}
