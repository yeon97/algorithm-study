package jinmyeong.Aug2021.algo0829;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_BJ_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 10;
		Set<Integer> remainder = new HashSet<>();
		for (int i = 0 ; i < N ; i++) {
			remainder.add(Integer.parseInt(br.readLine())%42);
		}
		
		System.out.println(remainder.size());
	}
}
