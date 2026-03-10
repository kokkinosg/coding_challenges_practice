public class max_subarray {

    public int solution(int[] nums){

        // Create a prefix sums array
        int[] prefix_sums = new int[nums.length];

        // Populate the prefix sums 
        // Start with the first element
        prefix_sums[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefix_sums[i] = prefix_sums[i-1] + nums[i];
        }

        // The maximum sum of subarrray is found my the difference between the smallest and largest prefix sum but smallest must come before the largest. 
        int max_value = Integer.MIN_VALUE;
        int min_prefix = 0;
        
        // Go over each element in hte prefix sums. Max value is either the previously calculated sum or using the current min_prefix. hen update the minimum prefix if the current eleemnt is smaller or keep the same. 
        for (int sum : prefix_sums) {
            max_value = Math.max(max_value, sum - min_prefix);
            min_prefix = Math.min(min_prefix, sum);
        }

        return max_value;
    }

    public static void main(String[] args) {
        
        max_subarray my_class = new max_subarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {5,4,-1,7,8};

        System.out.println(my_class.solution(nums2));
    }
    
}
