package com.ww.linkedlist;

import java.lang.module.FindException;

/**
 * 模拟链表
 * 模拟链表的插入与删除
 */
public class MyLinkedList {
    private int size;//链表元素的个数
    private Node head;//头节点
    private Node last;//尾节点

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    /**
     * 插入元素。包括数据和具体位置
     *
     * @param data
     * @param index
     */
    public void insert(String data, int index) throws Exception {
        if (index < 0 || index > size) {//当插入位置小于0或者大于链表当前元素个数报错
            throw new Exception("链表越界啦");
        }
        Node node = new Node();//新建节点
        node.setData(data);
        if (size == 0) {//链表为空时，头节点和尾节点都为当前节点
            head = node;
            last = node;
        } else if (index == 0) {//当插入位置为头节点时，该节点的next为当前头节点，将该元素设为头节点
            node.setNext(head);
            head = node;
        } else if (index == size) {//当插入节点为尾节点，当前尾节点的next为该节点，将该节点设为尾节点
            last.setNext(node);
            last = node;
        } else if (index > 0 && index < size) {//插入中间文职时，获取前一个位置元素，当前节点的next指向前一个节点的next，前一个节点的next指向当前node
            Node tmp = get(index - 1);
            node.setNext(tmp.getNext());
            tmp.setNext(node);
        }
        size++;
    }

    /**
     * 获取index位置节点
     *
     * @param index
     * @return
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("链表越界啦");
        }
        if (index == 0) {
            return head;
        }
        if (index == size-1) {
            return last;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 删除制定位置元素，并返回
     * @param index
     * @return
     * @throws Exception
     */
    public Node remove(int index) throws Exception {
        Node removeNode = null;
        if (index < 0 || index > size) {//当插入位置小于0或者大于链表当前元素个数报错
            throw new Exception("链表越界啦");
        }
        if (index == 0) {
            removeNode = head;
            head = head.getNext();
        }else if (index == size - 1) {
            removeNode = last;
            Node tmp = get(index - 1);
            tmp.setNext(null);
            last = tmp;
        } else if (index > 0 && index < size - 1) {
            Node tmp = get(index - 1);
            removeNode = tmp.getNext();
            tmp.setNext(removeNode.getNext());
        }
        return removeNode;
    }

    /**
     * 输出链表
     */
    public void out() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getNext();
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        try {
            myLinkedList.insert("hello", 0);
            myLinkedList.insert("world",1);
            myLinkedList.insert("!",1);
            System.out.println(myLinkedList.remove(2).getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
        myLinkedList.out();

    }
}


