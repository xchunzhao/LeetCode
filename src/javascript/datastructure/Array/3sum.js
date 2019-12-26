/**
 * @description
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

    满足要求的三元组集合为：
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
 * 
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  const result = [];
  const size = nums.length;
  if(!nums && size < 3) {
    return result;
  }
  nums.sort((a,b) => a-b);
  //保证有正负数
  if(!(nums[0] <= 0 && nums[size-1] >=0)){
    return result;
  }
  //固定一个指针i
  /** 
   * 双指针start end 初始值为i+1 & size-1
   * 3数相加 sum
   * sum < 0 start右移
   * sum > 0 end左移
   * sum = 0 记录三个数
   * (结束条件start = end - 1)
   * 
   * 再右移固定指针i 重置start & end
  */
  let i = 0;
  while(i <= size - 3) {
    if(nums[i] > 0 ) break;
    let start = i + 1;
    let end = size - 1;
    while(start < end) {
      const sum = nums[i] + nums[start] + nums[end];
      if(sum === 0) {
        result.push([nums[i], nums[start], nums[end]]);
      }
      if(sum <= 0) {
        // start ++; 这样存在重复值
        while(nums[start] === nums[++start]){}
      } else {
        // end --; 同上
        while(nums[end] === nums[--end]){}
      }
    }
    while(nums[i] === nums[++i]){}
  }
  return result;
};