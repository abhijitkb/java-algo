package sedgewick.basic.problems.general;

import java.util.Arrays;
import java.util.Objects;

public class DistancePair {
    public static class Pair {
        private double [] points_ = new double[2];

        public Pair(double first, double second) {
            this.points_[0] = first;
            this.points_[1] = second;
        }

        public double getFirst() {
            return this.points_[0];
        }

        public double getSecond() {
            return this.points_[1];
        }

        public void set(double first, double second) {
            this.points_[0] = first;
            this.points_[1] = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Arrays.equals(points_, pair.points_);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(points_);
        }
    }


    static public Pair getClosestPair(double [] points) {
        Objects.requireNonNull(points);
        assert points.length > 1 : "The number of points must be greater than 1 to find closest pair";

        Arrays.sort(points);

        double closestDiff = Double.MAX_VALUE;
        Pair pair = new Pair(points[0], points[1]);

        for (int i = 1; i < points.length; i++) {
            double diff = Math.abs(points[i - 1] - points[i]);
            if(Double.compare(closestDiff, diff) > 0) {
                closestDiff = diff;
                pair.set(points[i - 1], points[i]);
            }
        }

        return pair;
    }

    static public Pair getFarthestPair(double [] points) {
        Objects.requireNonNull(points);
        assert points.length > 1 : "The number of points must be greater than 1 to find closest pair";

        double min = points[0];
        double max = points[0];

        for (int i = 1; i < points.length; i++) {
            if(Double.compare(points[i], min) < 0)
                min = points[i];
            if(Double.compare(points[i], max) > 0)
                max = points[i];
        }

        return new Pair(min, max);
    }
}
