package dec2021.algo211222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main_BJ_1302_베스트셀러 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N;
    int max = 0;
    String ans = null;
    
    N = Integer.parseInt(br.readLine());
    String [] books = new String[N];
    for (int i = 0 ; i < N ; i++) {
      books[i] = br.readLine();
    }
    
    Arrays.sort(books);
    
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    for (int i = 0 ; i < N ; i++) {
      if (map.containsKey(books[i])) {
        map.replace(books[i], map.get(books[i]), map.get(books[i])+1);
      } else {
        map.put(books[i], 1);
      }
      if (max < map.get(books[i])) {
        max = map.get(books[i]);
        ans = books[i];
      }
    }
    
    System.out.println(ans);
  }
}
