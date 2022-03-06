package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
  메모리 : 18908 KB
  시간 : 104 ms 
*/
public class Main_BOJ_14226_이모티콘_1213 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		Queue<Emo> q = new LinkedList<>();
		boolean[][] visited = new boolean[2001][2001];
		
		q.offer(new Emo(1, 0, 0));
		visited[1][0] = true;
		
		while(!q.isEmpty()) {
			Emo curr = q.poll();
			int cnt = curr.cnt;
			int clip = curr.clip;
			int time = curr.time;
			
			if(cnt== S) {
				System.out.println(time);
				break;
			}
			
			// 복사
			q.offer(new Emo(cnt, cnt, time+1));
			
			// 붙여넣기
			if(clip != 0 && !visited[cnt+clip][clip] && cnt+clip<=S) {
				q.offer(new Emo(cnt+clip, clip, time+1));
				visited[cnt+clip][clip] = true;
			}
			
			// 삭제
			if(cnt>=1 && !visited[cnt-1][clip]) {
				q.offer(new Emo(cnt-1, clip, time+1));
				visited[cnt-1][clip] = true;
			}
		}
	}
	
	static class Emo {
		int cnt, clip, time;
		public Emo(int cnt, int clip, int time) {
			this.cnt = cnt;
			this.clip = clip;
			this.time = time;
		}
	}
}
