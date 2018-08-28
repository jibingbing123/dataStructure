package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description: 桶排序

 * @author: jibingbing
 * @create: 2018/04/01
 **/
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = { 99, 65, 24, 47, 50, 88,33, 66, 67, 31, 18 };
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(arr);
    }

    public void sort(int[] arr){
        //找到数组中最大和最小值
        int max = 0, min = 0;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        //定义桶的个数
        int bucketSize = (max - min) / arr.length + 1;

        //每个桶中右放入一个数组,对每个桶初始化
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for(int i =0;i < bucketSize;i++){
            bucket.add(new ArrayList<>());
        }

        //将元素根据指定规则放入桶中
        for(int i = 0;i < arr.length;i++){
            int temp = (i - min) / arr.length;
            bucket.get(temp).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i = 0;i < bucketSize;i++){
            Collections.sort(bucket.get(i));
            //桶不为空时打印
            if(bucket.get(i) != null){
                for(Integer j : bucket.get(i)){
                    System.out.print(j + " ");
                }
            }
        }


    }

}
