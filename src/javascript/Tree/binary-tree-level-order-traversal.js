/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

  例如:
  给定二叉树: [3,9,20,null,null,15,7],

      3
    / \
    9  20
      /  \
    15   7
  返回其层次遍历结果：

  [
    [3],
    [9,20],
    [15,7]
  ]
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @S1 递归
 * @S2 队列
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  const result = [];
  if(!root) return result;
  recursiveBFS(root, 0, result);
  return result;
};

var recursiveBFS = function(node, level, result) {
  if(result.length === level) {
    result.push([]);
  }
  result[level].push(node.val);
  node.left && recursiveBFS(node.left, level+1, result);
  node.right && recursiveBFS(node.right, level+1, result);
}

var levelOrder2 = function(root) {
  const result = [];
  const queue = [];
  root && queue.push(root);
  while(queue.length > 0) {
    const partition = [];
    const preSize = queue.length;
    queue.forEach(node => {
      partition.push(node.val);
      if(item.left) {
        queue.push(item.left);
      }
      if(item.right) {
        queue.push(item.right);
      }
    });
    queue.splice(0,preSize);
    result.push(partition);
  }
  return result;
};