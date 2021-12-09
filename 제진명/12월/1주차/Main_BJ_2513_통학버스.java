import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 	2021. 12. 5
 * 	mem: 22768		time: 296ms
 */

public class Main_BJ_2513_통학버스 {
	static class Node implements Comparable<Node>{
		int pos, pop;

		public Node(int pos, int pop) {
			super();
			this.pos = pos;
			this.pop = pop;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.pos, this.pos);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, K, S;
		
		N = Integer.parseInt(st.nextToken());	// 아파트 단지 수
		K = Integer.parseInt(st.nextToken());	// 통학버스 정원
		S = Integer.parseInt(st.nextToken());	// 학교의 위치
		
		// 제일 먼곳에 방문, 돌아오면서 남은 정원 다 태우고 오기
		// 돌아오면서 학교 들르면 다 내림
		
		PriorityQueue<Node> left = new PriorityQueue<>();
		PriorityQueue<Node> right = new PriorityQueue<>();
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int pos = Integer.parseInt(st.nextToken());
			int pop = Integer.parseInt(st.nextToken());
			
			if (pos < S) {
				left.offer(new Node(S-pos, pop));
			} else {
				right.offer(new Node(pos-S, pop));
			}
		}
		
		int ans = 0;
		int cnt = 0;
		while (!left.isEmpty()) {
			Node now = left.poll();
			
			if (cnt == 0) {
				ans += now.pos*2;
			}
			cnt += now.pop;
			
			if (cnt > K) {
				left.add(new Node(now.pos, cnt - K));
				cnt = 0;
			} else if (cnt == K) {
				cnt = 0;
			}
		}
		cnt = 0;
		while(!right.isEmpty()) {
			Node now = right.poll();
			
			// 아무도 안태웠다 --> 처음으로 태우러 온 좌표
			if (cnt == 0) {
				ans += now.pos*2;
			}
			cnt += now.pop;
			
			if (cnt > K) {
				right.add(new Node(now.pos, cnt - K));
				cnt = 0;
			} else if (cnt == K) {
				cnt = 0;
			}
			
		}
		
		System.out.println(ans);
	}
}
