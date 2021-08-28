package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] student = new int[6][2];
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken())-1;
			student[grade][gender]++;
		}
		
		int cnt = 0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				cnt += student[i][j]/K;
				if(student[i][j]%K != 0) cnt++;
			}
		}
		System.out.println(cnt);
	}
}