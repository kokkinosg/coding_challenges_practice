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

    // The theoory is that the biggest price is offered by the minimum and maximum prices
    // I need to find the minimum price and max profit in a single pass

    public int optimised_solution(int[] prices){

        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;


        for (int price:prices){
            // Identify the min price seen so far
            if (price<min_price){
                min_price = price;
            }
            // Calculate profit based on current minimum price
            int current_profit = price - min_price;

            // Update max profit
            if (current_profit>max_profit){
                max_profit = current_profit;
            }
        }

        return max_profit;
    }

    public static void main(String[] args) {
        
        int[] prices = {7,1,6,4,3,1};
        best_time_to_buy_and_sell_stock my_class = new best_time_to_buy_and_sell_stock();
        System.out.println(my_class.brute_solution(prices));
        System.out.println(my_class.optimised_solution(prices));
    }

}
