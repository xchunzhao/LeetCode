package algorithm.TAOPP.Chapter1.Rotate;

/**
 * Author : zhaoxiaochun
 * Date : 2016/9/22
 * 链表翻转。给出一个链表和一个数k，
 * 比如，链表为1→2→3→4→5→6
 * k=2,则翻转后2→1→6→5→4→3，
 * 若k=3，翻转后3→2→1→6→5→4，
 * 若k=4，翻转后4→3→2→1→6→5，用程序实现
 */
public class Rotate01_01 {
    class ListNode{
        int val;
        ListNode next ;

        public ListNode() {
        }

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
    /**
     * 可将链表分成两段，分别反转链表，最后连接
     */
    private static void retateListNode(ListNode head, int k){
        //用于连接两段链表 第一段链表的尾节点
        ListNode tail1 = head;

//        ListNode head1 = ReverseListNode()
    }

    private static ListNode ReverseListNode(ListNode head, int k){
        if (head == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode tmp;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;

    }
}
