package sort;

import java.util.Arrays;

/**
 * @description: 归并排序:将两个已排序的数组归并在一个数组中
 * @author: jibingbing
 * @create: 2018/03/31
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {4,7,2,9,1,6,8};
        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.sort(array,0,array.length - 1);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 归并排序
     * @param array
     * @param s:第一个数组的起始下标
     * @param m:第二个数组的起始下标
     * @param e:第二个数组的结束下标
     */
    public void merge(int[] array,int s,int m,int e){
        //排序后的数组
        int[] temp = new int[e - s + 1];

        //三个指针,一个指向第一个数组的起始下标,一个指向第二个数组的起始下标,最后一个指向排序后数组的起始下标
        int i = s, j = m + 1, k = 0;

        //每次从第一个数组和第二个数组取出一个数进行比较,把小的放进临时数组,
        //再从取出小数的数组中取出第二个数接着和另一个数组中的数比较
        while(i <= m && j <= e){
            if(array[i] < array[j]){
                temp[k] = array[i];
                i++;
                k++;
            } else {
                temp[k] = array[j];
                j++;
                k++;
            }
        }
        //如果第二个数数组遍历完了,第一个数组还没遍历完
        while(i <= m){
            temp[k] = array[i];
            i++;
            k++;
        }
        //如果第一个数组遍历完了,第二个数组还没遍历完
        while(j <= e){
            temp[k] = array[j];
            j++;
            k++;
        }

        for(int x = 0;x < temp.length;x++){
            array[s + x] = temp[x];
        }
    }

    public int[] sort(int[] array,int s,int e){
        int mid = (s + e) / 2;
        if(s < e){
            sort(array,s,mid);
            sort(array,mid + 1,e);
            merge(array,s,mid,e);
        }
        return array;
    }
}
