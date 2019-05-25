/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

    k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

    示例 :

    给定这个链表：1->2->3->4->5

    当 k = 2 时，应当返回: 2->1->4->3->5

    当 k = 3 时，应当返回: 3->2->1->4->5 
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
  var cur = head;
  var count = 0;
  //将cur移动至下个K的头节点
  while (cur !== null && count !== k) {
    cur = cur.next;
    count += 1;
  }
  if(count === k) {
    //递归K个一组翻转链表后面的链表
    //只需将前K个节点翻转，并将尾节点指向cur
    cur = reverseKGroup(cur, k);
    while(count > 0) {
      var temp = head.next;
      head.next = cur;
      cur = head;
      head = temp;
      count -= 1;
    }
    head = cur;
  }
  return head;
};