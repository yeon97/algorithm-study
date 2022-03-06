package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
  메모리 : 42796 KB
  시간 : 496 ms 
*/
public class Main_BOJ_1931_회의실배정_1216 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Room[] room = new Room[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			room[i] = new Room (Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(room);
		
		int cnt = 0;
		int preEnd = 0;
		for(int i=0; i<N; i++) {
			if(preEnd <= room[i].start) {
				cnt++;
				preEnd = room[i].end;
			}
		}
		System.out.println(cnt);
	}
	static class Room implements Comparable<Room>{
		int start, end;
		public Room(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Room o) {
			if(this.end == o.end) return this.start - o.start;
			return this.end - o.end;
		}
	}
}