package dec2021.algo211225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  2021. 12. 26
 *  mem: 25124KB    time: 324ms
 */

public class Main_BJ_1365_꼬인전깃줄 {
  static int [] dp;
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int N;
    N = Integer.parseInt(br.readLine());
    
    st = new StringTokenizer(br.readLine());
    
    int [] wires = new int [N+1];
    
    for (int i = 1 ; i <= N ; i++) {
      wires[i] = Integer.parseInt(st.nextToken());
    }
    
    dp = new int [N+1];
    int len = 0;
    int idx = 0;
    
    for (int i = 1 ; i <= N ; i++) {
      if (wires[i] > dp[len]) {
        len += 1;
        dp[len] = wires[i];
        continue;
      }
      idx = binarySearch(0, len, wires[i]);
      dp[idx] = wires[i];
    }
    
    System.out.println(N-len);
    
  }
  static int binarySearch(int left, int right, int key) {
    while (left<right) {
      int mid = (left+right)/2;
      if(dp[mid] > key) right = mid;
      else left = mid+1;
    }
    return right;
  }
}
