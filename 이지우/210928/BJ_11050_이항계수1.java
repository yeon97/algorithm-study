package om9d27_28;

import java.util.Scanner;

public class BJ_11050_이항계수1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int answer = 1;
		for(int i = 0; i < K; i++) {
			answer *= N--;
		}
		for(int i = 2; i <= K; i++) {
			answer /= i;
		}
		System.out.println(answer);
	}

}
