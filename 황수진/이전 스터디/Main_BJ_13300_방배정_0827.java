import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_13300_방배정_0827 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int boys[] = new int[7];
		int girls[] = new int[7];
		int room = 0;
		
		for (int i = 0; i < N; i++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt();
			
			if(sex == 1)
				boys[grade]++;
			else
				girls[grade]++;
		}
		
		for(int x: boys) {
			if(x >= K) {
				room += cal(x, K);
			}
			else if(x != 0 && x < K)
				room += 1;
		}
		
		for(int x: girls) {
			if(x >= K)
				room += cal(x, K);
			else if(x != 0 && x < K)
				room += 1;
		}
		
		System.out.println(room);
		
		sc.close();
	}
	
	// 방 계산하기
	private static int cal(int x, int K) {
		int res = 0;
		while(x > K) {
			res += (x/K);
			x %= K;
		}
		
		// 남은 애들은 한방으로
		if(x != 0)
			res += 1;	
		return res;
		
	}
}
