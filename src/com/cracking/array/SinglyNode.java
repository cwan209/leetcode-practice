package com.cracking.array;

import java.util.Objects;

public class SinglyNode {
    SinglyNode next = null;
    int data;

    public SinglyNode(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        SinglyNode end = new SinglyNode(d);
        SinglyNode n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyNode node = (SinglyNode) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
