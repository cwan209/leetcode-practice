package com.cracking.array;


import java.util.ArrayList;

public class LinkedListQuestions {

    public SinglyNode removeDups(SinglyNode dupNodeHead) {
        // with buffer
        var appearedIntegers = new ArrayList<Integer>();
        SinglyNode slow = dupNodeHead;
        SinglyNode fast = dupNodeHead.next;
        while(slow.next != null) {
            int data = slow.data;
            appearedIntegers.add(data);
            if (appearedIntegers.contains(fast.data)) {
                slow.next = fast.next;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return dupNodeHead;
    }


    public DoublyNode findKthElement(DoublyNode head, int distance) {
        DoublyNode slow = head;
        DoublyNode fast = head;
        for (int i = 0; i < distance; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public void deleteMiddleNode(SinglyNode middleNode) {
        int buffer1 = middleNode.data;
        int buffer2;

        while(middleNode.next != null) {
            buffer2 = middleNode.next.data;
            middleNode.next.data = buffer1;
            middleNode = middleNode.next;
            buffer1 = buffer2;
        }
    }
}
