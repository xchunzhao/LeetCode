/**
 * 给定一个二叉树，返回它的中序 遍历。

    示例:

    输入: [1,null,2,3]
      1
        \
        2
        /
      3

    输出: [1,3,2]
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * S1:递归
 * S2:栈
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
  var result = [];
  recursiveFindNode(root, result);
  return result;
};

var recursiveFindNode = function(root, result){
  if(!root) return;
  recursiveFindNode(root.left, result);
  result.push(root.val);
  recursiveFindNode(root.right, result);
}


//利用栈保存节点
var inorderTraversal2 = function(root) {
  var result = [];
  var stack = [];
  while(stack.length || root) {
    if(root) {
      stack.push(root);
      root = root.left;
    }else {
      root = stack.pop();
      result.push(root.val);
      root = root.right;
    }
  }
  return result;
};