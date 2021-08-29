package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cnt = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		int[] colorCnt = new int[cnt+1];
		
		for(int i=1; i<=cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height= Integer.parseInt(st.nextToken());
			for(int j=x; j<x+width; j++) {
				for(int k=y; k<y+height; k++) {
					map[j][k] = i;
				}
			}
		}
		
		for(int j=0; j<1001; j++) {
			for(int k=0; k<1001; k++) {
				if(map[j][k] != 0) {
					colorCnt[map[j][k]]++;
				}
			}
		}
		
		for(int i=1; i<=cnt; i++) {
			System.out.println(colorCnt[i]);
		}
	}
}
