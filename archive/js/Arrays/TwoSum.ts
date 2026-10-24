// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

function twoSum(nums: number[], target: number) {
  const map = {};

  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i]; // 4,

    if (map[complement] !== undefined) {
      return [map[complement], i]; // [2, 4]
    }

    map[nums[i]] = i; // {3: 0, 2: 1, 4: 2, 5: 3 }
  }

  return null; // If no solution found
}

// Test cases
console.log(twoSum([2, 7, 11, 15], 9)); // Output: [0, 1]
console.log(twoSum([3, 2, 4, 5, 7, 9], 11)); // Output: [2, 4]
console.log(twoSum([3, 3], 6)); // Output: [0, 1]
