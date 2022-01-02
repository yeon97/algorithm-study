package Jan2022.algo20220102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  2022. 1. 2
 *  mem: 14652KB  time: 180ms
 */

public class Main_BJ_1253_좋다 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    
    int ans = 0;
    
    for (int i = 0 ; i < N ; i++) {
      if (possible(i, N, arr)) ans++;
    }
    
    System.out.println(ans);
  }
  
  static boolean possible(int idx, int N, int [] arr) {
    int start = 0; 
    int end = N-1;
    int target = arr[idx];
    while (true) {
      if(start == idx) start++;
      else if (end == idx) end--;
      
      if (start >= end) break;
      
      int sum = arr[start] + arr[end];
      
      if (sum < target) start++;
      else if (sum > target) end--;
      else return true;
    }
    
    return false;
  }
}
