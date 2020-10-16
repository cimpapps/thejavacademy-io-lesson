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



  public List<Transaction> readAllTransactions() throws IOException {
    List<Transaction> transactions = new ArrayList<>();
    String transactionString = null;
    List<String> linesInError = new ArrayList<>();
    while ((transactionString = bufferedReader.readLine()) != null) {
      try {

        transactions.add(mapTransactionLineToObject(transactionString));
      } catch (Exception e) {
        linesInError.add(transactionString);
      }
      saveLinesInErrorToDisk(linesInError);
    }
    return transactions;
  }

  private void saveLinesInErrorToDisk(List<String> linesInError) {
    //todo
  }

  private Transaction mapTransactionLineToObject(String transactionString) {
    Transaction transaction = null;
    try {
      String[] transactionElements = transactionString.split(";");
      transaction =Transaction.newBuilder()
              .id(Long.parseLong(transactionElements[0]))
              .fromIban(transactionElements[1])
              .toIban(transactionElements[2])
              .amount(Double.parseDouble(transactionElements[3].replace(",", ".")))
              .fromBank(transactionElements[4])
              .toBank(transactionElements[5])
              .build();
    } catch (NumberFormatException e) {
      e.printStackTrace();

    }
    return transaction;
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
