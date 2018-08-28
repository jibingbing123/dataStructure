package sort;

import java.util.Arrays;

/**
 * @description: 希尔排序:插入排序的改进,选取增量,将数组划分成几组,每组使用插入排序,不断减小增量至1,即和插入排序相同
 * @author: jibingbing
 * @create: 2018/03/31
 **/
public class ShellSort {

    public void sort(int[] array){
        //选择数组长度的一半每增量,每次取增量的一半,直至为1
        for(int gap = array.length/2;gap > 0;gap /= 2){
            //剩下的和插入一致,只是将插入排序的1换成增量
            for(int i = gap;i < array.length;i++){
                int key = array[i];
                int j = i - gap;
                while(j >= 0 && array[j] > key){
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = key;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {4,7,2,9,1,6,8};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array);
    }
}
