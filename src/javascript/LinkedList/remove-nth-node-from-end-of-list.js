/*
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    示例：

    给定一个链表: 1->2->3->4->5, 和 n = 2.

    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：

    给定的 n 保证是有效的。
 * @Author: zhaoxc 
 * @Date: 2019-04-22 16:13:03 
 * @Last Modified by: zhaoxc
 * @Last Modified time: 2019-04-22 16:50:45
 */

/**
 * Definition for singly-linked list.
 * function Node(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 思路：
   删除链表节点，需要找到删除节点的前一个Node以及当前Node.然后把pre.next = cur.next
   所以需要先找到倒数第N个节点
   1、遍历链表找到倒数第N个节点删除
   2、双指针法。前后两个相差N个节点，只需当我后面的指针Node.next === null ,即前面Node以及是倒数N个节点。
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
  //守卫节点
  var dummy = new Node(0);
  dummy.next = head;
  var first = dummy;
  var second = dummy;

  for(let i = 0; i < n+1; i++) {
    first = first.next;
  }
  while(first !== null) {
    first = first.next;
    second = second.next;
  }
  //first走到最后，second走到倒数N+1个节点。
  second.next = second.next.next;
  return dummy.next;
};
