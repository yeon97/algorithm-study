package om8d26;

import java.io.*;
import java.util.*;

public class BJ_13300_방배정 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int [][] stu = new int[N][2];
		for(int i = 0 ; i < N ; i++){
			input = in.readLine().split(" ");
			stu[i][0] = Integer.parseInt(input[0]);
			stu[i][1] = Integer.parseInt(input[1]) - 1;
		}
		int	[][] room = new int[6][2];
		
		for(int i = 0; i < N; i++){
			room[stu[i][1]][stu[i][0]]++;
		}
		int count = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0 ; j < 2; j++){
				if(room[i][j] == 0)continue;
				int x = room[i][j];
				count += (x / K + (x % K == 0? 0 : 1));
			}
		}
		System.out.println(count);
	}
}
