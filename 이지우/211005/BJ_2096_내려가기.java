package zm10d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2096_내려가기 {
	static int N;
	static int[][]	field;
	static int[] slider;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		field = new int[N][3];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			field[i][0] = Integer.parseInt(st.nextToken());
			field[i][1] = Integer.parseInt(st.nextToken());
			field[i][2] = Integer.parseInt(st.nextToken());
		}
		slider = new int[3];
		makeBig();
		makeSmall();
	}
	public static void makeBig() {
		slider[0] = field[0][0];
		slider[1] = field[0][1];
		slider[2] = field[0][2];
		int cnt = 0;
		int one, two, three;
		while(cnt++ < N-1) {
			one = field[cnt][0] + Math.max(slider[0], slider[1]);
			two = field[cnt][1] + Math.max(slider[0], Math.max(slider[1],slider[2]));
			three = field[cnt][2] + Math.max(slider[1], slider[2]);
			slider[0] = one;
			slider[1] = two;
			slider[2] = three;
		}
		System.out.print(Math.max(slider[0], Math.max(slider[1],slider[2])) + " ");
	}
	public static void makeSmall() {
		slider[0] = field[0][0];
		slider[1] = field[0][1];
		slider[2] = field[0][2];
		int cnt = 0;
		int one, two, three;
		while(cnt++ < N-1) {
			one = field[cnt][0] + Math.min(slider[0], slider[1]);
			two = field[cnt][1] + Math.min(slider[0], Math.min(slider[1],slider[2]));
			three = field[cnt][2] + Math.min(slider[1], slider[2]);
			slider[0] = one;
			slider[1] = two;
			slider[2] = three;
		}
		System.out.print(Math.min(slider[0], Math.min(slider[1],slider[2])));
	}
}
