package om8d27;
import java.io.*;
import java.util.*;

public class JO_1205_조커 {
	static ArrayList<Integer> arr;
	static HashSet<Integer> set;
	static int Max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		int joker = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< N; i++){
			int a = Integer.parseInt(st.nextToken());
			if(a == 0)joker++;
			else{
				set.add(a);
			}
		}
		if(set.size() == 0){
			System.out.println(joker);
		}else{
			arr = new ArrayList<>(set);
			arr.sort((a,b) -> {return a - b;});
			for(int i = 0 ; i < arr.size(); i ++){
				sol(i, joker);
			}
			System.out.println(Max);
		}
	}
	public static void sol(int index, int joker){
		int cnt = 0;
		if(index == arr.size())return;
		if(index+1 == arr.size()) Max = Math.max(Max, joker+1);
		for(int i = index; i < arr.size(); i++){
			cnt++;
			if(i == arr.size()-1){
				Max = Math.max(Max, joker + cnt);
				break;
			}
			int x = arr.get(i+1) - arr.get(i);
			if(x == 1){
				continue;
			}
			if(x > 1+joker){
				Max = Math.max(Max, joker + cnt);
				break;
			}else{
				joker = joker - (x-1);
				cnt += (x-1);
			}
		}
	}
}
