package designpattern.u28;

/**
 * Created by HuGuodong on 1/6/20.
 */
public class FindFirstGreaterEqualEleInOrderedArray {

  public static void main(String[] args) {
    FindFirstGreaterEqualEleInOrderedArray f = new FindFirstGreaterEqualEleInOrderedArray();
    // normal case
    int[] a = {1, 3, 3, 3, 3, 3, 3, 3, 3, 5, 7, 9};
    int target = 8;
    int res = f.find(a, 2);
    assert res == 3;

//    case: null array
//    a = null;
//    f.find(a, -1);

//    case: empty array
//    a = new int[]{};
//    f.find(a,-1);

//   case: single element in array, target is not in array.
    a = new int[]{1};
    res = f.find(a, 0);
    assert res == 1;

//   case: single element in array, target is in array.
    res = f.find(a, 1);
    assert res == 1;

//    target is greater than the biggest element in input array, throw exception!
//    a = new int[]{1, 3, 3, 3, 3, 3, 3, 3, 3, 5, 7, 9};
//    res = f.find(a, 100);

    // target : Integer.MIN_VALUE
    a = new int[]{1};
    res = f.find(a, Integer.MIN_VALUE);
    assert res == 1;

//    non-ordered array
//    a = new int[]{2,2,2,1,1};
//    res = f.find(a, Integer.MIN_VALUE);
//    assert res == 1;

  }

  public int find(int[] nums, int target) {

    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("input array can not be null or empty!");
    }
    if (!isOrdered(nums)) {
      throw new IllegalArgumentException("input array must be ordered!");
    }

    int last = nums[nums.length - 1];
    if (target > last) {
      throw new IllegalArgumentException(
          "There is no value in the input array equal to or greater than target: " + target + "\n"
              + "The maximum element in array is " + last);
    }

    if (target == last) {
      return last;
    }

    if (target <= nums[0]) {
      return nums[0];
    }
    int lo = 0;
    int hi = nums.length - 1;
    int targetIdx = 0;
    while (lo <= hi) {
      int mid = (hi - lo) / 2 + lo;
      if (target > nums[mid]) {
        lo = mid + 1;
      } else if (target > nums[mid - 1]) {
        targetIdx = mid;
        break;
      } else {
        hi = mid - 1;
      }
    }
    return nums[targetIdx];
  }


  private boolean isOrdered(int[] nums) {

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        return false;
      }
    }
    return true;
  }
}
