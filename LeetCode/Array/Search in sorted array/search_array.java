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
            // Check if the array has split enough times that the length of each half is 1
            if (right - left == 1){
                // Check if the target is the left element or right
                if(nums[left] == target){
                    return left; // return the index of the target
                } else if (nums[right] == target){
                    return right;
                } else {
                    // This means target is not in the array
                    return -1;
                }
            }

            // Do the splitting 

            // Check if the left half is sorted
            if(nums[left]<nums[middle]){
                // Check if the target is within this sorted half which is the left half
                if(target>=nums[left] && target <=nums[middle]){
                    // Split the sorted half
                    right = middle;
                    middle = left + (right -left)/2;
                } else {
                    // The target is in the unsorted right half. 
                    left = middle;
                    middle = left + (right-left)/2;
                }
                
            } else { // The right half is sorted. 
                
                // Check if the target is within this right half
                if(target>= middle && target <= nums[right]){
                    // Split the sorted right half
                    left = middle;
                    middle = left + (right-left)/2;
                } else {
                    // The target is in the unsorted left half. 
                    right = middle;
                    middle = left + (right-left)/2;
                }
            }
        }
    
    }
}
