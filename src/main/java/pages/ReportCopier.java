package pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ReportCopier {
    public static void copyReport() {
        File source = new File("D:\\Demo\\target\\cucumber-reports\\cucumber.html");
        File destination = new File("D:\\Demo\\src\\test\\resources\\cucumber-reports");

        try {
            // Create the destination directory if it doesn't exist
            if (!destination.exists()) {
                destination.mkdirs();
            }

            // Copy the file to the destination directory
            Path sourceFilePath = source.toPath();
            Path destinationFilePath = new File(destination, source.getName()).toPath();
            Files.copy(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Report copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
