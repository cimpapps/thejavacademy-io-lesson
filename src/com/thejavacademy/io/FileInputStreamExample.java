package com.thejavacademy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {

  public static void main(String[] args) {
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    try {
      fileInputStream = new FileInputStream("exemplu1in.txt");
      fileOutputStream = new FileOutputStream("exemplu1out.txt");
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
    }finally{
      if (fileInputStream != null) {
        try {
          fileInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fileOutputStream != null) {
        try {
          fileOutputStream.close();
        }catch (IOException e){
          e.printStackTrace();
        }
      }
    }
  }
}
