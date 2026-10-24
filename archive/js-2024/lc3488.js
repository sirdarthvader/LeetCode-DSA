/**
 *
 * 
LC - 3488. Closest Equal Element Queries

You are given a circular array nums and an array queries.

For each query i, you have to find the following:

The minimum distance between the element at index queries[i] and any other index j in the circular array, where nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
Return an array answer of the same size as queries, where answer[i] represents the result for query i.

 

Example 1:

Input: nums = [1,3,1,4,1,3,2], queries = [0,3,5]

Output: [2,-1,3]

Explanation:

Query 0: The element at queries[0] = 0 is nums[0] = 1. The nearest index with the same value is 2, and the distance between them is 2.
Query 1: The element at queries[1] = 3 is nums[3] = 4. No other index contains 4, so the result is -1.
Query 2: The element at queries[2] = 5 is nums[5] = 3. The nearest index with the same value is 1, and the distance between them is 3 (following the circular path: 5 -> 6 -> 0 -> 1).
Example 2:

Input: nums = [1,2,3,4], queries = [0,1,2,3]

Output: [-1,-1,-1,-1]

Explanation:

Each value in nums is unique, so no index shares the same value as the queried element. This results in -1 for all queries.

 

Constraints:

1 <= queries.length <= nums.length <= 105
1 <= nums[i] <= 106
0 <= queries[i] < nums.length

*/

var solveQueries = function (nums, queries) {
  const n = nums.length;

  // Step 1: Group indices by value, and track each index's position in its group
  const groupMap = new Map(); // value -> [indices]
  const posInGroup = new Array(n); // index -> position within its group

  for (let i = 0; i < n; i++) {
    const val = nums[i];
    if (!groupMap.has(val)) groupMap.set(val, []);
    const group = groupMap.get(val);
    posInGroup[i] = group.length;
    group.push(i);
  }

  // Step 2: Answer each query in O(1)
  const answer = new Array(queries.length);

  for (let q = 0; q < queries.length; q++) {
    const idx = queries[q];
    const group = groupMap.get(nums[idx]);

    if (group.length === 1) {
      answer[q] = -1;
      continue;
    }

    const pos = posInGroup[idx];
    const len = group.length;

    // Check left and right neighbors in the sorted group (circular)
    const left = group[(pos - 1 + len) % len];
    const right = group[(pos + 1) % len];

    // In a circular array, you can go two ways between two indices:
    // 1. The direct/forward path: just |a - b|
    // 2. The wrap-around path: n - |a - b| (go the other way around)
    // The shortest of the two is the circular distance.
    const directDistToLeft = Math.abs(idx - left);
    const wrapDistToLeft = n - directDistToLeft;
    const minDistToLeft = Math.min(directDistToLeft, wrapDistToLeft);

    const directDistToRight = Math.abs(idx - right);
    const wrapDistToRight = n - directDistToRight;
    const minDistToRight = Math.min(directDistToRight, wrapDistToRight);

    answer[q] = Math.min(minDistToLeft, minDistToRight);
  }

  return answer;
};
