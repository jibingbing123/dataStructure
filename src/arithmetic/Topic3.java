package arithmetic;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 找出数组中重复的数字
 * @author: jibingbing
 * @create: 2018/04/03
 **/
public class Topic3 {

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        int a = findRepeatedNums(arr);
        System.out.println("重复的数字为:" + a);
    }

    public static int findRepeatedNums(int[] arr){
        Set<Integer> set = new HashSet<>();

        for(int i = 0;i < arr.length;i++){
            if(set.contains(arr[i])){
                return arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        return -1;
    }
}
