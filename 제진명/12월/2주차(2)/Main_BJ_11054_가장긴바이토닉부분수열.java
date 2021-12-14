import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  2021. 12. 13
 *  mem: 14644KB time: 160ms
 */

public class Main_BJ_11054_가장긴바이토닉부분수열 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] incDp = new int[N];
    int[] decDp = new int[N];

    for (int i = 0; i < N; i++) {
      incDp[i] = 1;

      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i] && incDp[i] < incDp[j] + 1) {
          incDp[i] = incDp[j] + 1;
        }
      }
    }

    for (int i = N - 1; i >= 0; i--) {
      decDp[i] = 0;

      for (int j = N - 1; j > i; j--) {
        if (arr[j] < arr[i] && decDp[i] < decDp[j] + 1) {
          decDp[i] = decDp[j] + 1;
        }
      }
    }

    int ans = 0;

    for (int i = 0; i < N; i++) {
      ans = Math.max(ans, incDp[i] + decDp[i]);
    }

    System.out.println(ans);
  }
}
