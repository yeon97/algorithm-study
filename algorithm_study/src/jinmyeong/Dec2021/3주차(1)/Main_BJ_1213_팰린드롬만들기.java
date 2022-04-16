import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  2021. 12. 14
 *  mem: 16256KB    time: 164ms
 */

public class Main_BJ_1213_팰린드롬만들기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    int[] alpha = new int['Z' - 'A' + 1];

    // 입력된 문자열의 알파벳의 개수를 저
    for (int i = 0; i < str.length(); i++) {
      alpha[str.charAt(i) - 'A']++;
    }

    // 만약 총 문자열의 길이가 짝수 인데 홀수 개인 알파벳이 존재한다면?
    if (str.length() % 2 == 0) {
      String front = "";
      String back = "";
      for (int i = 0; i <= 'Z' - 'A'; i++) {
        if (alpha[i] % 2 != 0) {
          System.out.println("I'm Sorry Hansoo");
          return;
        }
        if (alpha[i] != 0) {
          for (int j = 0; j < alpha[i] / 2; j++) {
            front += (char) (i + 'A');
            back += (char) (i + 'A');
          }
        }

      }
      for (int i = back.length() - 1; i >= 0; i--) {
        front += back.charAt(i);
      }

      System.out.println(front);
      return;
    } else {
      String front = "";
      String back = "";
      String mid = "";
      for (int i = 0; i <= 'Z' - 'A'; i++) {
        if (alpha[i] % 2 != 0 && mid.length() != 0) {
          System.out.println("I'm Sorry Hansoo");
          return;
        }
        if (alpha[i] != 0) {
          for (int j = 0; j < alpha[i] / 2; j++) {
            front += (char) (i + 'A');
            back += (char) (i + 'A');
          }
          if (alpha[i] % 2 != 0) {
            mid += (char) (i + 'A');
          }
        }
      }
      front += mid;
      for (int i = back.length() - 1; i >= 0; i--) {
        front += back.charAt(i);
      }

      System.out.println(front);
      return;
    }

  }
}
