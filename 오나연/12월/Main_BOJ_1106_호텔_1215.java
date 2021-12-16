package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 11644 KB
  시간 : 76 ms 
*/
public class Main_BOJ_1106_호텔_1215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		City[] city = new City[N];
		int[][] D = new int[N+1][C+1];
		
		for(int i=0 ;i<N; i++) {
			st = new StringTokenizer(br.readLine());
			city[i] = new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int j=1; j<=C; j++) {
				if(j <= city[i].people) {
					if(D[i][j] == 0) D[i+1][j] = city[i].cost;
					else if(D[i][j] > city[i].cost) D[i+1][j] = city[i].cost; 
					else D[i+1][j] = D[i][j];
				} else {
					if(D[i][j] == 0) D[i+1][j] = D[i+1][j-city[i].people] + city[i].cost;
					else {	
						if(D[i][j] > D[i][j-city[i].people] + city[i].cost)  D[i+1][j] = D[i][j-city[i].people] + city[i].cost;
						if(D[i][j] > (D[i+1][j-city[i].people] + city[i].cost)) D[i+1][j] = D[i+1][j-city[i].people] + city[i].cost;
						if(D[i+1][j] == 0) D[i+1][j] = D[i][j];
					}
				}
			}
		}
		System.out.println(D[N][C]);
	}
	
	static class City {
		int cost, people;
		public City(int cost, int people) {
			this.cost = cost;
			this.people = people;
		}
	}
}