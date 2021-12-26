package dec2021.algo211226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 *  2021. 12. 26
 *  mem: 114580KB   time: 1060ms
 */

public class Main_BJ_5430_AC {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    loop: for (int tc = 1; tc <= T; tc++) {
      String p = br.readLine();
      int n = Integer.parseInt(br.readLine());

      String str = br.readLine();
      str = str.substring(1, str.length() - 1);

      Deque<Integer> deque = new LinkedList<>();
      st = new StringTokenizer(str, ",");
      for (int i = 0; i < n; i++) {
        deque.offer(Integer.parseInt(st.nextToken()));
      }

      boolean reverse = false;

      for (int i = 0; i < p.length(); i++) {
        char c = p.charAt(i);
        if (deque.size() == 0 && c == 'D') {
          sb.append("error\n");
          continue loop;
        }
        if (c == 'R')
          reverse = !reverse;
        else if (c == 'D') {
          if (reverse)
            deque.pollLast();
          else
            deque.pollFirst();
        }
      }
      if (deque.size() == 0)
        sb.append("[]\n");
      else {
        sb.append("[");
        while (deque.size() != 1) {
          if (reverse) {
            sb.append(deque.pollLast() + ",");
          } else {
            sb.append(deque.pollFirst() + ",");
          }
        }
        sb.append(deque.poll() + "]\n");
      }
    }
    System.out.println(sb);
  }
}
