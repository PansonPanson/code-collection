package com.panson.algorithm.sort;

/**
 * Package: com.panson.algorithm.sort
 * Description：
 * Author: Panson
 */
public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int help[] = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = right;
        while (p1 <= mid && p2 <= right) {
            help[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= mid) {
            help[i++] = array[p2++];
        }
        for (i = 0; i < help.length; i++) {
            array[left + i] = help[i];
        }
    }

    public static void main(String[] args) {

    }
}
