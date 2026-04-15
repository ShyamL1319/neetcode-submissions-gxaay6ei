class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add the current subset (starts with empty, grows over time)
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Include the element
            current.add(nums[i]);
            // Recurse to the next element
            backtrack(result, current, nums, i + 1);
            // Exclude the element (backtrack)
            current.remove(current.size() - 1);
        }
    }
}