function longestBoundedFrequency(nums: number[], k: number): number {
  // declare the freequency map
  const frequency = new Map<number, number>();

  // declare vars
  let left = 0;
  let best = 0;

  for (let right = 0; right < nums.length; right++) {
    // get the current value under iteration
    const value = nums[right];

    //update the frequency map with the current value
    frequency.set(value, (frequency.get(value) ?? 0) + 1);


    //check for the numbers and make sure that the sub array being checked is always valid

    while ((frequency.get(value) ?? 0) > k) {
      const leftValue = nums[left];

      // update the frequency map by keepig the "k" value in check
      frequency.set(leftValue, (frequency.get(leftValue) ?? 0) - 1);
      left++;
    }
    best = Math.max(best, right - left + 1);
  }

  return best;
}
