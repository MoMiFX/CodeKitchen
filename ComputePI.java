/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computepi;

/**
 *
 * @author MMO
 */
public class ComputePI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long Starttime, Stoptime;
        Starttime = System.currentTimeMillis();
        //Variante 1
        double sum = 0.0;
        final long maxDenominator = 1000000000;   //  1 000 000 000
        for (int denominator = 1; denominator <= maxDenominator; denominator += 2) {
            // denominator = 1, 3, 5, 7, ..., maxDenominator
            if (denominator % 4 == 1) {
                sum += 1.0 / denominator;

            } else if (denominator % 4 == 3) {
                sum -= 1.0 / denominator;
            } 
        }
        Stoptime = System.currentTimeMillis();
        System.out.println("Variante 1 - constant maxDenominator");
        System.out.println("PI with " + maxDenominator + " iterations gives:" + (4.0 * sum));
        System.out.println("System-internal PI gives:" + Math.PI);
        System.out.println("Difference:" + (4 * sum - Math.PI));
        System.out.println("Compute Time[ms]:" + (Stoptime - Starttime));

        //Variante 2      
        Starttime = System.currentTimeMillis();
        final long maxTerm = 1000000000;   //  1 000 000 000
        double sum2 = 0.0;
        for (int term = 1; term <= maxTerm; term++) {
            if (term % 2 == 1) {//aa to term
                sum2 += 1.0 / (term * 2 - 1);
            } else {
                sum2 -= 1.0 / (term * 2 - 1);
            }
        }
        Stoptime = System.currentTimeMillis();
        System.out.println("Variante 2 - constant maxTerm");
        System.out.println("PI with " + maxTerm + " term limit gives:" + (4.0 * sum2));
        System.out.println("System-internal PI gives:" + Math.PI);
        System.out.println("Difference:" + (4 * sum2 - Math.PI));
        System.out.println("Compute Time[ms]:" + (Stoptime - Starttime));
        ComputePI d;
    }

    public ComputePI() {
    }
}
