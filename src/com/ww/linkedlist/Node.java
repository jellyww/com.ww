package com.ww.linkedlist;

/**
 * 单项链表的节点
 * 包括data,和next节点
 */
public class Node {
    private String data;//数据
    private Node next;//next节点

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
