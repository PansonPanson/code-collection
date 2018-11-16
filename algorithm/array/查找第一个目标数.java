/*

题目描述
对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。

给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。

测试样例：
[1,3,5,7,9],5,3
返回：1

*/
import java.util.*;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        // write code here
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (A[mid] < val) {
                low = mid + 1;
            } else if (A[mid] > val) {
                high = mid - 1;
            } else {
                if (mid == 0 || A[mid - 1] < val) {
                    return mid;
                } else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}