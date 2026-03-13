public class minimum_rotated {

    // My idea is that the array can be split to 2 halves, with the middle element included in both. 
    // If both are sorted, it means that the array is sorted, thus the smallest is the LEFT-most element.
    // Otherwise, one of them will be sorted. The unsorted one ontains the smallest element. 
    // So I keep splitting until both subarrays are sorted. in that case, it is the LEFT-most element from the first sub-array

    public int solution(int[] nums){

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // If current range is already sorted, the minimum is the leftmost element
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            int middle = left + (right - left) / 2;

            // Minimum is in the right half
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            }
            // Minimum is at middle or in the left half
            else {
                right = middle;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        minimum_rotated my_class = new minimum_rotated();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(my_class.solution(nums));
    }
}


    
    

