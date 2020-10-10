package com.thejavacademy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class ConsoleStreams {
  public static void main(String[] args) throws IOException {

    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      String lineFromConsole = bufferedReader.readLine();
      System.out.println(lineFromConsole);
    }
  }
}
