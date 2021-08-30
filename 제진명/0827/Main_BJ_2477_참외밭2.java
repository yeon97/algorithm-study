import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2477_참외밭2 {
	static class dLength {
		int d, l;

		public dLength(int d, int l) {
			super();
			this.d = d;
			this.l = l;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());

		Queue<dLength> dl = new LinkedList<dLength>();

		int mX = 0, mY = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			if (i % 2 == 0 && mX < l) {
				mX = l;
			} else if (i % 2 == 1 && mY < l) {
				mY = l;
			}
			dl.offer(new dLength(d, l));
		}

		int dX = 0, dY = 0;
		while (dX == 0 && dY == 0) {
			dLength now = dl.poll();
			if (now.d == 1 && dl.peek().d == 3 || now.d == 2 && dl.peek().d == 4 || now.d == 3 && dl.peek().d == 2
					|| now.d == 4 && dl.peek().d == 1) {
				dX = now.l;
				dY = dl.peek().l;
				continue;
			} else {
				dl.offer(now);
			}
		}
		
		System.out.println((mX*mY - dX*dY)*K);
	}
}
