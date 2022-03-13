package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
  메모리 : 56756 KB 
  시간 : 700  ms
*/
public class Main_BOJ_1374_강의실_0313 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Class[] list = new Class[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[i] = new Class(num, start, end);
		}
		
		Arrays.sort(list);
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		
		for(int i=0; i<N; i++) {
			if(!pq.isEmpty() && pq.peek() <= list[i].start) {
				pq.poll();
				pq.offer(list[i].end);
			} else {
				pq.offer(list[i].end);
			}
		}
		System.out.println(pq.size());
	}
	
	public static class Class implements Comparable<Class>{
		int num, start, end;
		public Class(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Class o) {
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}
	}
}