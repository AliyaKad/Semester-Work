package TestFile;

import java.io.*;
import java.util.Random;

public class WriteToFile {
public void writeNumbers(String fileName) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            int n = 100 + random.nextInt(9901);
            for (int j = 0; j < n; j++) {
                writer.write(random.nextInt(10000) + " ");
            }
            writer.newLine();
        }

        System.out.println("Numbers have been written to " + fileName);
    } catch (IOException e) {
        System.err.println("Error writing to file: " + e.getMessage());
    }
}

    public static void main(String[] args) {
        WriteToFile writer = new WriteToFile();
        writer.writeNumbers("TestFile.txt");
    }
}

