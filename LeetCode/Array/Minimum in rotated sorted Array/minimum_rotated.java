import java.util.Arrays;

public class minimum_rotated {

    // My idea is to split the array into two halves. With the middle element included in both arrays. 
    // This is based on my theory one of the two halves, the last element will be smaller than the first element.
    // So by keeping the middle element in both arrays, avoids the problem that [4,5,6,0,1,2] -> [4,5,6] & [0,1,2] where both haves are sorted. 
    // Basically my idea is to keep halving hte arrays until both arrays are sorted. In that case, the first element is the smallest number. 
    // E.g. 7/2  = 3 (integer division ignores half, so 3rd element is kept in both arrays. 
    // E.g. nums = [4,5,6,7,0,1,2] -> [4,5,6] & [6,7,0,1,2]
    // E.g. 4/2 = 2 (2nd element is kept in both) nums = [11,13,15,17] -> [11,13] & [13,15,17]
    // 
    // Firstly check if the first element smaller than the last element. If that is the case, then the array is already sorted thus the first element is the smallest num.

    public int solution(int[] nums){

        
        // Edge case 1: Array is already sorted from smallest to largest. 
        if (nums[0] < nums[nums.length-1]){
            return nums[0];
        }

        // Edge case 2: Array is just 1 element. In that case return it. 
        if (nums.length == 1){
            return nums[0];
        }

        // If we got here, we have an array of at least 2 elements which is not sorted. 
        // Create a copy of the nums array
        // E.g arr = [4,5,6,7,0,1,2] 
        int[] arr = nums.clone();
        
        // Keep the splitting loop until both halves are sorted/
        while (true){
            // Check if only two elements are left.
            if (arr.length == 2){
                if(arr[0]<arr[1]){
                    return arr[0];
                } else {
                    return arr[1];
                }
            }


            // Reset the flags
            boolean firstHalfSorted = false;
            boolean secondHalfSorted = false; 

            // Get the middle position
            // For [4,5,6,7,0,1,2] , middle_pos = 7/2 = 3. 
            // 2nd iter: [6, 7, 0, 1], middle_pos = 4/2 = 2
            // 3rd iter: [7,0,1], middle_pos = 3/2 = 1
            int middle_pos = arr.length / 2;

            // Create the first half and second half arrays inlcuding hte middle element in both. 
            // E.g first_half = [4,5,6]
            //  2nd iter: first_half = [6,7]
            // 3rd iter: first_half = [7]
            int[] first_half = Arrays.copyOfRange(arr, 0, middle_pos); // From first to middle element. 
            // E.g. second_half = [6,7,0,1]
            // 2nd iter: first_half = [7,0,1]
            // 3rd iter: second_half = [7,0,1]
            int[] second_half = Arrays.copyOfRange(arr, middle_pos, arr.length-1); // From middle to last element.

            // Check if the first half is sorted
            // E.g for first_half = [4,5,6] it is TRUE
            // 2nd iter: for first hald is TRUE
            if (first_half[0] < first_half[first_half.length -1]){
                firstHalfSorted = true;
            }

            // Check if the second half is sorted
            // E,g, for second_half = [6,7,0,1] is FALSE
            // 2nd iter, for second half is FALSE
            if (second_half[0] < second_half[second_half.length -1]){
                secondHalfSorted = true;
            }

            // If both are sorted, then the answer is the first element from the first half
            if (firstHalfSorted && secondHalfSorted){
                return first_half[0];
            }

            // Other wise check if the first half is sorted. If it is, then it means the second half isn't.
            if (firstHalfSorted){
                // Now arr, is the second half and split again. 
                // arr = [6,7,0,1]
                // 2nd iter arr = [7,0,1]
                arr = second_half.clone();
            } else {
                arr = first_half.clone();
            }
        }
    }


    
    
}
