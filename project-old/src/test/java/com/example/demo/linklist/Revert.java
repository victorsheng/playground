package com.example.demo.linklist;

public class Revert {

    public static void main(String[] args) {
        Node l1 = new Node(10);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(6);
        l1.next.next.next.next = new Node(4);
        Node result = revert(l1);

        String str_result = String.valueOf(result.value);
        while (result.next != null) {
            result = result.next;
            str_result += String.valueOf(result.value);
        }
        System.out.print(str_result);

    }

    private static Node revert(Node head) {
        Node result, now = null;
        now = head;
        result = null;
        while (now != null) {
            Node next = now.next;
            now.next = result;
            result = now;
            now = next;
        }

        return result;
    }


    public static Node reverseList(Node head) {

        //如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node next = null; //定义当前结点的下一个结点
        Node reverseHead = null;  //反转后新链表的表头

        while (current != null) {
            next = current.next;  //暂时保存住当前结点的下一个结点，因为下一次要用

            current.next = reverseHead; //将current的下一个结点指向新链表的头结点
            reverseHead = current;

            current = next;   // 操作结束后，current节点后移
        }

        return reverseHead;
    }

}

class Node {

    public Node(int value) {
        this.value = value;
    }

    int value;

    Node next;

}
