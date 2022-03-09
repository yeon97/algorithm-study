import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 메모리 : 56796KB 
 시  간 : 680ms
*/
public class G5_Main_BJ_1374_강의실_0309 {
	
	static class classroom implements Comparable<classroom> {
		int s, e;
		
		public classroom(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public String toString() {
			return "classroom [s=" + s + ", e=" + e + "]";
		}

		@Override
		public int compareTo(classroom o) {
			return this.s-o.s;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		classroom[] rooms = new classroom[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			rooms[i] = new classroom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 강의 시작 순서 오름차순 정렬
		Arrays.sort(rooms);
//		System.out.println(Arrays.toString(rooms));
		
		int res = 0;
		for (int i = 0; i < N; i++) {
			classroom cur = rooms[i];
			
			// 큐가 비어있지 않고
			// 우선순위 큐의 root가 현재 강의 시작 시간보다 작거나 같다 = 강의 시간이 겹치지 않는다
			while(!pq.isEmpty() && pq.peek() <= cur.s) {
				// 끝난 강의 제거
				pq.poll();
			}
			
			// 강의 추가
			pq.add(cur.e);
			res = Math.max(res, pq.size());
		}
		System.out.println(res);
	}
}
