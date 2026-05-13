class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length * 2;

        int res[] = new int [n];
        int idx = 0;
        int len = nums.length;
        for(int i : nums){
            res[idx] = i;
            res[idx + len] = i;
            idx++;
        }

        return res;
    }
}