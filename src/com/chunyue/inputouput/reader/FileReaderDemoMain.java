package com.chunyue.inputouput.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReaderDemoMain {
    public static void main(String[] args) {
        // basicFileReader();
        // fileReaderTryWithResource();
    }

    public static void basicFileReader(){
        Scanner scanner = null;
        Map<Integer, String> res = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader("./text/file.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int num = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                res.put(num, description);
            }
            System.out.println(res);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            // scanner.close will close the FileReader as well since it is an instance of Closable
            if (scanner != null) scanner.close();
        }
    }

    // simplify the above code using try with resources
    public static void fileReaderTryWithResource(){
        Map<Integer, String> res = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader("./text/file.txt"))){
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int num = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                res.put(num, description);
            }
            System.out.println(res);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
