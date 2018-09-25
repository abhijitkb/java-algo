package sedgewick.basic.problems.general;

/**
 * Checks to see if two strings are identical if rotated circularly
 * e.g. ACTGACG => TGACGAC
 */
public class CircularStrings {
    public static boolean isCircular(final String str1, final String str2) {
        String str = str1 + str1;
        return str.indexOf(str2) != -1;
    }
}
