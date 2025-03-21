import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) {
        String writtenFile = "WriteAFileExample.txt";

        try {
            FileWriter filewrite = new FileWriter(writtenFile);
            BufferedWriter writer = new BufferedWriter(filewrite);

            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is a test file.");
            writer.newLine();
            writer.write("Written on: " + java.time.LocalDate.now());

            writer.close(); 
            System.out.println("Content written to " + writtenFile);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}