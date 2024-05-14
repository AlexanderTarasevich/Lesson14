package TaskStar;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentValidator {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter validWriter = null;
        BufferedWriter invalidWriter = null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите путь к файлу с номерами документов:");
            String inputFilePath = scanner.nextLine();

            reader = new BufferedReader(new FileReader(inputFilePath));
            validWriter = new BufferedWriter(new FileWriter("valid_docs.txt"));
            invalidWriter = new BufferedWriter(new FileWriter("invalid_docs.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidDocumentNumber(line)) {
                    validWriter.write(line);
                    validWriter.newLine();
                } else {
                    invalidWriter.write(line + " - Невалидный номер документа");
                    invalidWriter.newLine();
                }
            }

            System.out.println("Обработка завершена. Проверьте файлы 'valid_docs.txt' и 'invalid_docs.txt'.");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (reader != null) reader.close();
                if (validWriter != null) validWriter.close();
                if (invalidWriter != null) invalidWriter.close();
                if (scanner != null) scanner.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    private static boolean isValidDocumentNumber(String docNumber) {
        String regex = "^(docnum[a-zA-Z0-9]{9}|contract[a-zA-Z0-9]{7})$" ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(docNumber);

        return matcher.matches();
    }
}


