package com.ww.tree;

import java.util.Arrays;

/**
 * 优先队列：大根堆
 */
public class PriorityQueue {
    private int[] data;
    private int size;

    //初始化优先队列长度为32
    public PriorityQueue() {
        data = new int[32];
    }
    //2倍扩容
    private void reSize() {
        int newSize = size * 2;
        this.data = Arrays.copyOf(this.data, newSize);
    }

    /**
     * 入队列
     * @param da
     */
    public void enQueue(int da) {
        if (size > data.length) {//如果实际长度大于数组长度，扩容
            reSize();
        }
        data[size++] = da;//插入到队尾
        upAdjust(data);//上浮
    }

    public int deQueue() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException("没有元素啦");
        }
        int da = data[0];
        data[0] = data[--size];
        downAdjust(data);
        return da;
    }

    private void downAdjust(int[] data) {
        int parent = 0;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && data[child] < data[child + 1]) {
                child++;
            }
            if (data[parent] < data[child]) {
                Heap.swap(data, parent, child);
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }

    private void upAdjust(int[] data) {
        int child = size - 1;
        int parent = (child - 1) / 2;
        while (child > 0 && data[child] > data[parent]) {
            Heap.swap(data, child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(1);
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(4);
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
    }
}
