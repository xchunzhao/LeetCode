/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package test;
public class AddTwoNumbers {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }
        ListNode result;
        ListNode cur;
        int curSum=0;
        curSum=l1.val+l2.val;
        boolean isPlus=false;
        if (l1.val+l2.val>9){
            isPlus=true;
            curSum=curSum%10;
        }
        cur=new ListNode(curSum);
        result=cur;
        while(l1.next!=null&&l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            if (isPlus) {
                curSum = l1.val + l2.val+1;
            }else{
                curSum=l1.val+l2.val;
            }
            if (curSum>9){
                isPlus=true;
            }else{
                isPlus=false;
            }
            cur.next=new ListNode(curSum);
            cur=cur.next;
        }
        if (l1.next==null&&l2.next==null){
            if (isPlus){
                cur.next=new ListNode(1);
            }
            return result;
        }else if (l1.next==null){
            while (l2.next!=null){
                l2=l2.next;
                if (isPlus){
                    curSum=1+l2.val;
                    if (curSum>9){
                        isPlus=true;
                        curSum=curSum%10;
                    }else{
                        isPlus=false;
                    }
                }else{
                    curSum=l2.val;
                    isPlus=false;
                }
                cur=new ListNode(curSum);
                cur=cur.next;
            }
        }else if (l2.next==null){
            while (l1.next!=null){
                l1=l1.next;
                if (isPlus){
                    curSum=1+l2.val;
                    if (curSum>9){
                        isPlus=true;
                        curSum=curSum%10;
                    }else{
                        isPlus=false;
                    }
                }else{
                    curSum=l2.val;
                    isPlus=false;
                }
                cur=new ListNode(curSum);
                cur=cur.next;
            }
        }
        if (isPlus){
            cur.next=new ListNode(1);
        }
        return result;
    }
}