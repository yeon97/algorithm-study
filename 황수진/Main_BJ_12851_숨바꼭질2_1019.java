import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 메모리 1022384KB
// 시간 864ms

public class Main_BJ_12851_숨바꼭질2_1019 {

	static int N, K, minT, res;
	static boolean arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 수빈 위치
		K = sc.nextInt(); // 동생 위치
		
		minT = Integer.MAX_VALUE; // 가장 빠른 시간
		res = 0; // 가장 빠른 시간으로 찾는 방법

		arr = new boolean[987654321]; // 방문한 위치 체크하기 위한 배열

		bfs(N);
		
		System.out.println(minT);
		System.out.println(res);
		
		sc.close();
		
	}

	private static void bfs(int N) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { N, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int n = cur[0]; // 현재 위치
			int t = cur[1]; // 지금 위치까지 몇 번 만에 왔는지

			arr[n] = true; // 방문 체크
			
			if (t > minT) // 가장 빠른 시간보다 오래걸리면 안됨
				return;
			
			if (n < 0) // 음수가 되면 안됨
				continue;

			if (n == K) { // 동생 위치에 도착하면
				minT = t; // 걸린 시간 저장하고
				res++;	  // 방법 수 + 1
				continue;
			}

			else if (n < K) { // 동생보다 위치가 작으면 3가지 모두 탐색
				if (!arr[n * 2]) queue.offer(new int[] { n * 2, t + 1 });
				if (!arr[n + 1]) queue.offer(new int[] { n + 1, t + 1 });
				if (n - 1 >= 0 && !arr[n - 1]) queue.offer(new int[] { n - 1, t + 1 });
			} else { // 동생보다 위치가 크면 *2 는 생략
				if (!arr[n + 1]) queue.offer(new int[] { n + 1, t + 1 });
				if (n - 1 >= 0 && !arr[n - 1]) queue.offer(new int[] { n - 1, t + 1 });
			}

		}

	}

}
