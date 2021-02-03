package sort;

import java.util.Random;

public class BubbleSort {

    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
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
            BubbleSort.bubbleSort(test[i], 200);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
