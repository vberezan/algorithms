class Solution {
    
    private final HashMap<Integer, Integer> pairs = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (pairs.containsKey(num)) {
                return new int[] { pairs.get(num), i };
            }

            pairs.put(target - nums[i], i);
        }

        return new int[] {};
    }
}
