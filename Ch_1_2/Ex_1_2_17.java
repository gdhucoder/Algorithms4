package Ch_1_2;

import static Ch_1_2.Ex_1_2_17._Rational.addExtract;
import static Ch_1_2.Ex_1_2_17._Rational.multExtract;
import static Ch_1_2.Ex_1_2_17._Rational.subExtract;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

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

    public static long addExtract(long x, long y) {
      long r = x + y;
      assert !(((x ^ r) & (y ^ r)) < 0) : String.format("%d addExtract %d overflow!", x, y);
      return r;
    }

    public static long multExtract(long x, long y) {
      long r = x * y;
      assert !(((x ^ r) & (y ^ r)) < 0) : String.format("%d multiply %d overflow!", x, y);
      return r;
    }

    /**
     * x > 0, y > 0 not overflow x < 0, y < 0 not overflow x > 0, y < 0, r < 0 负溢出 x < 0, y > 0, y >
     * 0 正溢出
     */
    public static long subExtract(long x, long y) {
      long r = x - y;
      assert !(((x ^ y) & (x ^ r)) < 0) : String.format("%d sub %d overflow!", x, y);
      return r;
    }




    @Override
    public String toString() {
      return String.format("%d/%d", numerator, denominator);
    }
  }

  @Test
  public void testAdd(){
    addExtract(Long.MIN_VALUE, Long.MIN_VALUE);
  }

  @Test
  public void testMult() {
    multExtract(Long.MIN_VALUE, 1);
    multExtract(Long.MIN_VALUE, Long.MIN_VALUE);
  }

  @Test
  public void testSub() {
    long r = subExtract(2, 1);
    assert r == 1L;
    r = subExtract(Long.MAX_VALUE, -1);
  }

  public static void main(String[] args) {
    StdOut.println(Long.MAX_VALUE);
    StdOut.println(Long.MIN_VALUE);
    // -ea
    _Rational r1 = new _Rational(Long.MAX_VALUE, 1);
    _Rational r2 = new _Rational(9223372036854775807L, 1);
    StdOut.println(r1.plus(r2));
  }
}
