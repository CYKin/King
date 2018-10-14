package com.king.sort;

import java.util.Arrays;

/**
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Author: wangchangyong
 * @Date: 2018/10/14 20:51
 * @Version: 1.0.0
 */
public class BubbleSort {


    /**
     * 相邻元素比较，更具大小交换元素的位置 时间复杂度是O（N^2）
     *
     * @param array
     */
    private static void sortNo1(int[] array) {
        //外部循环控制循环次数
        for (int i = 0; i < array.length; i++) {
            //内部循环代表每次循环需要比较的次数
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 性能优化
     * isSort是否需要继续排序
     * @param array
     */
    private static void sortNo2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有元素交换，说明数组不是有序，标记变为false
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 性能优化
     * isSort是否需要继续排序
     * lastExchangeIndex无序数列边界
     * @param array
     */
    private static void sortNo3(int[] array) {
        //最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSort = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有元素交换，说明数组不是有序，标记变为false
                    isSort = false;
                    //无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSort) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        int[] array2 = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        sortNo3(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

}
