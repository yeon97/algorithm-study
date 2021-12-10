import java.util.Scanner;

public class Main_BJ_2999_비밀이메일_0830 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int mr = 0, mc = 0;
		int n = str.length();
		char arr[][];
		int r = 0, c = 0;
		
		for (int i = 1; i <= n/2; i++) {
			if(n % i == 0) {
				r = i;
				c = n / i;
			}
			
			if(r <= c && mr <= r) {
				mr = r;
				mc = c;
			}
		}
		
		arr = new char[mr][mc];
		int idx = 0;
		
		// 열 방향으로 입력
		for (int i = 0; i < mc; i++) {
			for (int j = 0; j < mr; j++) {
				arr[j][i] = str.charAt(idx++); 
			}
		}
		
		// 행 방향으로 출력
		for (int i = 0; i < mr; i++) {
			for (int j = 0; j < mc; j++) {
				System.out.print(arr[i][j]);
			} 
		}
		
		sc.close();
		
	}
}
