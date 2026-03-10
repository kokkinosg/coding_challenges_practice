public class maximum_product_subarray {

    public int solution(int[] nums){

        // Keep track of the minimum and maximum possible scores. We start from the first subarray which is just the first element
        // For example, nums = [4,-1,2,1]
        int maxProductEndsHere = nums[0]; // 4
        int minProductEndsHere = nums[0]; // 4
        int result = nums[0]; // 4

        // Now we are going through all elements calculating at each opsition the maximum and minimum possible product of all subarrays before it. 
        // Basically at each element, 3 things can happen to get hte maximum sub array. 
        // 1) Start a new subarray 
        // 2) Extend the previous maximum product
        // 3) Extend the previous minimum product (if the minimum is -ve, you can get a very large positive when the current elemtn is also negative. So we cannot just ignore this.)

        for (int i = 1; i < nums.length; i++){

            int current = nums[i];

            int product1 = current;
            int product2 = current * maxProductEndsHere;
            int product3 = current * minProductEndsHere;

            int newMax = Math.max(product1, Math.max(product2, product3));
            int newMin = Math.min(product1, Math.min(product2, product3));

            maxProductEndsHere = newMax;
            minProductEndsHere = newMin;

            result = Math.max(result, maxProductEndsHere);
        }

        return result;
    }
    
}
