package sort;

import java.util.Arrays;

/**
 * @description: 基数排序,根据数据的优先级对数组进行分组收集,
 * 不仅能对整数根据个十百...位的优先级进行排序,也能对其他事物比如扑克牌的花色数字进行排序.
 * 基数排序分为两个步骤:分配和收集
 * 1.分配:每个数据根据优先级到底分配到哪个桶中?
 * 2.每次分配完,收集数据后再根据更高优先级收集,直到不能在分组,那么就排序完成
 * @author: jibingbing
 * @create: 2018/04/01
 **/
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {2314, 5428, 373, 2222, 17,925,4,85,118,57};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 采用递归方法找出一个数组中的最大值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int findMax(int[] arr,int left,int right){

        //数组就一个数,那么它就是最大值
        if(left == right){
            return arr[left];
        } else {
            int a = arr[left];
            int b = findMax(arr,left + 1,right);//找出除第一个数以外的最大值和第一个比较

            if(a < b){
                return b;
            } else {
                return a;
            }
        }
    }


    /**
     * 基数排序:此处使用二维数组装载数据,会造成空间浪费,可以考虑使用数据+链表存储,其实就是模拟简单的哈希表
     * @param arr
     */
    public void sort(int[] arr){

        int max = findMax(arr,0,arr.length - 1);

        //基数排序需要进行几轮分配装桶取决于最大数的位数
        for(int i = 1;max / i > 0;i *= 10){

            int[][] bucket = new int[10][arr.length];

            //计算原数组根据个,十,百位...分桶时应该放在0-9哪个桶中,求出各个位上的数字
            for(int j = 0;j < arr.length;j++){
                bucket[(arr[j] / i) % 10][j] = arr[j];
            }

            //每轮分组后重新收集数组,定义一个指针指向原数组第一个位置,为原数组重新赋值上一轮排序后的元素
            int k = 0;

            //10个桶
            for(int j = 0;j < 10;j++){
                //每个桶中元素都少于原数组长度
                for(int l = 0;l < arr.length;l++){
                    if(bucket[j][l] != 0){
                        arr[k] = bucket[j][l];
                        k++;
                    }
                }

            }

        }
    }
}
