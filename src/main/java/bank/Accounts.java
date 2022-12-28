package bank;

import bank.exceptions.AmountException;

public class Accounts {
  
  private int id;
  private String type;
  private double balance;

  public Accounts(int id, String type, double balance){
    
    setId(id);
    setType(type);
    setBalance(balance);

  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public double getBalance() {
    return balance;
  }
  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountException{
    // a bit of error checking to make sure the input is valid eg. amoung is not zero or -number
    // there is a built-in java exceptions or you can create your own custom exception
    if (amount < 1){
      throw new AmountException("The minimun deposit us 1.00");

    }else{
      double newBalance = balance + amount;
      setBalance(newBalance);
    }
  }
  public void withdraw(double amount){

  }

  
}
