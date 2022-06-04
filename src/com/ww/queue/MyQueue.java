package com.ww.queue;

/**
 *循环数组实现队列
 * 队尾指针指向位置永远为空，导致队列容量比数组长度小1；
 */
public class MyQueue {
    private String[] array;//存储元素数组
    private int front;//队列头指针
    private int rear;//队列尾指针

    //创建队列数组
    public MyQueue(int size) {
        this.array = new String[size + 1];
    }


    /**
     * 入队列
     * @param data
     */
    public void enQueue(String data) {
        if ((rear + 1) % array.length == front) {//如果队尾指针+1取余数组长度等于头指针，那么队列溢出
            throw new IndexOutOfBoundsException("队列溢出了");
        }
        array[rear] = data;//赋值
        rear = (rear + 1) % array.length;//如果队尾指针没到数组最后，后移一位，到最后，移到数组第一位（0位置）
    }

    /**
     * 出队列
     * @return
     */
    public String deQueue() {
        if (front == rear) {//两个指针重合，队列为空
            return null;
        }
        String data = array[front];
        front = (front + 1) % array.length;//头指针后移，移到数组最后一位回到0位置
        return data;
    }

    /**
     * 打印队列
     */
    public void out() {
        if (front == rear) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        for (int i = front; i != rear; i=(i + 1) % array.length) {
            System.out.print(array[i]+ " ");
        }
    }

    public static void main(String[] args) {
        MyQueue mq = new MyQueue(2);
        mq.enQueue("hello");
        mq.enQueue("world");
        mq.out();
        System.out.println();
        System.out.println(mq.deQueue());
        mq.enQueue("!");
        mq.out();
        System.out.println();
        System.out.println(mq.deQueue());
        System.out.println(mq.deQueue());
        mq.out();
    }


}
