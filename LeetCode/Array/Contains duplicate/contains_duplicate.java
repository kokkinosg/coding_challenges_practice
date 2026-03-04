import java.util.HashSet; // Import the HashSet class

public class contains_duplicate {

    public boolean solution(int[] nums){
        
        // Create a set
        HashSet<Integer> set = new HashSet<Integer>();

        for (int num:nums){
            // Check if number is contained in the set, if not add it, if yes return True
            if (set.contains(num)){
                return true;
            }

            // Add the num to the set
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        
        contains_duplicate my_class = new contains_duplicate();

        int[] nums = {1,2,3,4,4};

        System.out.println(my_class.solution(nums));
    }
    
}
