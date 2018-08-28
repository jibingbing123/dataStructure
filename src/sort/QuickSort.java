package sort;

import java.util.Arrays;
import java.util.concurrent.FutureTask;

/**
 * @description: 快速排序:分治思想.
 * 1.选取一个基准;
 * 2.将数组中所有的元素与基准比较,将数组分成两个部分
 * 3.对这两个数组接着分组,直到不能再分为止
 * @author: jibingbing
 * @create: 2018/03/31
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2,6,3,8,5,1,7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        FutureTask
    }

    /**
     * 依次对分开的两个组再进行快排,即递归
     * @param arr
     * @param low
     * @param high
     */
    public void sort(int[] arr,int low,int high){
        if(low >= high){
            return;
        }

        int index = partition(arr,low,high);//获取把一个数组分成两组的中间值
        sort(arr,low,index-1);
        sort(arr,index+1,high);
    }

    /**
     * 快排分组
     * @param arr
     * @param low
     * @param high
     */
    public int partition(int[] arr,int low,int high){
        int standard = arr[low];//选取数组第一个数作为基数

        //开始将数组根据基准划分成两部分,左边的数全部小于基准,右边的数全部大于等于基准
        while(low < high){
            //从右往左元素和基准对比,如果找到小于基准的数,交换元素,25和30行作为一次完整的数据交换
            while (arr[high] >= standard && high > low){
                high--;
            }
            arr[low] = arr[high];

            //找大的数放在基准右边
            while (arr[low] < standard && low < high){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = standard;//把基准存入数组,此时第一轮分组已经完成
        return low;//low和high已经指在一个位置
    }
}
