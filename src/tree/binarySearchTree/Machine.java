package tree.binarySearchTree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: jibingbing
 * @create: 2018/03/28
 **/
public class Machine implements Runnable{
    private int id;

    public Machine(int id){
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = 0;i < 10;i++){
            System.out.println("当前线程: " + Thread.currentThread().getName()
                    + " 当前Machine" + id + ":i = " + i);
            Thread.currentThread().yield();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0;i < 5;i++){
            executorService.execute(new Machine(i));
            //executorService.submit(new Machine(i));
        }
        System.out.println("任务提交结束");
        executorService.shutdown();
        System.out.println("等待已提交的任务完成后,服务关闭");
    }
}
