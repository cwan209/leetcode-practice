package com.cracking.array;

import java.util.Objects;

public class DoublyNode {
    DoublyNode next = null;
    DoublyNode prev = null;
    int data;

    public DoublyNode(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        DoublyNode end = new DoublyNode(d);
        DoublyNode n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyNode node = (DoublyNode) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "DoublyNode{" +
                "next=" + next +
                ", prev=" + prev +
                ", data=" + data +
                '}';
    }
}
