package sort;

import java.util.Arrays;

/**
 * @description: 插入排序:把第一个数看成已经排好序的数组,从第二个数开始,每次和前面数组里面的数从大到小比较;
 * 发现比前面的数小时,将数插进前面的数组中
 * @author: jibingbing
 * @create: 2018/03/31
 **/
public class InsertableSort {

    public void sort(int[] array){
        for(int i = 1;i < array.length;i++){//从第一个数开始与前面数组的数比较
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > key){//发现比前面小的数时,大数往后挪,小数插进去
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {4,7,2,9,1,6,8};
        InsertableSort insertableSort = new InsertableSort();
        insertableSort.sort(array);
    }
}
