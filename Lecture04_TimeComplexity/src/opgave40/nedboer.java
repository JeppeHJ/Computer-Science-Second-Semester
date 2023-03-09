package opgave40;

public class nedboer {
    public static void main(String[] args) {

        System.out.println(ensNedboer());
    }

    private static int[] nedboerPrUge = {20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
            15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
            0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
            19, 21, 32, 24, 13};

    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */

    public static int bedsteTreFerieUger() {
        // initialize variables
        int nedboerTreUger = Integer.MAX_VALUE;
        int ugeStartIndex = 0;
        // loop through the array of precipitation data
        for (int i = 0; i < nedboerPrUge.length - 2; i++) {
            // calculate the total precipitation for the next three weeks
            int tempNedboer = nedboerPrUge[i] + nedboerPrUge[i + 1] + nedboerPrUge[i + 2];
            // if the total precipitation is less than the current minimum, update the minimum and index
            if (tempNedboer < nedboerTreUger) {
                nedboerTreUger = tempNedboer;
                ugeStartIndex = i;
            }
        }
        // return the index of the week to start the vacation
        return ugeStartIndex;
    }

    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */

    public static int bedsteFerieUgeStart(int antal) {
        // initialize variables
        int nedboerTreUger = Integer.MAX_VALUE;
        int ugeStartIndex = 0;
        // loop through the array of precipitation (nedbør) data
        for (int i = 0; i <= nedboerPrUge.length - antal; i++) {
            // calculate the total precipitation for the next antal weeks
            int temp = 0;
            for (int j = i; j < i + antal; j++) {
                temp += nedboerPrUge[j];
            }
            // if the total precipitation is less than the current minimum, update the minimum and index
            if (temp < nedboerTreUger) {
                nedboerTreUger = temp;
                ugeStartIndex = i;
            }
        }
        // return the index of the week to start the vacation
        return ugeStartIndex;
    }




    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public static int ensNedboer() {
        int currentStreak = 0; // variable to keep track of the longest streak of equal rainfall
        int ugeStartIndex = 0; // variable to store the starting index of the longest streak
        for (int i = 0; i < nedboerPrUge.length - currentStreak; i++) {
            int count = 0;
            while (nedboerPrUge[i] == nedboerPrUge[i + 1]) { // find consecutive weeks with equal rainfall
                count++;
                if (count > currentStreak) { // update the longest streak if the current streak is longer
                    ugeStartIndex = i;
                    currentStreak = count;
                }
                i++;
            }
        }
// return the starting index of the longest streak minus the length of the streak
        if (currentStreak == 0) {
            return -1;
        }
        return ugeStartIndex - currentStreak;
    }

    //TODO The time complexity of the following three methods are:

    //bedsteTreFerieUger(): The time complexity of this method is O(n), where n is the length of the nedboerPrUge array.
    // The method uses a single loop that iterates over the entire nedboerPrUge array and for each iteration, the code inside the loop
    // performs a constant amount of work. Hence, the time complexity is linear with respect to the size of the nedboerPrUge array.

    //bedsteFerieUgeStart(int antal): The time complexity of this method is O(n * m), where n is the length of the nedboerPrUge array,
    // and m is the value of the antal parameter. The method uses two nested loops, where the outer loop iterates over the entire
    // nedboerPrUge array, and the inner loop iterates over the antal number of elements. Hence, the time complexity is proportional
    // to the product of the length of the nedboerPrUge array and the antal parameter.

    //ensNedboer(): The time complexity of this method is O(n), where n is the length of the nedboerPrUge array. The method uses a
    // single loop that iterates over the entire nedboerPrUge array and for each iteration, the code inside the loop performs a
    // constant amount of work. Hence, the time complexity is linear with respect to the size of the nedboerPrUge array.
}
