import java.util.Arrays;
import java.util.HashMap;

public class Two_Sums {

    public int[] twoSum_bruteforce(int[] nums, int target) {

        // Numbers larger than target can be excluded from the analysis 
        
        int current = 0;

        for (int i =0 ; i < nums.length; i++){
            
            current = nums[i];
            // Look for the remainder in the nums 
            for (int j = 0;  j < nums.length; j++){

                int remainder = target - current;

                // we have a valid result if the remainder is found in the nums array and i != j which is one of the rules of the question. 
                if (remainder == nums[j] && i !=j){
                    
                    return new int[]{i,j};
                    
                }
            }
            
        }
        return new int[]{};
    }

    public int[] twoSum_optimised(int[] nums, int target){
        // I am going to use a hash map to store the (nums[i],i)

        HashMap<Integer,Integer> seen = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++){
            
            // Calculate the number we are looking for 
            int remainder = target - nums[i];
            
            // Check if the remainder exists in the hash map 
            if (seen.containsKey(remainder)){
                // Get the  index of the remainder
                int remain_idx = seen.get(remainder);

                return new int[]{remain_idx,i};
            }
            
            // Add the explored value in the hash map
            seen.put(nums[i],i);
        }
        // If no matches, return empty array
        return new int[]{};
    }


    public static void main(String[] args) {

        Two_Sums my_class = new Two_Sums();

        int [] nums = {3,3};
        int target = 6;

        int[] brute_results = my_class.twoSum_bruteforce(nums, target);
        int[] optimised_results = my_class.twoSum_optimised(nums, target);

        System.out.println(Arrays.toString(brute_results));
        System.out.println(Arrays.toString(optimised_results));
    }
}