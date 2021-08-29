package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2477_참외밭 {
	static class Field {
		int dir;
		int len;
		public Field(int dir, int len) {
			this.dir = dir;
			this.len = len;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Field[] field = new Field[7];
		int[] dirCnt = new int[5];
		
		int longX = 0;
		int longY = 0;
		int shortX = 0;
		int shortY = 0;
		
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			dirCnt[dir]++;
			field[i] = new Field(dir, len);
			if(i==0) field[6] = new Field(dir, len);
			if(dir == 1 || dir == 2) {
				longY = (len > longY) ? len: longY;
			} else {
				longX = (len > longX) ? len: longX;
			}
		}
		if(dirCnt[1] == 2 && dirCnt[3] == 2) {
			for(int i=1; i<field.length; i++ ) {
				if(field[i].dir == 3 && field[i-1].dir == 1) {
					shortX = field[i].len;
					shortY = field[i-1].len;
				}
			}
		} else if(dirCnt[1] == 2 && dirCnt[4] == 2) {
			for(int i=1; i<field.length; i++ ) {
				if(field[i].dir == 1 && field[i-1].dir == 4) {
					shortX = field[i].len;
					shortY = field[i-1].len;
				}
			}
		} else if(dirCnt[2] == 2 && dirCnt[3] == 2) {
			for(int i=1; i<field.length; i++ ) {
				if(field[i].dir == 2 && field[i-1].dir == 3) {
					shortX = field[i].len;
					shortY = field[i-1].len;
				}
			}
		} else {
			for(int i=1; i<field.length; i++ ) {
				if(field[i].dir == 4 && field[i-1].dir == 2) {
					shortX = field[i].len;
					shortY = field[i-1].len;
				}
			}
		}
		System.out.println(((longX*longY) - (shortX*shortY))*K);
	}
}