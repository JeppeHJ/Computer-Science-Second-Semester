package opgave31;

import java.util.Arrays;

public class prefixAverage {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(prefixAverageMethod2(array)));
    }

    public static double[] prefixAverageMethod(int[] inputTal) {
        // initialize sum and count to 0
        int sum = 0;
        int count = 0;
        // create a new double array of the same length as the input array
        double[] newArray = new double[inputTal.length];
        // loop through the input array
        for (int i = 0; i < inputTal.length; i++) {
            // add the current element to the sum
            sum += inputTal[i];
            // increment the count
            count++;
            // calculate the average so far and store it in the new array
            newArray[i] = sum * 1.0 / count;
        }
        // return the new array of averages
        return newArray;
    }

    public static double[] prefixAverageMethod2(int[] inputTal) {
        // initialize sum to 0
        int sum = 0;
        // create a new double array of the same length as the input array
        double[] newArray = new double[inputTal.length];
        // loop through the input array
        for (int i = 0; i < inputTal.length; i++) {
            // add the current element to the sum
            sum += inputTal[i];
            // calculate the average so far and store it in the new array
            newArray[i] = sum * 1.0 / (i + 1);
        }
        // return the new array of averages
        return newArray;
    }
}