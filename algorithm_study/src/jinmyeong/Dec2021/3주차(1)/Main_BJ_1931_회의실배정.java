package algo211214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1931_회의실배정 {
  static class Meet implements Comparable<Meet> {
    int start, end;

    public Meet(int start, int end) {
      super();
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meet o) {
      if (this.end == o.end)
        return this.start - o.start;
      return this.end - o.end;
    }

    @Override
    public String toString() {
      return "Meet [start=" + start + ", end=" + end + "]";
    }

  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    Meet[] meets = new Meet[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      meets[i] = new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(meets);

    List<Meet> res = new LinkedList<>();
    res.add(meets[0]);

    for (int i = 1; i < N; i++) {
      if (res.get(res.size() - 1).end <= meets[i].start) {
        res.add(meets[i]);
      }
    }

    System.out.println(res.size());

  }
}
