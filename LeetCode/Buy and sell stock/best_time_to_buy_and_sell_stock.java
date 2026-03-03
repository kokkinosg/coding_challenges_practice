public class best_time_to_buy_and_sell_stock {

    public int brute_solution(int[] prices){

        int profit = 0;

        for (int i = 0; i < prices.length; i++){
            // Loop through prices but starting from the ith index forward 
            // Only execute inner loop as long as i is not hte last element
            if (i != prices.length -1){
                for (int j =i+1; j < prices.length; j++){

                    int curr_profit = prices[j]-prices[i];
                    // Update profit when current profit is larger 
                    if(curr_profit>profit){
                        profit = curr_profit;
                    }
                }
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        
        int[] prices = {7,6,4,3,1};
        best_time_to_buy_and_sell_stock my_class = new best_time_to_buy_and_sell_stock();
        System.out.println(my_class.brute_solution(prices));
    }

}
