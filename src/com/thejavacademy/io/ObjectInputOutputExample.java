package com.thejavacademy.io;

public class ObjectInputOutputExample {

  public static void main(String[] args) {
      Transaction.Builder builder = Transaction.newBuilder()
              .id(System.currentTimeMillis())
              .fromIban("INGB4932432")
              .toIban("INGB5432432")
              .amount(4324.3);

      Transaction transaction1 = builder
              .build();
    Transaction transaction2 = builder.id(System.currentTimeMillis()).toIban("INGB#$#@4").build();
    System.out.println(transaction1);
    System.out.println(transaction2);
  }
}
