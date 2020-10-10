package com.thejavacademy.io;

import java.io.*;

public class BuffferedFromFile {
  public static void main(String[] args) {

    try (BufferedReader reader = new BufferedReader(new FileReader("exemplu1in.txt"));
         BufferedWriter writer = new BufferedWriter(new FileWriter("exemplu1out.txt"));
    ) {
      String lineFromFile = null;
      while ((lineFromFile = reader.readLine()) != null) {
        System.out.println(lineFromFile);
        writer.write(lineFromFile + "\n");
      }

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
