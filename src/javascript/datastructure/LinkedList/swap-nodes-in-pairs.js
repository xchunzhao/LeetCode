/*
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

  你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

  

  示例:

  给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @Author: zhaoxc 
 * @Date: 2019-04-23 12:39:46 
 * @Last Modified by: zhaoxc
 * @Last Modified time: 2019-04-24 19:19:30
 */

 /**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 思路1：递归。交换前两个。交换后后面的node.next指向递归返回的头结点。
 * 思路2： 非递归。指针步长为2
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  if(head === null || head.next === null) {
    return head;
  }
  var next = head.next;
  head.next = swapPairs(next.next);
  next.next = head;
  return next;
};
