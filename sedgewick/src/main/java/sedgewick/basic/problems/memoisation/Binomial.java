package sedgewick.basic.problems.memoisation;


/**
 * https://algs4.cs.princeton.edu/11model/Binomial.java.html
 */
public final class Binomial {

    public static double binomial_naive(int N, int k, double p) {
        if ((N == 0) && (k == 0))   return 1.0;
        if((N < 0) || (k < 0))      return 0.0;
        return (1.0 - p) * binomial_naive(N - 1, k, p) + p * binomial_naive(N - 1, k - 1, p);
    }

    public static double binomial_memoised(int N, int k, double p) {
        double [][] binomials = new double[N + 1][k + 1];

        // base cases
        for(int i = 0; i <= N; ++i) {
            binomials[i][0] = Math.pow(1.0 - p, i);
        }
        binomials[0][0] = 1.0;

        for(int i = 1; i <= N; ++i) {
            for(int j = 1; j <= k; ++j) {
                binomials[i][j] = p * binomials[i - 1][j - 1] +
                        (1.0 - p) * binomials[i - 1][j];
            }
        }
        return binomials[N][k];
    }
}
