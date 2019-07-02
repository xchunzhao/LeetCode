### 动态规划
> 与递归相反，动态规划从寻常入手，逐步扩大规模到最优子结构。

##### 动态规划两个要素
- 状态转移方程
- 临界条件

举个简单的🌰：
一个人爬楼梯，每次只能爬1个或者2个台阶，假设有n个台阶，那这个人有多少种爬楼梯方法？

> 递归方式
```
function climbStairs(n) {
  if (n === 1) return 1;
  if (n === 2) return 2;
  return climbStairs(n - 1) + climbStairs(n - 2);
}
```
递归有很多重复计算，可以使用Hash去缓存中间结果，省去不必要的计算。
递归是从问题的结果推导,直到问题的规模缩小到寻常。
而动态规划是从寻常入手，逐步扩大规模到最优子结构。
有点拗口，不过可以用动态规划处理上述的问题：
> 动态规划
```
function climbStairs(n) {
  if (n === 1) return 1;
  if (n === 2) return 2;
  let prev = 1;
  let cur = 2;
  let temp;
  for(let i=3; i<=n; i++) {
    temp = prev + cur;
    prev = cur;
    cur = temp;
  }
  return temp;
}
```
动态规划的查表过程如下:
![dynamic-program](https://github.com/azl397985856/leetcode/blob/master/assets/thinkings/dynamic-programming-3.png)

再结合之前提到的两大要素:
- 状态转移方程(`f(n) = f(n-1) + f(n-2) `)
- 临界条件(`n=1 || n=2`)
