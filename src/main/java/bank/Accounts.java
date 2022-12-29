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
      //Call the deposit as well to update the db
      DataSource.updateAccountBalance(id, newBalance);
    }
  }
  public void withdraw(double amount) throws AmountException{
    // cheking values 
    if (amount < 0){
      throw new AmountException("The withdrawal amount must be greater than 0");
      
    }else if(amount > getBalance()){
      throw new AmountException("You do not have sufficient funds for this withdrawal");

    }else{
      //Calculate new balance
      double newBalance = balance - amount;
      //Change final Balance
      setBalance(newBalance);
      //Update account balance 
      DataSource.updateAccountBalance(id, newBalance);
    }
  }

  
}
