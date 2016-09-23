import java.io.*;
import java.util.*;
/**
 * Problems : https://www.hackerrank.com/contests/juniper-hackathon/challenges/metals
 * Status : Success pass all test case
 */
public class Metals {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Storing input data
        int cost_per_cut = sc.nextInt();
        int metal_price = sc.nextInt();
        int L = sc.nextInt();
        
        int[] rods = new int[L];
        for (int i = 0; i < L; i++) {
            rods[i] = sc.nextInt();
        }
        // sort the rods array in ascending order.
        Arrays.sort(rods);
        
        int max_rods_length = rods[L-1];
        
        int total_cost = 0;
        
        for (int i = 1; i < max_rods_length; i++) {
            int num_of_cut = 0;
            int current_cost = 0;
            for (int rod : rods) {
                if (rod%i == 0) {
                    num_of_cut = rod/i - 1;
                } else {
                    num_of_cut = rod / i;
                }
                // i represents the length of each rod
                int num_of_rod = rod / i;
                
                int cost_each_rod = metal_price*i*num_of_rod - cost_per_cut * num_of_cut;
                if (cost_each_rod > 0)
                    current_cost += cost_each_rod;
            }
            if (total_cost < current_cost)
                total_cost = current_cost;
        }
        System.out.println(total_cost);
    }
}
