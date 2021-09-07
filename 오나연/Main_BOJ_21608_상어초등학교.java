import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_21608_상어초등학교 {
	static class Student {
		int student;
		int[] like = new int[4];
		public Student(int student, int[] like) {
			this.student = student;
			this.like = like;
		}
	}
	
	static int[][] room;
	static Student[] sts;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		sts = new Student[size*size];
		room = new int[size][size];
		int answer = 0;
		st= new StringTokenizer(br.readLine());
		int student = Integer.parseInt(st.nextToken());
		int like1 = Integer.parseInt(st.nextToken());
		int like2 = Integer.parseInt(st.nextToken());
		int like3 = Integer.parseInt(st.nextToken());
		int like4 = Integer.parseInt(st.nextToken());
		sts[0] = new Student(student, new int[]{like1, like2, like3, like4});
		
		room[(size-1)/2][(size-1)/2] = student;
		for(int i=1; i<size*size; i++) {
			st = new StringTokenizer(br.readLine());
			student = Integer.parseInt(st.nextToken());
			like1 = Integer.parseInt(st.nextToken());
			like2 = Integer.parseInt(st.nextToken());
			like3 = Integer.parseInt(st.nextToken());
			like4 = Integer.parseInt(st.nextToken());
			sts[i] = new Student(student, new int[]{like1, like2, like3, like4});
			like(i);
		}
		
//		for(int i=0; i<size; i++) {
//			for(int j=0; j<size; j++) {
//				System.out.print(room[i][j]);
//			}
//			System.out.println();
//		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				int idx = 0;
				for(int k=0; k<sts.length; k++) {
					if(sts[k].student == room[i][j]) idx = k;
				}
				answer += satisfy(i, j, idx);
			}
		}
		System.out.println(answer);
	}
	
	private static void like(int k) {
		int likeMax = 0;
		int emptyMax = 0;
		int[] idx = new int[2];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(room[i][j] == 0) {
					int x = i;
					int y = j;
					int like = 0;
					for(int dir=0; dir<4; dir++) {
						int nextX = x+dx[dir];
						int nextY = y+dy[dir];
						if(nextX<0 || nextX>=size || nextY<0 || nextY>=size) continue;
						if(room[nextX][nextY] == 0) continue;
						for(int s=0; s<4; s++) {
							if(room[nextX][nextY] == sts[k].like[s]) {
								like++;
							}
						} 
					}
					if(like > likeMax) {
						emptyMax = empty(i, j);
						likeMax = like;
						idx[0] = i;
						idx[1] = j;
					} else if (like == likeMax) {
						int empty = empty(i, j);
						if(empty > emptyMax) {
							emptyMax = empty;
							idx[0] = i;
							idx[1] = j;
						} else if(empty == emptyMax) {
							if(i<idx[0]) {
								idx[0] = i;
								idx[1] = j;
							} else if(i==idx[0] && j<idx[1]) {
								idx[0] = i;
								idx[1] = j;	
							}
						}
					}
				}
			}
		}
		
		room[idx[0]][idx[1]] = sts[k].student;
	}
	
	private static int empty(int i, int j) {
		int x = i;
		int y = j;
		int emptyCnt = 0;
		for(int dir=0; dir<4; dir++) {
			int nextX = x+dx[dir];
			int nextY = y+dy[dir];
			if(nextX<0 || nextX>=size || nextY<0 || nextY>=size) continue;
			if(room[nextX][nextY] != 0) continue;
			emptyCnt++;
		}
		return emptyCnt;
	}
	
	private static int satisfy(int i, int j, int k) {
		int result = 0;
		int score = 0;
		int x = i;
		int y = j;
		for(int dir=0; dir<4; dir++) {
			int nextX = x+dx[dir];
			int nextY = y+dy[dir];
			if(nextX<0 || nextX>=size || nextY<0 || nextY>=size) continue;
			for(int s=0; s<4; s++) {
				if(room[nextX][nextY] == sts[k].like[s]) {
					result++;
				}
			} 
		}
		
		switch(result) {		
			case 0: score = 0;
					break;
			case 1: score = 1;
					break;
			case 2: score = 10;
					break; 
			case 3: score = 100;
					break;
			case 4: score = 1000;
					break;
		}
		return score;
	}
}