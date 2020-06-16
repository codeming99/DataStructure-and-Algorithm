package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;   //   核心线程数为5
    private static final int MAX_POOL_SIZE = 10;   //   最大线程数为10
    private static final int QUEUE_CAPACITY = 100; //   任务队列的容量
    private static final Long KEEP_ALIVE_TIME = 1L;//   等待时间为1

    public static void main(String[] args) {


        //使⽤阿⾥巴巴推荐的创建线程池的⽅式
        //通过ThreadPoolExecutor构造函数⾃定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for(int i = 0;i < 10;i++){
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接⼝）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
        }

        //终止线程池
        executor.shutdown();


        while(!executor.isTerminated()){}

        System.out.println("Finish all threads");


        System.out.println("Max_memory="+Runtime.getRuntime().maxMemory()/(double)1024/1024+"M");
        System.out.println("Total_memory="+Runtime.getRuntime().totalMemory()/(double)1024/1024+"M");
    }
}
