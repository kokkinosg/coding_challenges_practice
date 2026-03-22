public class search_array {

    //To solve this I will use binary search 
    public int solution(int[] nums, int target){

        // Define the left, middle and right indexes
        int left = 0;
        int right = nums.length;

        // Middle index needs to be relative to the left and right 
        int middle = left + (right-left)/2;

        // Because array is sorted, I just need each time to find out in which half of the array/subarray the number of interest is
        // Every time i split hte array, I get a sorted subarray and an unsorted subarray. From the sorted, I need to check if my target is within 
        // its left and right side, if not, split the unsorted. 
        while (true) { 
            // Check if the left half is sorted
            if(nums[left]<nums[middle]){
                // Check if the target is within this sorted half
                if(target>=nums[left] && target <=nums[middle]){
                    // Reassign the 

                }
                
            } else { //If right half is sorted

            }
            

            
        }
    
    }
}
