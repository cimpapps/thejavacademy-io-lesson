package com.thejavacademy.io;

import java.io.Closeable;

public class MasinaZburatoare implements Closeable {
  public static void main(String[] args) {
    try (MasinaZburatoare masinaZburatoare = new MasinaZburatoare()) {
      System.out.println(masinaZburatoare);
    }
  }

  @Override
  public void close() {
    System.out.println("S-au inchis zborurile");
  }
}
