/*
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

  示例:

  输入:
  [
    1->4->5,
    1->3->4,
    2->6
  ]
  输出: 1->1->2->3->4->4->5->6
 * @Author: zhaoxc 
 * @Date: 2019-04-22 21:28:30 
 * @Last Modified by: zhaoxc
 * @Last Modified time: 2019-04-22 21:50:16
 */

 
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 思路1: 两两合并，调用merge-two-sorted-lists。时间复杂度O(m*n)
 * 思路2: 
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
  var len = lists.length;
  if(len === 0 ) {
    return null;
  }
  var mergeNode = lists[0];
  for(let i = 1; i < len; i++) {
    mergeNode = mergeTwoLists(mergeNode, lists[i]);
  };
  return mergeNode;
};

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