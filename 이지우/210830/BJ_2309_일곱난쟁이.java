package om8d30;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2309_일곱난쟁이 {
	static int[] real = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nanjang = new int[9];
		int[] answer = new int[7];
		for(int i = 0 ; i < 9; i++){
			nanjang[i]=sc.nextInt();
		}
		combination(nanjang,answer,0,0);
		Arrays.sort(real);
		for(int a : real){
			System.out.println(a);
		}
	}
	public static void combination(int[] nanjang,int[] answer,int N,int R){
		if(R >= 7){
			int num = 0 ; 
			for(int a : answer){
				num+=a;
			}
			if(num == 100){
				for(int i = 0 ; i < 7 ; i++){
					real[i] = answer[i];
				}
			}
			return;
		}
		if(N>=9)return;
		answer[R]=nanjang[N];
		combination(nanjang,answer,N+1,R+1);
		combination(nanjang,answer,N+1,R);
	}
}
