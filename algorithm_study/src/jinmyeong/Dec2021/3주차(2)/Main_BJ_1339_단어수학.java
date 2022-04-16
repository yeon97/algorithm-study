package dec2021.algo211220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 *  2021. 12. 20
 *  mem: 14276KB    time: 128ms
 */

public class Main_BJ_1339_단어수학 {
  static int N;
  static String [] str;
  
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine());
    
    str = new String[N];
    
    // 10에 자리수 제곱한 값을 더해서 가장 큰 값부터 9~0 할당 
    int [] alphas = new int[26];
        
    for (int i = 0 ; i < N ; i++) {
      str[i] = br.readLine();
      for (int j = 0 ; j < str[i].length() ; j++) {
        int pos = str[i].length() - j; // 자릿수
        alphas[str[i].charAt(j) - 'A'] += Math.pow(10, pos-1);
      }
    }
    
    Arrays.sort(alphas);
    
    int ans = 0;
    int num = 9;
    for (int i = 25 ; i >= 0 ; i--) {
      ans += alphas[i] * num;
      num--;
    }
    
    System.out.println(ans);
  }
}
