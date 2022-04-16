package jinmyeong.Sep2021.algo0907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_21608_상어초등학교 {
	static class student {
		int num;
		int[] likes = new int[4];

		public student(int num, int[] likes) {
			super();
			this.num = num;
			this.likes = likes;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("student [num=");
			builder.append(num);
			builder.append(", likes=");
			builder.append(Arrays.toString(likes));
			builder.append("]");
			return builder.toString();
		}

	}

	static class position {
		int x, y;

		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static int[][] map;
	static student[] students;
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상, 하 , 좌, 우

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		students = new student[N * N + 1];
		for (int i = 1; i <= N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] likes = new int[4];
			likes[0] = Integer.parseInt(st.nextToken());
			likes[1] = Integer.parseInt(st.nextToken());
			likes[2] = Integer.parseInt(st.nextToken());
			likes[3] = Integer.parseInt(st.nextToken());
			students[i] = new student(n, likes);
		}

		for (int i = 1; i < N * N; i++) {
			selectSeat(students[i]);
		}
		for (int i = 1; i <= N ; i++) {
			for (int j = 1; j<= N ; j++) {
				if (map[i][j] == 0) map[i][j]=students[N*N].num;
			}
		}

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(score());

	}

	static void selectSeat(student s) {
		int res = 0;
		boolean dup = false;
		ArrayList<position> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0)
					continue;
				int temp = numOfLike(s, i, j);
				if (res < temp) {
					res = temp;
					dup = false;
					list = new ArrayList<>();
					list.add(new position(i, j));
				} else if (res == temp) {
					dup = true;
					list.add(new position(i, j));
				}

			}
		}
		//System.out.println("인접 학생 수"+res +" 학생 번호"+s.num +" x좌표"+list.get(0).x+" y좌표"+list.get(0).y);
		if (res == 0) {
			checkBlank(s.num);
		} else if (dup) {
			int sum = 0;
			int p = 0;
			for (int i = 0; i < list.size(); i++) {
				int temp = dupBlank(list.get(i).x, list.get(i).y);
				if (sum < temp) {
					sum = temp;
					p = i;
				}
			}
			map[list.get(p).x][list.get(p).y] = s.num;
		} else {
			map[list.get(0).x][list.get(0).y] = s.num;
		}
	}

	static int numOfLike(student s, int x, int y) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if (nx < 1 || nx > N || ny < 1 || ny > N)
				continue;
			for (int l = 0; l < 4; l++) {
				if (map[nx][ny] == s.likes[l]) {
					count++;
				}
			}
		}
		return count;
	}

	static void checkBlank(int n) {
		int count = 0;
		int res = 0;
		int resX = 0, resY = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0) {
					continue;
				}
					
				count = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + d[k][0];
					int ny = j + d[k][1];
					if (nx < 1 || nx > N || ny < 1 || ny > N)
						continue;
					if (map[nx][ny] == 0)
						count++;
				}
				if (res < count) {
					res = count;
					resX = i;
					resY = j;
				}
			}
		}
		map[resX][resY] = n;
	}

	static int dupBlank(int x, int y) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if (nx < 1 || nx > N || ny < 1 || ny > N)
				continue;
			for (int l = 0; l < 4; l++) {
				if (map[nx][ny] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	static int score() {
		int score = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int s = map[i][j];
				student student = null;
				for (int k = 1; k < students.length ;k++) {
					if (s == students[k].num) {
						student = students[k];
					}
				}
				int count = 0;
				for (int k = 0 ; k < 4 ; k++) {
					int nx = i + d[k][0];
					int ny = j + d[k][1];
					if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
					for (int l = 0; l < 4; l++) {
						if (map[nx][ny] == student.likes[l]) {
							count++;
						}
					}
				}
				if (count == 1) {
					score += 1;
				} else if(count == 2) {
					score += 10;
				} else if(count == 3) {
					score += 100;
				} else if (count == 4) {
					score += 1000;
				}
			}
		}
		return score;
	}
}
