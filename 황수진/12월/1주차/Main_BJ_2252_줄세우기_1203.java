import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 메모리 : 46456KB
 시  간 : 540ms
 */
public class Main_BJ_2252_줄세우기_1203 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 학생 수
		int N = Integer.parseInt(st.nextToken());
		// 키 비교 횟수
		int M = Integer.parseInt(st.nextToken());

		// 진입 차수 
		int in[] = new int[N + 1];
		
		// 진출한 노드
		ArrayList<ArrayList<Integer>> out = new ArrayList<>(); 
		
		// 2차원 arraylist 생성
		for (int i = 0; i <= N; i++) {
			out.add(new ArrayList<Integer>());
		}

		// 진출한 노드 저장
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			out.get(s).add(e);
			
			// 진입 차수 세기
			in[e]++;
		}
		
		// 진입 차수가 0인 것 enque
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(in[i] == 0)
				queue.offer(i);
		}

		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			// 현재 노드 출력
			sb.append(cur + " ");
			
			// 현재 노드에서 진출한 노드 리스트
			ArrayList<Integer> outList = out.get(cur);
			
			for(int i = 0; i < outList.size(); i++) {
				// 현재 노드에서 진출한 노드
				int outNode = outList.get(i);
				
				// 현재 위치에서 진입 차수 -1
				in[outNode]--;
				
				// 진입 차수가 0이면 큐에 추가
				if(in[outNode] == 0) 
					queue.offer(outNode);
			}
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
