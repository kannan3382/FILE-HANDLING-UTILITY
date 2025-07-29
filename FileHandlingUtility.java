import java.io.*;
import java.util.Scanner;

public class FileHandlerUtility {

    static Scanner scanner = new Scanner(System.in);

    public static void writeFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            System.out.println("Enter content to write (type 'END' to stop):");
            String line;
            while (!(line = scanner.nextLine()).equalsIgnoreCase("END")) {
                writer.write(line + "\n");
            }
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void modifyFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            System.out.print("Enter text to replace: ");
            String oldText = scanner.nextLine();
            System.out.print("Enter new text: ");
            String newText = scanner.nextLine();

            String modifiedContent = content.toString().replace(oldText, newText);
            FileWriter writer = new FileWriter(fileName);
            writer.write(modifiedContent);
            writer.close();

            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String fileName;
        while (true) {
            System.out.println("\nFILE HANDLING MENU");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter file name to write: ");
                    fileName = scanner.nextLine();
                    writeFile(fileName);
                    break;
                case 2:
                    System.out.print("Enter file name to read: ");
                    fileName = scanner.nextLine();
                    readFile(fileName);
                    break;
                case 3:
                    System.out.print("Enter file name to modify: ");
                    fileName = scanner.nextLine();
                    modifyFile(fileName);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
