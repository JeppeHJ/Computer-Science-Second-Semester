package opgave5;

public class belgiumFlag {
    public static void main(String[] args) {
        char[] arr = {'G', 'R', 'S', 'G', 'G', 'R', 'S', 'R', 'G', 'G', 'R', 'S', 'G'};
        belgisk_flag(arr);

    }

    public static void belgisk_flag(char[] belgisk_flag) {
        int red = belgisk_flag.length - 1;  // initialize index for last red flag
        int green = 0;  // initialize index for first green flag
        for (int i = 0; i <= red; i++) {
            if (belgisk_flag[i] == 'R') {
                // if the current flag is red, swap it with the last red flag
                char temp = belgisk_flag[i];
                belgisk_flag[i] = belgisk_flag[red];
                belgisk_flag[red] = temp;
                red--;  // move the red index one step back
                i--;  // decrement i to check the current flag again
            } else if (belgisk_flag[i] == 'G') {
                // if the current flag is green, swap it with the first green flag
                char temp = belgisk_flag[i];
                belgisk_flag[i] = belgisk_flag[green];
                belgisk_flag[green] = temp;
                green++;  // move the green index one step forward
            }
            // if the current flag is black, do nothing and continue with the next flag
        }

        System.out.println(belgisk_flag);
    }
}