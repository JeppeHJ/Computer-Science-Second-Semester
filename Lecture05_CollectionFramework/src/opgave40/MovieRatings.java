package opgave40;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        // Create a new Map to store the ratings for each movie
        Map<String, Rating> ratings = new HashMap<>();

        try {
            // Read the input file
            Scanner scanner = new Scanner(new File("ratings.txt"));

            // Read the total number of ratings
            int numRatings = scanner.nextInt();

            // Read the pairs of movie names and ratings and add them to the map
            for (int i = 0; i < numRatings; i++) {
                String movieName = scanner.next();
                int ratingValue = scanner.nextInt();

                Rating rating = ratings.getOrDefault(movieName, new Rating());
                rating.addRating(ratingValue);
                ratings.put(movieName, rating);
            }

            // Print the average rating for each movie
            for (Map.Entry<String, Rating> entry : ratings.entrySet()) {
                String movieName = entry.getKey();
                Rating rating = entry.getValue();
                System.out.printf("%s: %d ratings, average %.1f\n", movieName, rating.getNumRatings(), rating.getAverage());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    // A simple class to store the ratings for a movie
    private static class Rating {
        private int totalRating;
        private int numRatings;

        public void addRating(int rating) {
            totalRating += rating;
            numRatings++;
        }

        public double getAverage() {
            return (double) totalRating / numRatings;
        }

        public int getNumRatings() {
            return numRatings;
        }
    }

    //TODO The program first creates a Map called ratings to store the movie ratings. The keys in the map are the movie names,
    // and the values are instances of the Rating class that stores the total rating and the number of ratings for each movie.

    // The program then reads the input file using a Scanner. The first line of the file specifies the total number of ratings,
    // which is read using scanner.nextInt(). The program then reads each pair of lines containing the movie name and rating
    // and updates the corresponding Rating object in the map.

    //Finally, the program iterates over the entries in the ratings map and prints the average rating for each movie
    // along with the number of ratings. The output is formatted using System.out.printf() to display the movie name,
    // number of ratings, and average rating with one decimal place.
}