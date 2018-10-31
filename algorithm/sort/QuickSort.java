package com.panson.algorithm.sort;

/**
 * Package: com.panson.algorithm.sort
 * Description：
 * Author: Panson
 */
public class QuickSort {


    public static void quicSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序，p,r为下标
    public static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r); // q为分区函数返回的分区点，
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);

    }

    // 游标 i 把 A[p…r-1] 分成两部分,每次都从未处理的区间 A[i…r-1] 中取一个元素 A[j],
    // A[j]如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i] 的位置
    public static int partition(int[] a, int p, int r) {
        int pivot = a[r]; // 初始分区点
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[i] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }

        // 最后还需交换一次
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;

        return i;
    }

}
