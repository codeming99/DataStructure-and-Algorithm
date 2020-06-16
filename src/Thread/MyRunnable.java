package Thread;

import java.util.Date;

public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String s){
        this.command = s;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.time = " + new Date());
    }

    private void processCommand() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }


    /**
     * native ：凡是带了 native 关键字的，说明Java的作用域范围达不到了，会去调用底层C语言的库
     * 会进入本地方法栈
     * 调用本地方法接口 JNI
     * JNI作用：扩展Java的使用,融合不同的编程语言为Java所用。最初：C，C++
     * Java诞生的时候，C，C++横行,想要立足,必须要有调用C、C++的程序
     * 它在内存区域中专门开辟了一块标记区域：本地方法栈，登记native方法
     * 在最终执行的时候，加载本地方法库中的方法通过JNI
     */
    private native void start0();
}
