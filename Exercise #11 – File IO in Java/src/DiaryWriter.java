import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiaryWriter {
    public static void main(String[] args) {
        String diaryFile = "Diary.txt"; 
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter filewrite = new FileWriter(diaryFile);
            BufferedWriter writer = new BufferedWriter(filewrite);

            System.out.println("Start writing your diary (type 'END' or 'end' to finish):");
            String input;
            while (true) {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("END")) {
                    break; 
                }
                writer.write(input);
                writer.newLine(); 
            }

            writer.close(); 
            scanner.close();
            System.out.println("Diary saved to " + diaryFile);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the diary: " + e.getMessage());
        }
    }
}