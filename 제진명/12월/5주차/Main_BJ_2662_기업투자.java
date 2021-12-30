import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  2021. 12. 30
 *  mem: 52640KB    time: 500ms
 */

public class Main_BJ_2662_기업투자 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    
    int N, M;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    int [][] rewards;
    rewards = new int [N+1][M]; // 0~N원 까지 투자금액에 대한 보상 M개 기
    
    
    for (int i = 0 ; i < N ; i++) {
      st = new StringTokenizer(br.readLine());
      int cost = Integer.parseInt(st.nextToken());
      for (int j = 0 ; j < M ; j++) {
        rewards[cost][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    int [][] dp = new int[M+1][N+1]; // 0번 기업(0으로 초기화 되어있는 기준) 부터 M개 기업 까지의 투자 금액에 따른 최대 보상을 저장해 놓을 배열 0원 ~ N원까
    String [][] res = new String[M+1][N+1]; // 어느 기업에 얼마나 투자했는지를 저장해 놓을 배열
    
    // res배열에 기업의 개수 0~M개 만큼 0으로 채운 문자열으로 초기
    for (int i = 0 ; i <= M ; i++) {
      for (int j = 0 ; j <= N ; j++) {
        String temp = "";
        for (int k = 0 ; k <= M ; k++) {
          temp += "0 ";
        }
        res[i][j] = temp;
      }
    }    
    
    for (int i = 1 ; i <= M ; i++) {
      for (int j = 1 ; j <= N ; j++) {
        // 이전 j원 투자한 결과를 최소값을 초기화한다.
        dp[i][j] = dp[i-1][j];
        res[i][j] = res[i-1][j];
        // 직전 0 ~ j-1원 투자한 금액 만큼 돌면서 더 큰 값을 찾는다.
        for (int k = 0 ; k < j ; k++) {
          // 만약 더 큰 값이 존재하면 dp와 res값을 갱신한다.
          if (dp[i-1][k] + rewards[j-k][i-1] > dp[i][j]) {
            dp[i][j] = dp[i-1][k] + rewards[j-k][i-1];
            // i-1행 k열의 res를 가져와서 i번째 기업 위치에 j-k를 더해준다.
            res[i][j] = "";
            st = new StringTokenizer(res[i-1][k]);
            for (int c = 0 ; c < i ; c++) {
              res[i][j] += st.nextToken() + " ";
            }
            // i번째 기업 정보는 어차피 0 이므로 날림
            st.nextToken();
            res[i][j] += String.valueOf(j-k) + " ";
            for (int c = i ; c < M ; c++) {
              res[i][j] += st.nextToken() + " ";
            }
          }
        }
      }
    }
    
    sb.append(dp[M][N]+"\n");
    st = new StringTokenizer(res[M][N]);
    st.nextToken();
    for (int i = 1 ; i <= M ; i++) {
      sb.append(st.nextToken() + " ");
    }
    
    System.out.println(sb);
    
  }
}
