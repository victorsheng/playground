package com.example.demo.linklist;

/**
 * https://troywu0.gitbooks.io/interview/content/%E5%90%88%E5%B9%B6%E4%B8%A4%E4%B8%AA%E6%9C%89%E5%BA%8F%E9%93%BE%E8%A1%A8.html
 */
public class MergeSortLinked {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class Solution {

        public ListNode min(ListNode list1, ListNode list2) {
            return list1.val < list2.val ? list1 : list2;
        }

        public ListNode Merge(ListNode list1, ListNode list2) {
            if (list1 == null)
                return list2;
            if (list2 == null)
                return list1;
            ListNode list = null;
            ListNode head = null;//记录头结点
            //list1的头步小于list2的头部
            if (list1.val < list2.val) {
                //由于list1和list2都是有序的,说明list1节点是最小的
                list = list1;
                list1 = list1.next;
            } else {
                list = list2;
                list2 = list2.next;
            }
            head = list;
            while (list1 != null && list2 != null) {
                list.next = min(list1, list2);//取较小节点
                list = list.next;//list后移
                if (list == list1)
                    list1 = list1.next;
                else
                    list2 = list2.next;
            }
            if (list1 == null) {
                list.next = list2;
            } else {
                list.next = list1;
            }
            return head;
        }
    }

    /**
     * 自己手动实现
     */
    public static class MySolution {

        public ListNode min(ListNode list1, ListNode list2) {
            return list1.val < list2.val ? list1 : list2;
        }

        public ListNode Merge(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            }
            //结果链表的初始指针
            ListNode head = null;
            //当前链表的指针
            ListNode now;
            //比较第一个
            if (list1.val < list2.val) {
                now = list1;
                list1 = list1.next;
            } else {
                now = list2;
                list2 = list2.next;
            }
            head = now;

            while (list1 != null && list2 != null) {

                ListNode min = min(list1, list2);
                now.next = min;
                now = min;
                if (min == list1) {
                    list1 = list1.next;
                } else {
                    list2 = list2.next;
                }
            }

            if (list1 == null) {
                now.next = list2;
            } else {
                now.next = list1;
            }


            return head;
        }
    }

    public static void main(String[] args) {
        MergeSortLinked.ListNode l1 = new MergeSortLinked.ListNode(2);
        l1.next = new MergeSortLinked.ListNode(3);
        l1.next.next = new MergeSortLinked.ListNode(4);
        MergeSortLinked.ListNode l2 = new MergeSortLinked.ListNode(5);
        l2.next = new MergeSortLinked.ListNode(6);
        l2.next.next = new MergeSortLinked.ListNode(9);
        MySolution solution = new MySolution();
        ListNode merge = solution.Merge(l1, l2);
        String str_result = "";
        while (merge.next != null) {
            merge = merge.next;
            str_result += String.valueOf(merge.val);
        }
        System.out.println(str_result);
    }
}
