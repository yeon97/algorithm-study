package om8d31;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14501_퇴사_v2 {
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 1;

        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1];

        for (int i = 1; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        bottomUp(N, T, P, dp);

        int maxSum = 0;

        for (int i = 1; i < N + 1; i++)
            if (maxSum < dp[i])
                maxSum = dp[i];

        System.out.print(maxSum);

    }

    private static void bottomUp(int N, int[] T, int[] P, int[] dp) {

        for (int i = 1; i < N; i++) {

            int expiration = i + T[i];

            if (expiration > N) continue;

            int prefixSum = P[i] + dp[i];

            for (int j = expiration; j < N + 1; j++)
                if (dp[j] < prefixSum)
                    dp[j] = prefixSum;

        }

    }
}
