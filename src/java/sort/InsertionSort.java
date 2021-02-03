package sort;

import java.util.Random;

public class InsertionSort {

    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[10000][200];
        Random random = new Random(1);
        for (int i = 0; i < 10000; i ++) {
            for (int j = 0; j < 200; j ++) {
                test[i][j] = random.nextInt(200);
            }
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i ++) {
            InsertionSort.insertionSort(test[i], 200);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
