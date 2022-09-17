package com.chunyue.inputouput.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BufferedReaderDemoMain {
    public static void main(String[] args) {
        System.out.println("Buffered reader can be more efficient than file reader");
        System.out.println("The default size of the buffer is 8KB");
        // basicBufferReader();
        // usingStringSplit();
        noScannerBufferedReader();
    }

    public static void basicBufferReader(){
        Scanner scanner = null;
        Map<Integer, String> res = new HashMap<>();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("./text/file.txt")));
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
            if (scanner != null) scanner.close();
        }
    }

    public static void usingStringSplit(){
        Scanner scanner = null;
        Map<Integer, String> res = new HashMap<>();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("./text/file.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int num = Integer.parseInt(data[0]);
                String description = data[1];
                res.put(num, description);
            }
            System.out.println(res);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (scanner != null) scanner.close();
        }
    }

    public static void noScannerBufferedReader(){
        Map<Integer, String> res = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./text/file.txt"))){
            String input;
            while ((input = br.readLine()) != null){
                String[] data = input.split(",");
                int num = Integer.parseInt(data[0]);
                String description = data[1];
                res.put(num, description);
            }
            System.out.println(res);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
