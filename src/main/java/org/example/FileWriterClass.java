package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterClass {

    public void writeToFile(String filePath, String content) throws IOException{

            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            System.out.println("Content has been written to the file successfully.");
//        } catch (IOException e) {
//            System.err.println("Error writing to file: " + e.getMessage());
//        }
    }
}
