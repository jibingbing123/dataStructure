package sort;

import java.util.Arrays;

/**
 * @description: 计数排序:将每个整数出现的次数记录下来,就可以得到每个整数在待排序数组中的位置,既然知道位置,排序自然就出来了
 * 1.定义一个数组C,用来存放元是数组每个元素出现的次数;
 * 2.改造数组C,用来存放原始数组每个元素应该在待排序数组中的位置;
 * 3.遍历原始数组,将各个元素根据B中的提供的位置,放入新数组,每次放完一个数,B数组对应的值-1
 * @author: jibingbing
 * @create: 2018/04/01
 **/
public class CountSort {

    public static void main(String[] args) {
        int[] arr = {2,5,3,0,2,3,0,3};
        CountSort countSort = new CountSort();
        countSort.sort(arr,5);
    }

    public void sort(int[] arr,int k){
        int[] C = new int[k + 1];
        int[] B = new int[arr.length];
        int sum = 0;

        for(int i = 0;i < arr.length;i++){
            C[arr[i]] += 1;//统计原数组的各个整数的个数
        }

        for(int i = 0;i < k + 1;i++){
            sum += C[i];
            C[i] = sum;//计算每个元素前面有多少个数,即这个元素在排序后数组中的位置
        }

        //从后到前遍历原数组,原数组在待排序数组中的位置,是由C数组存放的sum决定的,注意sum-1对应待排序数组的下标
        //同时每放进去一个元素,C对应该元素的sum需要-1
        for(int i = arr.length - 1;i >= 0;i--){
            B[ C[arr[i]] - 1 ] = arr[i];
            C[arr[i]]--;
        }

        System.out.println(Arrays.toString(B));
    }
}
