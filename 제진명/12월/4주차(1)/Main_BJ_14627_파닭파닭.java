package dec2021.algo211222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14627_파닭파닭 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int S, C;

    S = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    int start = 1;
    int end = 1_000_000_000;
    long sum = 0;
    
    int [] fa = new int[S];
    
    for (int i = 0 ; i < S ; i++) {
      fa[i] = Integer.parseInt(br.readLine());
      sum += fa[i];
    }
    
    while(start<=end) {
      int mid = (start+end)/2;
      
      int cnt = 0;
      for (int i = 0 ; i < S ; i++) {
        cnt += fa[i]/mid;
      }
      
      if (cnt>=C) start = mid+1;
      else end = mid-1;
    }
    
    System.out.println(sum - end * (long) C);
    
  }
}