package com.thejavacademy.io;

import java.io.*;

public class FileInputOutExample {
  public static void main(String[] args) throws IOException {
    InputStream fileis = null;
    OutputStream fileout = null;
    try {
      fileis = new FileInputStream("resources/lectie.txt");
      fileout = new FileOutputStream("resources/outputbytes.txt");
      int c;
      while ((c = fileis.read()) != -1) {
        System.out.println(c);
        fileout.write(c);
      }

    } finally {
      if (fileis != null) {
        fileis.close();
      }
      if (fileout != null) {
        fileout.close();
      }
    }
  }
}
