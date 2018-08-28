package arithmetic;

/**
 * @description: 完成一个函数,输入一个二维数组和一个整数,判断数组中是否有这个整数
 * 解题思路:二维数组右上角的数是一行中最大的,也是一列中最小的,这很关键.
 * 拿这个右上角的数和传入的整数比较,如果相等,说明数组中有这个整数;
 * 如果右上角的数小于这个整数,那么这一行所有的数都比这个数小,那么这一行就可以排除了;
 * 如果右上角的数大于这个整数,那么这一列的所有数都大于这个整数,这一列也可以排除了;
 * 这样一直找到最后.
 * @author: jibingbing
 * @create: 2018/04/03
 **/
public class Topic4 {

    public static void main(String[] args) {
        int[][] arr = {{1,1,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean flag = hasNumInArray(arr,4,4,22);
        if(flag){
            System.out.println("二维数组中有整数");
        } else {
            System.out.println("二维数组中没有整数");
        }
    }

    public static boolean hasNumInArray(int[][] arr,int rows,int columns,int number){
        int row = 0;
        int column = columns - 1;

        while(row < rows - 1 && column >= 0){
            if(arr[row][column] == number){
                return true;
            }
            if(arr[row][column] < number){
                row++;
            }
            if(arr[row][column] > number){
                column--;
            }
        }
        return false;
    }
}
