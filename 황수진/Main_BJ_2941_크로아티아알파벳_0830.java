import java.util.Scanner;

public class Main_BJ_2941_크로아티아알파벳_0830 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		// 크로아티아 알파벳
		String croatian[] = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

		// 크로아티아 알파벳을 만나면 공백으로 변환
		for (int i = 0; i < 8; i++) {
			str = str.replace(croatian[i], " ");
		}
		
		System.out.println(str.length());
		
		sc.close();
	}

}
