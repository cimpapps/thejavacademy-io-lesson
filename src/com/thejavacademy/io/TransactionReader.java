package com.thejavacademy.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionReader implements Closeable {
  private BufferedReader bufferedReader;

  public TransactionReader(String file) {
    try {
      bufferedReader = new BufferedReader(new FileReader(file));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private Transaction readTransaction() {
    try {
      String transactionString = bufferedReader.readLine();
      if (transactionString == null) {
        return null;
      }
      return mapTransactionLineToObject(transactionString);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Transaction> readAllTransactions() {
    List<Transaction> transactions = new ArrayList<>();
    Transaction t = null;
    while ((t = this.readTransaction()) != null) {
      transactions.add(t);
    }
    return transactions;
  }

  private Transaction mapTransactionLineToObject(String transactionString) throws IOException {
    String[] transactionElements = transactionString.split(";");
    return Transaction.newBuilder()
            .id(Long.parseLong(transactionElements[0]))
            .fromIban(transactionElements[1])
            .toIban(transactionElements[2])
            .amount(Double.parseDouble(transactionElements[3].replace(",", ".")))
            .fromBank(transactionElements[4])
            .toBank(transactionElements[5])
            .build();
  }

  @Override
  public void close() {
    if (bufferedReader != null) {
      try {
        bufferedReader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
