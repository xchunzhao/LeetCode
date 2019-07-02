/**
 * 有一个背包，他的容量为C(Capacity)。
 * 现在有n中不同的物品，编号为0…n-1，
 * 其中每一件物品的重量为w(i)，价值为v(i)。
 * 问可以向这个背包中盛放哪些物品，
 * 使得在不超过背包容量的基础上，物品的总价值最大。
 * 
 * 
 * @Solution:
 * 状态定义:F(n,c)是将n个物品放进剩余容量为c的背包，使得价值最大
 * 
 * 状态转移方程：
 * 假设存在F(i,c),对于F(i,c),存在两种情况，将第i个物品加入和忽略第i个物品
 * 即：
 * F(i,c) = max{F(i-1,c), v(i) + F(i-1,c-w(i))}
 * => 
 * f[i][c] = max{f[i-1][c], v[i] + f[i-1][c-w[i]]}
 * @param {*} vals 物品价值[]
 * @param {*} weights 物品重量[]
 * @param {*} capacity 背包容量
 */
var knapsack = function(vals, weights, capacity) {

}