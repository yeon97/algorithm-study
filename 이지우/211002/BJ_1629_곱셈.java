package zm10d04;

import java.util.Scanner;

public class BJ_1629_곱셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long M = sc.nextInt();
		long R = sc.nextInt();
		System.out.println(pow(N,M,R));
		sc.close();
	}
	public static long pow(long n, long m, long r) {
		if(m == 1) {
			return n % r;
		}
		long tmp = m >> 1;
		long x = pow(n,tmp,r);
		if(m % 2 == 1) {
			
			return (x * x % r ) * n % r;
		}else {
			return (x*x) % r;
		}
	}
}
