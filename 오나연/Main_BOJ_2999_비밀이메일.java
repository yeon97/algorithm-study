package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cipher = br.readLine();
		String plain = "";
		int size = cipher.length();
		int R = 0;
		int C = 0;
		
		for(int i=1; i<=size/i; i++) {
			if((size%i==0) && R<i) {
				R = i;
				C = size/i;
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				plain += cipher.charAt(i+(R*j)); 
			}
		}
		System.out.println(plain);
	}
}