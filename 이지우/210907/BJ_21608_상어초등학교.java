package om9d07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_21608_상어초등학교 {
	static class Student{
		int num;
		int[] friendsNum = new int[4];
		public Student(int num, int[] friendsNum){
			makeFriends(friendsNum);
			this.num = num;
		}
		public void makeFriends(int[] friendsNum){
			for(int i = 0; i < 4; i++){
				this.friendsNum[i] = friendsNum[i];
			}
		}
	}
	static boolean [][] bool;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] field = new int[N][N];
		bool = new boolean[N][N];
		Student[] stu = new Student[N*N];
		
		for(int i = 0 ; i < N*N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] friendsNum = new int[4];
			int num = Integer.parseInt(st.nextToken());
			for(int k = 0 ; k < 4; k++){
				friendsNum[k] = Integer.parseInt(st.nextToken());
			}
			stu[i] = new Student(num, friendsNum);
		}
		
		for(int i = 0 ; i < N*N; i++){
			sol(field,stu[i],N);
		}
//		System.out.println("#################################");
//		for(int i = 0 ; i < N ; i++){
//			for(int j = 0 ; j < N; j++){
//				System.out.print(field[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("#################################");
		System.out.println(answer(field,stu,N));
		
	}
	public static int answer(int [][] field, Student[] stu , int N){
		int answer = 0;
		for(int i = 0 ; i < N; i++){
			for(int j = 0; j < N; j++){
				lop:
				for(int k = 0 ; k < N*N; k++){
					if(stu[k].num == field[i][j]){
						int satis = 0;
						for(int z = 0 ; z < 4; z++){
							satis += findFriend(stu[k].friendsNum[z],i,j,field,N);
						}
						if(satis == 4){
							answer += 1000;
						}else if(satis == 3){
							answer += 100;
						}else if(satis == 2){
							answer += 10;
						}else if(satis == 1){
							answer += 1;
						}
						
						break lop;
					}
				}
			}
		}
		return answer;
	}
	public static void sol(int [][] field, Student stu, int N){
		int tt = 0;
		ArrayList<int[]> zero = new ArrayList<>();
		ArrayList<int[]> one = new ArrayList<>();
		ArrayList<int[]> two = new ArrayList<>();
		loop:
		for(int i = 0 ; i < N; i++){
			for(int j = 0; j < N; j++){
				if(bool[i][j])continue;
					int satis = 0;
					for(int k = 0 ; k < 4; k++){
						satis += findFriend(stu.friendsNum[k],i,j,field,N);
					}
					if(satis >= 3){
						field[i][j] = stu.num;
						bool[i][j] = true;
						tt = 1;
						break loop;
					}else if(satis == 2){
						two.add(new int[]{i,j});
					}else if(satis == 1){
						one.add(new int[]{i,j});
					}else{
						zero.add(new int[]{i,j});
					}
				
			}
		}
		if(tt == 0){
			if(two.size() > 0){
				int[] fb = findBlank(two, field, N);
				int i = fb[0];
				int j = fb[1];
				field[i][j] = stu.num;
				bool[i][j] = true;
			}else{
				if(one.size() > 0){
					int[] fb = findBlank(one, field, N);
					int i = fb[0];
					int j = fb[1];
					field[i][j] = stu.num;
					bool[i][j] = true;
				}else{
					int[] fb = findBlank(zero, field, N);
					int i = fb[0];
					int j = fb[1];
					field[i][j] = stu.num;
					bool[i][j] = true;
				}
			}
		}
	}
	public static int findFriend(int friend, int i, int j, int [][] field, int N){
		int cnt = 0;
		int[] dX = new int[]{1,0,-1,0};
		int[] dY = new int[]{0,1,0,-1};
		for(int k = 0 ; k < 4; k++){
			if(j+dX[k] >= 0 && j+dX[k] < N && i+dY[k] >= 0 && i+dY[k] < N && field[i+dY[k]][j+dX[k]] == friend){
				cnt = 1;
				break;
			}
		}
		return cnt;
	}
	public static int[] findBlank(ArrayList<int[]> arr, int [][] field, int N){
		
		int[] dX = new int[]{1,0,-1,0};
		int[] dY = new int[]{0,1,0,-1};
		int max = -1;
		int[] fb = new int[2];
		for(int a = 0 ; a < arr.size(); a++){
			int cnt = 0;
			int i = arr.get(a)[0];
			int j = arr.get(a)[1];
			for(int k = 0 ; k < 4; k++){
				if(j+dX[k] >= 0 && j+dX[k] < N && i+dY[k] >= 0 && i+dY[k] < N && field[i+dY[k]][j+dX[k]] == 0){
					cnt++;
				}
			}
			if(cnt > max){
				fb[0] = i;
				fb[1] = j;
				max = cnt;
			}
		}
		return fb;
	}
}