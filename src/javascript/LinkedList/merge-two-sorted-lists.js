/*
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

  示例：

  输入：1->2->4, 1->3->4
  输出：1->1->2->3->4->4
 * @Author: zhaoxc 
 * @Date: 2019-04-22 21:02:16 
 * @Last Modified by: zhaoxc
 * @Last Modified time: 2019-04-22 21:43:39
 */

 /**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 思路：两个指针进行比较节点值，把当前节点next指向数值小的节点，直到某个指针走到最后，直接脸上该指针剩下的链表。时间复杂度O(n)
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
  var dummy = new ListNode(0);
  var cur = dummy;
  while(l1 !== null && l2 !== null) {
    if(l1.val < l2.val) {
      cur.next = l1;
      l1 = l1.next;
      cur = cur.next;
    } else {
      cur.next = l2;
      l2 = l2.next;
      cur = cur.next;
    }
  }
  //此时l1\l2至少一个指针以及走到最后
  if(l1 === null) {
    cur.next = l2;
  } else {
    cur.next = l1;
  }
  return dummy.next;
};