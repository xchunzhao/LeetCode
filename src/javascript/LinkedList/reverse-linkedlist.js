/**
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 * 翻转链表
 * @S1: 递归。翻转后面的node。将翻转后的尾节点指向head
 * @S2: 非递归.
 * @param {*} head 
 */
var reverseLinkedList = function(head) {
  if(head === null || head.next === null) {
    return head;
  }
  var newHead = reverseLinkedList(head.next);
  head.next.next = head;
  head.next = null;
}
var reverseLinkedList = function(head) {
  if(head === null || head.next === null) {
    return head;
  }
  var cur = head;
  var pre = null;
  while(cur !== null) {
    var temp = cur.next;
    cur.next = pre;
    pre = cur;
    cur = temp;
  }
  return pre;
}
