package com.thejavacademy.io;

import java.io.*;

public class ObjectInputOutputExample {

  public static void main(String[] args) {
    Transaction.Builder builder =
        Transaction.newBuilder()
            .id(System.currentTimeMillis())
            .fromIban("INGB4932432")
            .toIban("INGB5432432")
            .fromBank("ING")
            .toBank("RAIF")
            .amount(4324.3);

    Transaction transaction1 = builder.build();
    Transaction transaction2 = builder.id(System.currentTimeMillis()).toIban("INGB#$#@4").build();
    System.out.println(transaction1);
    System.out.println(transaction2);

    try (ObjectOutputStream objectOutputStream =
            new ObjectOutputStream(new FileOutputStream("transactionout.obj"));
        ObjectInputStream objectInputStream =
            new ObjectInputStream(new FileInputStream("transactionout.obj"))) {
      objectOutputStream.writeObject(transaction1);
      Transaction transactionFromFile = (Transaction) objectInputStream.readObject();
      System.out.println(transactionFromFile);

    } catch (IOException | ClassNotFoundException ex) {
      ex.printStackTrace();
    }
  }
}
