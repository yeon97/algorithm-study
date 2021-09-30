package om9d27_28;

import java.util.Scanner;

public class EA_7466_팩토리얼과최대공약수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		loop:
		for( int t = 1; t <= TC; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int tmp = 1;
			int answer = -1;
			while(a>1) {
				tmp *= a;
				tmp %= b;
				if(tmp == 0) {
					answer = b;
					System.out.println("#"+t+" "+answer);
					continue loop;
				}
				a--;
			}
			while(true) {
				if(tmp == 0 || tmp == b) {
					answer = b;
					break;
				}
				if(b == 0) {
					answer = tmp;
					break;
				}
				if(tmp > b) {
					tmp = tmp%b;
				}else {
					b = b%tmp;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
		
	}

}
