/*
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

 

  示例 1：

  输入：[-4,-1,0,3,10]
  输出：[0,1,9,16,100]
  示例 2：

  输入：[-7,-3,2,3,11]
  输出：[4,9,9,49,121]
  

  提示：

  1 <= A.length <= 10000
  -10000 <= A[i] <= 10000
  A 已按非递减顺序排序。
 * @Author: zhaoxc 
 * @Date: 2019-04-18 16:51:46 
 * @Last Modified by: zhaoxc
 * @Last Modified time: 2019-04-18 16:56:45
 */
/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortedSquares = function(A) {
  var suqares = A.map(num => num * num);
  return suqares.sort((a,b) => a - b );
};