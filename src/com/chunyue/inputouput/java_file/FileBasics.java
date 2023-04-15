/* 
 * Code is adapted from https://tobebetterjavaer.com/io/file-path.html#file-%E5%B8%B8%E7%94%A8%E6%96%B9%E6%B3%95 
 * Note that this will not work for another computer as the dir path and file name need to be changes
*/

package com.chunyue.inputouput.java_file;

import java.io.File;
import java.io.IOException;

public class FileBasics {

    private static String dirPath = "/Users/chunyuema/Desktop/dev/pro-java/core-java/src/com/chunyue/inputouput/java_file/test_dir";
    private static String fileName = "test_file.txt";
    private static String dirPathLevelUp = "/Users/chunyuema/Desktop/dev/pro-java/core-java/src/com/chunyue/inputouput/java_file/";

    public static void main(String[] args) {
        makeDirectory(dirPath);
        createFile(dirPath, fileName);
        recursiveDirIteration(dirPathLevelUp, "");
    }

    public static void createFile(String dirPath, String fileName) {
        System.out.println("Creating a file");
        File file1 = new File(dirPath, fileName);
        System.out.println(file1.exists());// false because before creating the file it does not exist yet
        try {
            if (file1.createNewFile()) {
                System.out.println("Successfully created file with name：" + file1.getName() + " at location "
                        + file1.getAbsolutePath());
            } else {
                System.out.println("Failed to create file：" + file1.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file1.exists());
    }

    public static void recursiveDirIteration(String dirPath, String indentation) {
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(indentation + "File: " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println(indentation + "Dir: " + f.getAbsolutePath());
                    recursiveDirIteration(f.getAbsolutePath(), indentation + " ");
                    ;
                }
            }
        }
    }

    public static void makeDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.mkdirs()) {
            System.out.println("Successfully created directory: " + dir.getAbsolutePath());
        } else {
            System.out.println("Failed to create directory");
        }
    }
}
