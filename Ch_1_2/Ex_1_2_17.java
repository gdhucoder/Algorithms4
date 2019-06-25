package Ch_1_2;

/**
 * Created by HuGuodong on 2019/6/25.
 */

public class Ex_1_2_17 {

  public static final class _Rational {

    private final long numerator;
    private final long denominator;

    public _Rational(long numerator, long denominator) {
      if (denominator == 0) {
        throw new IllegalArgumentException("denominator can not be zero.");
      }

      assert numerator >= Long.MIN_VALUE && numerator <= Long.MAX_VALUE : "overflow: " + numerator;
      assert
          denominator >= Long.MIN_VALUE && denominator <= Long.MAX_VALUE :
          "overflow: " + denominator;
      long gcd = gcd(numerator, denominator);
      this.numerator = numerator / gcd;
      this.denominator = denominator / gcd;
    }

    public _Rational plus(_Rational b) {
      long numerator = this.numerator * b.denominator
          + this.denominator * b.numerator;
      long denominator = this.denominator * b.denominator;
      long gcd = gcd(numerator, denominator);
      return new _Rational(numerator / gcd, denominator / gcd);
    }

    public _Rational minius(_Rational b) {
      long numerator = this.numerator * b.denominator
          - this.denominator * b.numerator;
      long denominator = this.denominator * b.denominator;
      long gcd = gcd(numerator, denominator);
      return new _Rational(numerator / gcd, denominator / gcd);
    }

    public _Rational times(_Rational b) {
      long numerator = this.numerator * b.numerator;
      long denominator = this.denominator * b.denominator;
      long gcd = gcd(numerator, denominator);
      return new _Rational(numerator / gcd, denominator / gcd);
    }

    public _Rational divides(_Rational b) {
      long numerator = this.numerator * b.denominator;
      long denominator = this.denominator * b.numerator;
      long gcd = gcd(numerator, denominator);
      return new _Rational(numerator / gcd, denominator / gcd);
    }

    @Override
    public boolean equals(Object b) {
      if (this == b)
        return true;
      if (b == null)
        return false;
      if (this.getClass() != b.getClass())
        return false;
      _Rational that = (_Rational) b;
      return this.numerator == that.numerator
          && this.denominator == that.denominator;
    }

    private static boolean hasGcd(long p, long q) {
      return gcd(p, q) != 1;
    }

    public static long gcd(long p, long q) {
      if (q == 0)
        return p;
      long r = p % q;
      return gcd(q, r);
    }

    @Override
    public String toString() {
      return String.format("%d/%d", numerator, denominator);
    }
  }

  public static void main(String[] args) {

  }
}
