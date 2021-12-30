import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  2021. 12. 30
 *  mem: 21196KB    time:200ms
 */

public class Main_BJ_2629_양팔저울 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    int N = Integer.parseInt(br.readLine());
    int [] weights = new int [N];
    int sumWeights = 0;
    
    st = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < N ; i++) {
      weights[i] = Integer.parseInt(st.nextToken());
      sumWeights += weights[i];
    }
    
    Arrays.sort(weights);
    
    int T = Integer.parseInt(br.readLine());
    int [] tests = new int [T];
    int maxTest = 0;
    
    st = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < T ; i++) {
      tests[i] = Integer.parseInt(st.nextToken());
      maxTest = Math.max(maxTest, tests[i]);
    }
    
    boolean [][] dp = new boolean [N][maxTest+sumWeights + 1];
    dp[0][0] = true;
    dp[0][weights[0]] = true;
    
    for (int i = 1 ; i < N ; i++) {
      for (int j = 0 ; j < dp[i].length ; j++) {
        if (dp[i-1][j]) {
          dp[i][j] = true;
          dp[i][Math.abs(j-weights[i])] = true;
          dp[i][j+weights[i]] = true;
        }
      }
    }
    
    for (int i = 0 ; i < T ; i++) {
      if(dp[N-1][tests[i]]) sb.append("Y ");
      else sb.append("N ");
    }
    
    System.out.println(sb);
  }
}
