package sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: jibingbing
 * @create: 2018/03/31
 **/
public class BubbleSort {

    public void sort(int[] array){
        for (int i=0; i<array.length; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[j] < array[i]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {4,7,2,9,1,6,8};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
    }
}
