package sedgewick.basic.problems.general;

public final class EuclidGcd {
    public static int gcd(final int p, final int q) {
        if(q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }
}
