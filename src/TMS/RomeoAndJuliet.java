package TMS;

import java.io.*;
import java.util.Scanner;

public class RomeoAndJuliet {
    public static void main(String[] args) {
        String longestWord = "";
        String shortestWord = null;
        try {
            Scanner scanner = new Scanner(new File("C:\\romeo-and-juliet.txt"));
            scanner.useDelimiter("[^a-zA-Z]+");

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;

                }
                if (shortestWord == null || (word.length() < shortestWord.length() && word.length() > 1)) {
                    shortestWord = word;
                }
            }
            scanner.close();
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
