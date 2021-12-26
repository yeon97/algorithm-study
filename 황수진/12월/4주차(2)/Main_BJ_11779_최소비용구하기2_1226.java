package month12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 메모리 : 52092KB
 시  간 : 404ms
 */
public class Main_BJ_11779_최소비용구하기2_1226 {
	
	public static class Node implements Comparable<Node> {
		int next;
		int cost;
		
		public Node(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// 비용
		int distance[] = new int[N+1];
		
		// 경로
		int route[] = new int[N+1];
		
		ArrayList<ArrayList<Node>> arr = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
			distance[i] = Integer.MAX_VALUE; // 비용 초기 값은 최대값으로 설정
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr.get(s).add(new Node(e, c));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// 우선순위 큐
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start, 0));
		
		// 시작 비용은 0
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cur = node.next;
			int cost = node.cost;
			
			// 시간 초과 해결
			if(distance[cur] < cost)
				continue;
			
			for(Node next : arr.get(cur)) {
				if(distance[next.next] > distance[cur] + next.cost) {
					distance[next.next] = distance[cur] + next.cost;
					
					// 지금 위치 정보를 다음 위치에 저장
					// 1 -> 3이면 3 자리에 1 저장
					route[next.next] = cur;
					queue.offer(new Node(next.next, distance[next.next]));
				}
			}
		}
		
		// 최소 비용
		System.out.println(distance[end]);
		
		// 경로 찾기 위해서 사용
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		int routes = end;
		while(true) {
			stack.push(route[routes]);
			routes = route[routes];

			// 출발지에 도착하면 종료
			if(routes == start) {
				break;
			}
		}
		
		// 도시의 개수
		System.out.println(stack.size());
		
		// 도시 순서 출력
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	

}
