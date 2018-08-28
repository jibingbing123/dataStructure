package sort;

import java.util.Arrays;

/**
 * @description: 堆排序:分为三步
 * 1.将无序数组转化成大顶堆;
 * 2.将大顶堆一个元素与最后一个叶子节点互换,这时会干扰大顶堆的结构;
 * 3.重新调整大顶堆
 * @author: jibingbing
 * @create: 2018/03/31
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {4,7,2,9,1,6,8};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(array);
    }

    public void sort(int[] arr){
        int end = arr.length - 1;

        //arr.length/2 - 1为最后一个非叶子节点,依次往树顶遍构建大顶堆
        for(int i = arr.length/2 - 1;i >= 0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //每次讲大顶堆第一个元素(最大)与最后一个互换,互换后重新调整新的大顶堆(每次数组长度减1)
        while(end > 0){
            swap(arr,0,end--);
            adjustHeap(arr,0,end + 1);

        }
        System.out.println(Arrays.toString(arr));
    }

    public void adjustHeap(int[] arr,int i,int len){
        int max;//记录当前子树的最大值下标

        for(int left = 2 * i + 1;left < len;left = 2*left + 1){
            int right = left + 1;
            //是否有右孩子
            if(right < len){
                if(arr[left] < arr[right]){
                    max = right;
                } else {
                    max = left;
                }
            } else {//如果没有右孩子,左孩子直接和父亲节点比较
                if(arr[i] < arr[left]){
                    max = left;
                } else {
                    max = i;
                }
            }
            //父亲节点与左右孩子中较大的比较
            if(arr[i] > arr[max]){
                break;
            } else {
                swap(arr,i,max);
                i = max;
            }

        }
    }

    //交换数组中下标为i和j的元素
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
