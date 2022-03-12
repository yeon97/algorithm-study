package mar2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1374_강의실 {
  static int N;
  static class Course implements Comparable<Course>{
    int start, end;
    public Course(int start, int end) {
      // TODO Auto-generated constructor stub
      this.start = start;
      this.end = end;
    }
    
    @Override
    public int compareTo(Course o) {
      // TODO Auto-generated method stub
      return this.start - o.start;
    }    
    
  }
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    N = Integer.parseInt(br.readLine());
    
    Course [] courses = new Course[N];
    
    for (int i = 0 ; i < N ; i++) {
      st = new StringTokenizer(br.readLine());
      courses[Integer.parseInt(st.nextToken())-1] = new Course(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    
    ArrayList<Integer> rooms = new ArrayList<Integer>();
    
    Arrays.sort(courses);
    
    loop: for (Course c : courses) {
      if (rooms.size() == 0) {
        rooms.add(c.end);
      }
      else {
        for (int i = 0 ; i < rooms.size() ; i++) {
          if (rooms.get(i) <= c.start) {
            rooms.set(i, c.end);
            continue loop;
          }
        }
        rooms.add(c.end);
      }
    }
    
    System.out.println(rooms.size());
  }
}
