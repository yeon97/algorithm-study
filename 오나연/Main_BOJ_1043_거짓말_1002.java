package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 11572 KB
  속도 : 72 ms
*/

public class Main_BOJ_1043_거짓말_1002 {
	static int[][] p, parties;
	static boolean[] truthP, visited;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		truthP = new boolean[N+1];  // 1~N까지 인덱스 사용   // 해당 사람이 진실을 알고 있는지 체크
		visited = new boolean[N+1];  // 1~N까지 인덱스 사용  // 해당 사람의 정보를 체크했는지 확인용
		p = new int[N+1][M];  // 해당 사람이 다녀온 파티 정보
		
		// 진실을 아는 사람
		st = new StringTokenizer(br.readLine());
		int truth = Integer.parseInt(st.nextToken());
		for(int i=0; i<truth; i++) {
			int person = Integer.parseInt(st.nextToken());
			truthP[person] = true;
		}
		
		
		// 파티 정보 초기화
		parties = new int[M][];  // 각 파티에 누가 참석했는지 저장
		
		int cnt = M;  // 말을 할 수 있는 총 파티는 전체 파티의 개수
		if(truth != 0) {  // 진실을 아는 사람이 없으면 해줄 필요 없기 때문
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int number = Integer.parseInt(st.nextToken());
				parties[i] = new int[number];  // 파티마다 온 사람 수로 배열 개수
				
				for(int j=0; j<number; j++) {
					int who = Integer.parseInt(st.nextToken());  // i번 파티에 온 사람 번호
					parties[i][j] = who;  // i번 파티에 j번째로 who라는 사람이 왔다
					p[who][i] = 1;  // who 사람은 i번 파티에 참여했다
				}
			}
			
			for(int i=1; i<=N; i++) {
				if(truthP[i] && !visited[i]) dfs(i); // 진실을 알고 있고 그 사람에 대해 체크하지 않았으면 i번 사람에 대해 체크
			}
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<parties[i].length; j++) { 
					if(truthP[parties[i][j]]) {
						cnt--;
						break;
					}		
				}
			}
		}
		System.out.println(cnt);
	}
	
	private static void dfs(int a) {  // i(a)번 사람에 대해 체크
		for(int j=0; j<M; j++) { // 갔다온 파티 확인을 위해
			if(p[a][j] == 1) { // j번 파티에 참여했다면
				for(int k=0; k<parties[j].length; k++) {  // j번 파티를 체크
					int tmp = parties[j][k]; // j번 파티에 온 k번째 사람
					if(!truthP[tmp]) { // 진실을 모르고 있다면
						truthP[tmp] = true;  // 진실을 알려주고
						visited[tmp] = true;  // 그 사람에 대해 확인할 거니까 true
						dfs(tmp);  // 그 사람에 대해 체크
					}
				}			
			}
		} // 반복문 끝
	}  // dfs 끝
}