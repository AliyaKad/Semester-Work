package TestFile2;

import TestFile.WriteToFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteToFile2 {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TestFile2.txt"))) {
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                int randomNumber = random.nextInt(1000000) + 1;
                writer.write(Integer.toString(randomNumber));
                writer.newLine();
            }
            System.out.println("Файл TestFile2.txt успешно создан");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

}
