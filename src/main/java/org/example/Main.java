package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        FileReaderClass fileReaderClass = new FileReaderClass();
        FileWriterClass fileWriterClass = new FileWriterClass();
        FileAnalyseClass fileAnalyseClass = new FileAnalyseClass();



          while (running) {
              try {
                  System.out.println("Welcome to File Handling and Analysis System!");
                  System.out.println("Choose an operation:");
                  System.out.println("1. Read a file");
                  System.out.println("2. Write to a file");
                  System.out.println("3. Analyze file content");
                  System.out.println("4. Exit");

                  int choice = scanner.nextInt();
                  scanner.nextLine(); // Consume newline character


                  boolean running2 = true;
                  while (running2){
                      try {
                          switch (choice) {
                              case 1:
                                  System.out.println("Enter the file path to read:");
                                  String filePath = scanner.nextLine();

                                  fileReaderClass.readFile(filePath);
                                  running2 = false;
                                  break;
                              case 2:
                                  System.out.println("Enter the file path to write:");
                                  String writeFilePath = scanner.nextLine();
                                  createFile(writeFilePath);
                                  System.out.println("Enter the content to write:");
                                  String content = scanner.nextLine();
                                  fileWriterClass.writeToFile(writeFilePath, content);
                                  running2 = false;
                                  break;
                              case 3:
                                  System.out.println("Enter the file path to analyze:");
                                  String analyzeFilePath = scanner.nextLine();
                                  Map<String, Integer> analysisResult = fileAnalyseClass.analyzeContent(analyzeFilePath);
                                  System.out.println("Analysis Result:");
                                  System.out.println("Total number of words: " + analysisResult.size());
                                  System.out.println("Number of unique words: " + analysisResult.keySet().size());
                                  System.out.println("Word frequency:");
                                  for (Map.Entry<String, Integer> entry : analysisResult.entrySet()) {
                                      System.out.println(entry.getKey() + ": " + entry.getValue());
                                  }
                                  running2 = false;
                                  break;
                              case 4:
                                  System.out.println("Exited..");
                                  running = false;
                                  running2 = false;
                                  break;

                              default:
                                  System.out.println("Invalid choice. Please choose a valid operation.");

                              running2 = false;
                          }
                      } catch (IOException e) {
                          System.out.println("This file does not exist..");
                      }
              }

              } catch (InputMismatchException e){
                  System.out.println("Please enter valid input..");
                  scanner.nextLine();
              }


          }



    }


    public static void createFile(String fileName) throws IOException {
        fileName = fileName+".txt";
        File f=new File(fileName);

        if(!f.exists()){

            f.createNewFile(); // it will create file in the current location
        }

    }

}