/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

    你可以假设数组是非空的，并且给定的数组总是存在众数。

    示例 1:

    输入: [3,2,3]
    输出: 3
    示例 2:

    输入: [2,2,1,1,1,2,2]
    输出: 2
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  //排序
  nums.sort((a,b) => a - b);
  /**
   * 定义双指针，i j
   * i先固定，nums[i] === nums[j] 就右移
   * 否则记录j-i 并将i=j,重置j
   */
  //众数下标
  let majorityIndex = 0;
  //众数个数
  let max = 0;
  const size = nums.length;
  for(let i = 0 ; i <= size - 1 ;) {
    let j = i;
    while(nums[i] === nums[++j]){};
    const currentMax = j - i;
    if(currentMax > max) {
      max = currentMax;
      majorityIndex = i;
    }
    i = j;
  };
  return nums[majorityIndex];
};