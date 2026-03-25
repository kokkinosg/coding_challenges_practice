import java.util.*;

public class ThreeSum {

    public ArrayList<List<Integer>> solution(int[] nums){

        // Strore all triplets in a set to avoid duplicates (triplets must be sorted)
        HashSet<List<Integer>> results = new HashSet<>();

        // Go over each element in the array 
        for (int i =0; i < nums.length; i++){

            // For every i create a new set of seen values to avoid duplicates
            // These are all the values seen for this specific i. 
            HashSet<Integer> seen = new HashSet<>();

            // Go again over each element but actually enforce that i<j<k to avoid revisiting the same information. 
            for (int j= i+1; j < nums.length; j++){
                
                // Calculate the number to look out for 
                int remainder = -nums[i] -nums[j];

                // Check if the remainder has already been seen for this i
                if (seen.contains(remainder)){

                    // Create the triplet
                    List<Integer> triplet = new ArrayList<>();

                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(remainder);

                    // Sort the triplet   
                    Collections.sort(triplet);
                    
                    // Add the sorted list to the results. This will prevent duplicates.
                    results.add(triplet);
                }

                // Add the seen nums[j] after i look for the remainder in the seen set. 
                // This ensures that the index of my reaminder IS NOT k = j. 
                seen.add(nums[j]);
            }

        }
        // Convert the results set to an arraylist and return it
        return new ArrayList<>(results);

    }
    
}
