/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

    示例 1:

    输入: [1,2,0]
    输出: 3
    示例 2:

    输入: [3,4,-1,1]
    输出: 2
    示例 3:

    输入: [7,8,9,11,12]
    输出: 1
    说明:

    你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

 */

 /**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
  function swap(i,j){
    let tmp = nums[i]
    nums[i] = nums[j]
    nums[j] = tmp
  }
  const size = nums.length;
  // 桶排序
  for(let i= 0; i < size;i++){
    // 新索引 nums[i] 处于 [1,length] 且不等于自身（如第三项不能为3：nums[2]!==3） 且 nums[新索引] 未排好
    while(nums[i] >= 1 && 
      nums[i] <= size &&
      nums[i] !== i+1 && 
      nums[nums[i]-1] !== nums[i]){
      swap(i,nums[i]-1)
    }
  }
  for(let j=0 ; j< size ; j++){
    if(nums[j]!==j+1){
      return j+1
    }
  }
  return size + 1
};