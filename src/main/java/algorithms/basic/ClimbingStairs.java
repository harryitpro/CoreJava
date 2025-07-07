package algorithms.basic;

/**
 * Problem: You are climbing a staircase.
 * It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    static int climbStairsMemo(int n) {
        int[] ways = new int[n + 1];  //important! the steps are from 0 till N.
        if (n == 0 || n == 1) return 1;
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];  // important!
    }

    public static void main(String[] args) {
        System.out.println(climbStairsMemo(5));
    }
}
