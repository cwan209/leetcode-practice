package com.cracking.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LInkedListQuestionsTest {

    private final LinkedListQuestions linkedListQuestions = new LinkedListQuestions();

    @Test
    void removeDups() {
        // with dups
        var dupHead = new SinglyNode(1);
        var node2 = new SinglyNode(2);
        var node3 = new SinglyNode(1);
        var node4 = new SinglyNode(3);
        dupHead.next = node2;
        node2.next = node3;
        node3.next = node4;

        // without dups
        var noDupHead = new SinglyNode(1);
        var node5 = new SinglyNode(2);
        var node6 = new SinglyNode(3);
        noDupHead.next = node5;
        node5.next = node6;

        assertEquals(noDupHead, linkedListQuestions.removeDups(dupHead));
    }

    @Test
    void findKthElement() {
        var head = new DoublyNode(1);
        var node2 = new DoublyNode(2);
        var node3 = new DoublyNode(1);
        var node4 = new DoublyNode(3);
        var node5 = new DoublyNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // when
        assertEquals(new DoublyNode(3), linkedListQuestions.findKthElement(head, 2));
    }

    @Test
    void deleteMiddleNode() {
        // with dups
        var dupHead = new SinglyNode(1);
        var node2 = new SinglyNode(2);
        var node3 = new SinglyNode(1);
        var node4 = new SinglyNode(3);
        dupHead.next = node2;
        node2.next = node3;
        node3.next = node4;

        // without dups
        var noDupHead = new SinglyNode(1);
        var node5 = new SinglyNode(2);
        var node6 = new SinglyNode(3);
        noDupHead.next = node5;
        node5.next = node6;

        linkedListQuestions.deleteMiddleNode(node3);
        assertEquals(noDupHead, dupHead);
    }
}