package sort;

import java.util.Arrays;

/**
 * @description: 选择排序,每次选出未排序的数组中最小的值放在未排序数组的最前面
 * @author: jibingbing
 * @create: 2018/03/30
 **/
public class SelectionSort {

    public void sort(int[] array){
        for(int i = 0;i < array.length - 1;i++){
            int mixIndex = i;//默认数组第一个数是最小值
            for(int j = i + 1;j < array.length;j++){
                if(array[j] < array[mixIndex]){
                    mixIndex = j;//只要找到比第一个数更小的值,就记录下标
                }
            }
            //数组第一个数和最小值交换
            int temp = array[i];
            array[i] = array[mixIndex];
            array[mixIndex] = temp;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {4,7,2,9,1,6,8};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);
    }
}
