package com.thejavacademy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExampleTryWithResources {

  public static void main(String[] args) {

    try(FileInputStream fileInputStream = new FileInputStream("exemplu1in.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("exemplu1out.txt")) {
      int myByte = fileInputStream.read();
      while (myByte != -1) {
        System.out.println(myByte);
        fileOutputStream.write(myByte);
        myByte = fileInputStream.read();
        // 65 115 116 97
      }
    } catch (FileNotFoundException e) {
      System.out.println("Fisier negasit");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("IO exception");
      e.printStackTrace();
    }
  }
}
