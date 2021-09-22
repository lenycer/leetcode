package com.example.medium;

import java.util.List;
import java.util.stream.Collectors;

public class AddTwoNumbers {

    public static void main(String[] args) {
        //243
//        ListNode listNode243 = new ListNode(0, new ListNode(4, new ListNode(9)));
        ListNode listNode243 = new ListNode(9);

        //564
        ListNode listNode564 = new ListNode(1, new ListNode(9, new ListNode(9
                , new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

        ListNode listNode = addTwoNumbers2(listNode243, listNode564);

//        long num = getNum("", listNode243);
//        long num2 = getNum("", listNode564);
//        System.out.println(num);
//        System.out.println(num2);
        System.out.println(listNode);
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return getResultNode(0, l1, l2);
    }

    public static ListNode getResultNode(int preVal, ListNode l1, ListNode l2) {
        int val = (l1.val + l2.val + preVal) % 10;
        int nextVal = (l1.val + l2.val + preVal) / 10;
        if(l1.next == null && l2.next == null) {
            return new ListNode(val, nextVal > 0 ? new ListNode(nextVal) : null);
        } else {
            if (l1.next == null) {
                return new ListNode(val, getResultNode(nextVal, new ListNode(), l2.next));
            } else if (l2.next == null) {
                return new ListNode(val, getResultNode(nextVal, l1.next, new ListNode()));
            } else {
                return new ListNode(val, getResultNode(nextVal, l1.next, l2.next));
            }
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long result = getNum("", l1) + getNum("", l2);
        System.out.println("dd"+result);
        return getListNode(result);
    }

    public static long reverse(long x) {
        long result = 0;
        while (true) {
            result = result * 10  + x % 10;
            x = x / 10;
            if (x == 0)
                break;
        }
        return result;
    }

    public static ListNode getListNode(long result) {
        int val = (int) (result % 10);
        if(result / 10 > 0) {
            return new ListNode(val, getListNode(result / 10));
        } else {
            return new ListNode(val);
        }
    }

    public static long getNum(String s, ListNode listNode) {
        s += listNode.val;
        System.out.println(s);
        if (listNode.next == null) {
            return Long.parseLong(new StringBuffer(s).reverse().toString());
        }
        return getNum(s, listNode.next);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
