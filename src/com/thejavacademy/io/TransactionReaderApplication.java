package com.thejavacademy.io;

import java.util.List;

public class TransactionReaderApplication {

  public static void main(String[] args) {
    try (TransactionReader txReader = new TransactionReader("transactions.csv")) {
      List<Transaction> transactions = txReader.readAllTransactions();
      for (Transaction t : transactions) {
        System.out.println(t);
      }
    }
  }
}
