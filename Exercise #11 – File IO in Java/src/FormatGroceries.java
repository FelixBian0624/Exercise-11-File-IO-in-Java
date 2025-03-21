import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FormatGroceries {
    public static void main(String[] args) {
        String inputPath = "C:\\Downloads\\Groceries.txt";
        String outputPath = "FormattedGroceries.txt";

        try {
            FileReader fileread = new FileReader(inputPath);
            BufferedReader reader = new BufferedReader(fileread);
            FileWriter filewrite = new FileWriter(outputPath);
            BufferedWriter writer = new BufferedWriter(filewrite);

            // Write header
            writer.write("***********************************************************");
            writer.newLine();
            writer.write("ID   Item         Quantity(KG)   Price(€)");
            writer.newLine();
            writer.write("********************************************************");
            writer.newLine();

            String line;
            double totalPrice = 0.0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String item = parts[1];
                    String quantity = parts[2].replace("KG", ""); 
                    double price = Double.parseDouble(parts[3]);

                    String formattedLine = String.format("%-4s %-12s %-14s %.1f", id, item, quantity, price);
                    writer.write(formattedLine);
                    writer.newLine();

                    totalPrice += price; 
                }
            }

    
            writer.write("***********************************************************");
            writer.newLine();
            writer.write("The grocery shopping total is: €" + String.format("%.1f", totalPrice));
            writer.newLine();
            writer.write("***********************************************************");

            reader.close();
            writer.close();
            System.out.println("Formatted data saved to " + outputPath);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}