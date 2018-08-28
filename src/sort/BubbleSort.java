package sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: jibingbing
 * @create: 2018/03/31
 **/
public class BubbleSort {

    public void sort(int[] array){
        for(int i = array.length-1;i > 0;i--){
            for(int j = 0 ;j < i; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
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
