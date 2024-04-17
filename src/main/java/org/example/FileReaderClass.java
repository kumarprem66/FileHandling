package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReaderClass {

    public void readFile(String fileName) throws IOException {



            FileReader fr = new FileReader(fileName);
            BufferedReader br=new BufferedReader(fr);


            String line=br.readLine();
            while(line != null){
                System.out.println(line);
                line=br.readLine();
            }
            br.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }





    }



}
