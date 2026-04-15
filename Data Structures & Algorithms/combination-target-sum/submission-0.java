class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting helps with pruning later
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain == 0) {
            // Found a valid combination, make a deep copy
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Pruning: if the current number is greater than the remainder, 
            // no need to check this or any larger numbers (since the array is sorted)
            if (nums[i] > remain) break;

            tempList.add(nums[i]);
            // Notice: we pass 'i' as the start index, not 'i + 1' 
            // because we can reuse the same element
            backtrack(result, tempList, nums, remain - nums[i], i);
            
            // Standard backtracking: remove the last element before the next iteration
            tempList.remove(tempList.size() - 1);
        }
    }
}