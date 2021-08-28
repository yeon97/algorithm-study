package om8d27;

import java.io.*;
import java.util.StringTokenizer;

public class EA_1859_백만장자프로젝트 {
	static int[] num;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= TC; t++){
			N = Integer.parseInt(br.readLine());
			st	= new StringTokenizer(br.readLine());
			num = new int[N];
			visited = new boolean[N];
			for(int i = 0 ; i < N; i++){
				num[i] = Integer.parseInt(st.nextToken());
			}
			//최고값,인덱스 구하기
			System.out.println("#"+t+" "+sol());
			
		}
	}
	public static long sol(){
		int Max = 0;
		int index = 1000000;
		for(int i = 0; i < N; i++){
			if(visited[i])continue;
			if(Max < num[i]){
				index = i;
				Max = num[i];
			}
		}
		if(index == 1000000)return 0;
		long cnt = 0;
		for(int i = 0 ; i <= index; i++){
			if(visited[i])continue;
			visited[i] = true;
			cnt += Max-num[i];
		}
		return cnt + sol();
	}
}
