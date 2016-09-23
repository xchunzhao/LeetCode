package algorithm.TAOPP.Chapter1;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/23
 */
public class Chapter01 {

    /**
     * @Q1问题描述：
     * 在一个字符串中找到第一个只出现一次的字符。
     * 如输入abaccdeff，则输出b。
     * 思路1：遍历每个字符，当前字符跟后面字符判断，若重复flag=1。
     */
    private static char findOnceFirst1(char[] chars){
        if (chars == null || chars.length<=0){
            return '\0';
        }
        int len = chars.length;
        int flag = 0;
        for (int i =0 ;i < len ;i++){
            for (int j = i+1;j<len;j++){
                if (chars[i] == chars[j]){
                    flag = 1;
                }
            }

            if (flag == 0){
                return chars[i];
            }
        }
        return '\0';

    }

    /**
     * 思路2：构建一个hash表.
     * 1、维护一个数组，key为字符串，value为该字符串出现次数
     * 2、遍历该hash表，找到value=1的字符串
     * 时间复杂度O(n)
     * 空间复杂度O(256)
     */
    private static char findOnceFirst2(char[] chars){
        if (chars == null || chars.length<=0){
            return '\0';
        }
        int len = chars.length;

        int[] hash = new int[256];
        for (int i = 0 ;i<len;i++){
            hash[chars[i]]++;
        }
        for (int i =0 ;i<hash.length;i++){
            if (hash[i]==1){
                return (char) i;
            }
        }
        return '\0';
    }


    /**
     * @Q2 问题描述：
     * 反转链表
     * @param args
     */
    public class ListNode {
        int val;
        ListNode next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
    private static ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        while (head!=null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    /**
     * @Q3 问题描述
     * 给定单链表的一个结点的指针，同时该结点不是尾结点，
     * 此外没有指向其它任何结点的指针，请在O(1)时间内删除该结点
     *
     * 思路：删除节点，需要前置节点的引用。没有头结点。通过遍历不可达。
     * 节点值覆盖，再删除后面的节点。
     * @param args
     */
    private static void deleteNode(ListNode node){
        if (node == null || node.next == null){
            return;
        }
        ListNode post = node.next;
        node.val = post.val;
        node.next = post.next;
    }

    /**
     * @Q4 问题描述
     * 两个单向链表，找出它们的第一个公共结点
     * 思路:
     * LA<LB
     * 1、遍历两个链表判断尾节点是否相等，不相等，说明没有公共节点。
     * 2、若尾节点相等，则B可以跳过前LB-LA个节点。
     * 3、同时后移，相等则为第一个公共节点。
     *
     *
     * 思路2：反转两个链表
     * 1、分别反转两个链表
     * 2、头结点相等说明有公共节点。
     * 3、往后遍历，while终止条件是node1 != node2
     * 注意： 需要额外node保存上一次遍历的节点。
     * @param args
     */
    private static ListNode findFirstSameNode1(ListNode node1, ListNode node2){
        ListNode head1 = node1;
        ListNode head2 = node2;
        int len1 = 0,len2 = 0;
        int count = 0;
        while (node1!=null){
            node1 = node1.next;
            len1++;
        }
        while (node2!=null){
            node2 = node2.next;
            len2++;
        }
        if (node1!=node2){
            return null;
        }
        if (len1>len2){
            while (head1 != null && count<=len1-len2){
                head1 = head1.next;
                count++;
            }
        }else{
            while (head2 != null && count<=len2-len1){
                head2 = head2.next;
                count++;
            }
        }
        while (head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    private static ListNode findFirstSameNode2(ListNode node1, ListNode node2){
        node1 = reverseListNode(node1);
        node2 = reverseListNode(node2);

        if (node1 != node2){
            return null;
        }
        ListNode pre = null;
        while (node1 == node2){
            pre = node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        return pre;
    }




    public static void main(String[] args){
        char[] chars = "abaccdeff".toCharArray();
        System.out.println(findOnceFirst2(chars));
    }
}
