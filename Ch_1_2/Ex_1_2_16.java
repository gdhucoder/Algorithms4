package Ch_1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HuGuodong on 2019/6/24.
 */

public class Ex_1_2_16 {

  public static final class _Rational {

    private final int numerator;
    private final int denominator;

    public _Rational(int numerator, int denominator) {
      int gcd = gcd(numerator, denominator);
      this.numerator = numerator / gcd;
      this.denominator = denominator / gcd;
    }

    public _Rational plus(_Rational b) {
      int numerator = this.numerator * b.denominator
          + this.denominator * b.numerator;
      int denominator = this.denominator * b.denominator;
      int gcd = gcd(numerator, denominator);
      return new _Rational(numerator / gcd, denominator / gcd);
    }

    public _Rational minius(_Rational b) {
      int numerator = this.numerator * b.denominator
          - this.denominator * b.numerator;
      int denominator = this.denominator * b.denominator;
      int gcd = gcd(numerator, denominator);
      return new _Rational(numerator / gcd, denominator / gcd);
    }

    public _Rational times(_Rational b) {
      int numerator = this.numerator * b.numerator;
      int denominator = this.denominator * b.denominator;
      int gcd = gcd(numerator, denominator);
      return new _Rational(numerator / gcd, denominator / gcd);
    }

    public _Rational divides(_Rational b) {
      int numerator = this.numerator * b.denominator;
      int denominator = this.denominator * b.numerator;
      int gcd = gcd(numerator, denominator);
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

    private static boolean hasGcd(int p, int q) {
      return gcd(p, q) != 1;
    }

    public static int gcd(int p, int q) {
      if (q == 0)
        return p;
      int r = p % q;
      return gcd(q, r);
    }

    @Override
    public String toString() {
      return String.format("%d/%d", numerator, denominator);
    }
  }

  public static void main(String[] args) {
    int gcd = _Rational.gcd(2, 10);
    System.out.println(gcd);

    _Rational a = new _Rational(9, 3);
    _Rational b = new _Rational(1, 6);

    StdOut.println("a + b: " + a.plus(b));

    StdOut.println("a - b: " + a.minius(b));

    StdOut.println("a * b: " + a.times(b));

    StdOut.println("a / b: " + a.divides(b));

//    2
//    a + b: 19/6
//    a - b: 17/6
//    a * b: 1/2
//    a / b: 18/1
    a = new _Rational(9, 3);
    b = new _Rational(15, 5);

    StdOut.println(a.equals(b)); // true


  }
}
