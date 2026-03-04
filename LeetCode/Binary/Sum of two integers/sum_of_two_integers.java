public class sum_of_two_integers {

    // Integers are stored in 32 bits. 
    // For example : int 5 = 00000000 00000000 00000000 00000101. There are 32 digits . We start from right to left
    // 1 bit is either 0 or 1 
    // Bitwise operators (right to left)
    // & = AND Tells us where the carry occurs. If both bits are 1, output 1, else 0
    // | = OR
    // ^ = XOR This adds bits without carrying. If the two bits are different output 1 else 0 
    // << left shift Move either 1 or 0 to the next column to the left. If there is a carry, it must happen in the next column.
    // >> right shift Move either 1 or 0 to the previous column (to the right). If there is a carry, it must happen in the previous column.

    public int solution(int a, int b){
        // Addition is separated into two operations
        // 1) Sum without carry (XOR)
        // 2) Carry
        // Repeat until there is no carry

        // E.g Add 3 and 5 
        // 3 = 011
        // 5 = 101

        // Operations happen from right to left
        // XOR: 3 ^ 5 = 011 ^ 101 = 110 (it ignores the curry in the right most)
        // Carry: (011 & 101) << 1 = 001 << 1 = 010

        while ( b!=0){

            // Find and execute the carry 
            // AND finds the positions where both bits are 1
            int carry = (a & b) << 1;

            // Add without carry 
            a = a ^ b;
            
            // Add the carry in the next iteration
            b = carry;
        }

        return a;


    }
    
}
