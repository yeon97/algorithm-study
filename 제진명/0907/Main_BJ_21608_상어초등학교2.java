package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_21608_상어초등학교2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int [][] students = new int [N*N][5];
		int [][] map = new int [N][N];
		int [][] d = {{-1, 0},{1, 0},{0, -1},{0, 1}}; // 상, 하, 좌, 우
		
		for (int i = 0 ; i < N*N ; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			while(st.hasMoreTokens()) {
				students[i][idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
		}
		
		/*
		 * 비어있는 칸 중에서 좋아하는 학생이 가장 많이 인접한 칸에 자리를 정한다.
		 */
		
		for (int i = 0 ; i < N*N-1; i++) {
			selectSeat(N, d, map, students[i]);
		}
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if (map [i][j] == 0) {
					map[i][j] = students[N*N-1][0];
				}
			}
		}
		
		System.out.println(calScore(N, map, students, d));
//		
//		for (int i = 0 ; i < N ; i++) {
//			for (int j = 0 ; j < N ; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
	private static void selectSeat(int N, int [][] d, int [][] map, int [] student) {
		int maxCnt = 0;
		int maxBlankSeat = 0;
		int [] loc = new int [2];
		
		//System.out.println("학생 번호 :"+student[0]);
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if(map[i][j] != 0) continue;
				int cnt = 0;
				int bCnt = 0;
				for (int k = 0 ; k < 4 ; k++) {
					int nx = i + d[k][0];
					int ny = j + d[k][1];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					
					if (map[nx][ny] == 0) bCnt++;
					for (int f = 0 ; f < 4 ; f++) {
						if (map[nx][ny] == student[f+1]) {
							cnt++;
							continue;
						}
					}
				}
				//System.out.print("인접한 친구의 수: "+cnt+" 인접한 빈칸 :"+bCnt);
				if (maxCnt < cnt) {
					maxCnt = cnt;
					maxBlankSeat = bCnt;
					loc[0] = i;
					loc[1] = j;
				} else if (maxCnt == cnt && maxBlankSeat < bCnt) {
					maxBlankSeat = bCnt;
					loc[0] = i;
					loc[1] = j;
				}
				//System.out.println("현재 선택 된 좌표 위치 x="+loc[0]+" y="+loc[1]);
			}
		}
		map[loc[0]][loc[1]] = student[0];
	}
	
	private static int calScore(int N, int [][] map, int [][] students, int [][] d) {
		int score = 0;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				int cur = map[i][j];
				int idx = 0;
				for (int k = 0 ; k < N*N ; k++) {
					if (students[k][0] == cur) {
						idx = k;
						break;
					}
				}
				int cnt = 0;
				for (int k = 0 ; k < 4 ; k++) {
					int nx = i + d[k][0];
					int ny = j + d[k][1];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					
					for (int f = 0 ; f < 4 ; f++) {
						if (map[nx][ny] == students[idx][f+1]) {
							cnt++;
							continue;
						}
					}
				}
				switch (cnt) {
				case 4:
					score += 1000;
					break;
				case 3:
					score += 100;
					break;
				case 2:
					score += 10;
					break;
				case 1:
					score += 1;
					break;
				}
			}
		}
		
		return score;
	}
}
