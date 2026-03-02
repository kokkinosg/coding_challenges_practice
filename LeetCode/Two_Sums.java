import java.util.Arrays;

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


    public static void main(String[] args) {

        Two_Sums my_class = new Two_Sums();

        int [] nums = {3,2,4};
        int target = 5;

        int[] results = my_class.twoSum_bruteforce(nums, target);

        System.out.println(Arrays.toString(results));
    }
}