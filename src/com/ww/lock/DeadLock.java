package com.ww.lock;

class MyThread implements Runnable{
    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "获取到了" + lockA);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我要获取lockB");
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获取到了" + lockB);
            }

        }
    }
}

/**
 * @author ww
 * 模拟死锁
 * 死锁查看：
 * 1。jps查看进程号
 * 2。jstack 进程号查看原因
 */
public class DeadLock {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MyThread(lockA, lockB)).start();
        new Thread(new MyThread(lockB, lockA)).start();
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + "我来了");
//        }, "aa").start();
    }
}
