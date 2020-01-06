package designpattern.u28;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by HuGuodong on 1/6/20.
 */
public class TestFindFirstGreaterEqualEleInOrderedArray {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  FindFirstGreaterEqualEleInOrderedArray f;

  @Before
  public void init() {
    System.out.println("Start testing...");
    f = new FindFirstGreaterEqualEleInOrderedArray();
  }

  @After
  public void release() {
    System.out.println("End test, release resource.");
    f = null;
  }


  @Test
  public void testNullInput() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("null");
    f.find(null, 0);
  }

  @Test
  public void testEmptyInputArray() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("eee");
    f.find(new int[]{}, 0);
  }

  @Test
  public void testNormalInput() {
    int[] a = {1, 3, 3, 3, 3, 3, 3, 3, 3, 5, 7, 9};
    int target = 8;
    int res = f.find(a, target);
    assertEquals(res, 10);
  }

  @Test
  public void testTargetIntegerMinVal() {
    int[] a = {1, 3, 3, 3, 3, 3, 3, 3, 3, 5, 7, 9};
    int res = f.find(a, Integer.MIN_VALUE);
    assertEquals(res, 1);
  }

  @Test
  public void testInputUnOrderedArray() {
    expectedEx.expect(IllegalArgumentException.class);
    int[] a = {1, -1, 1, 1, 1, 1, 1};
    f.find(a, -1);
  }


}
