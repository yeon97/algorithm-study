package om8d26;

import java.io.*;
import java.util.*;

public class BJ_2477_참외밭 {
	static class Coord{
		int x,y,dir;

		public Coord(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		Coord[] coor = new Coord[6];
		String[] tmp;
		int dir, dist,x=0, y=0;
		int[] d= new int[9];
		for(int i = 0 ; i < 6; i++){
			tmp = in.readLine().split(" ");
			dir = Integer.parseInt(tmp[0]);
			dist = Integer.parseInt(tmp[1]);
			d[i] = dir;
			coor[i] = new Coord(x,y,dir);
			switch(dir){
			case 1: x += dist; break;//동
			case 2: x -= dist; break;//서
			case 3: y -= dist; break;//남
			case 4: y += dist; break;//북
			}
		}
		for(int i = 0 ; i < 3; i ++){
			d[6+i] = d[i];
		}
		int start = 0;
		for(int i = 0 ; i < 6; i++){
				if(d[i] == d[i+2] && d[i+1] == d[i+3]){
					start = i;
				}
		}
		Coord a = coor[start];
		Coord b = coor[start+2 >= 6? start - 4 : start+2];
		Coord c = coor[start+4 >= 6? start - 2 : start+4];
		//큰상장 넓이
		int bigBox = Math.abs(a.x-c.x) * Math.abs(a.y - c.y);
		//작은 상자 넓이
		int smallBox = 0;
		if(b.dir == 1 || b.dir == 2){
			int hx = c.x;
			int hy = a.y;
			smallBox = Math.abs(hx-b.x) * Math.abs(hy - b.y);
		}else{
			int hx = a.x;
			int hy = c.y;
			smallBox = Math.abs(hx-b.x) * Math.abs(hy - b.y);
		}
		System.out.println( (bigBox - smallBox) * K);
	}
}
