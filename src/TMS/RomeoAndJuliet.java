package TMS;

import java.io.*;
import java.util.Scanner;

public class RomeoAndJuliet {
    public static void main(String[] args) {
        String longestWord = null;
        String shortestWord = null;
        try {
            Scanner fileScanner = new Scanner(new File("C:\\romeo-and-juliet.txt"));
            fileScanner.useDelimiter("[^a-zA-Z]+");

            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                if (longestWord == null || word.length() > longestWord.length() ) {
                    longestWord = word;

                }
                if (shortestWord == null || (word.length() < shortestWord.length() && word.length() >= 2)) {
                    shortestWord = word;
                }
            }
            fileScanner.close();
            FileWriter writer = new FileWriter("found words.txt");
            writer.write("Самое длинное слово: " + longestWord + "\n");
            writer.write("Самое короткое слово: " + shortestWord + "\n");
            writer.close();


        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
