public class search_array {

    //To solve this I will use binary search 
    public int solution(int[] nums, int target){

        // Define the left and right indexes
        int left = 0;
        int right = nums.length - 1;

        // Because array is rotated, each time one half is sorted.
        // Check whether the target lies in the sorted half.
        // If yes, keep that half. Otherwise, keep the other half.
        while (left <= right) {

            // Middle index must always be recomputed inside the loop
            int middle = left + (right - left) / 2;

            // Check if middle is the target
            if (nums[middle] == target) {
                return middle;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[middle]) {

                // Check if target is inside the sorted left half
                if (target >= nums[left] && target < nums[middle]) {
                    right = middle - 1; // reduce the searh space otherwise we may get infinite loop
                } else {
                    left = middle + 1;
                }

            } else { // The right half is sorted

                // Check if target is inside the sorted right half
                if (target > nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}
