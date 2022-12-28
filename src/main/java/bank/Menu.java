package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.exceptions.AmountException;


public class Menu {
  private Scanner scanner;


  public static void main(String[] args) {
    System.out.println("Welcome to Globe Bank Internatinall");
    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);

    Customer customer = menu.authenticateUser();

    if (customer != null) {
      Accounts account = DataSource.getAccounts(customer.getAccount_Id());
      menu.showMenu(customer, account);
      
    }


    menu.scanner.close();
  }

  private Customer authenticateUser(){
    System.out.println("Please enter your Username: ");
    String username = scanner.next();

    System.out.println("Please enter your Password: ");
    String password = scanner.next();

    // To validate this credentials

    Customer customer = null;
    //Authentication with logIn
    try {
      customer = Authenticator.logIn(username, password);
    } catch (LoginException e) {
      // TODO Auto-generated catch block
      System.out.println("There was an error: " + e.getMessage()); 
    }
    return customer;
  }

  private void showMenu(Customer customer, Accounts account){
    //Menu of options for the User within  the showMenu method of the menu class

    int selection = 0;
    while (selection != 4 && customer.isAuthenticated()) {
      System.out.println("=================");
      System.out.println("Please select one of the following Option: ");
      System.out.println("1: Deposit");
      System.out.println("2: Withdraw");
      System.out.println("3: Check Balance");
      System.out.println("4: Exit");
      System.out.println("=================");

      selection = scanner.nextInt();
      double amount = 0;

      switch (selection) {
        case 1:
        System.out.println("How much would you like to deposit?");
          amount = scanner.nextDouble();
          try {
            account.deposit(amount);
          } catch (AmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again.");
            // TODO: handle exception
          }
          
          break;

          case 2:
          System.out.println("How much would you like to withdraw?");
          amount = scanner.nextDouble();
          account.withdraw(amount);

          break;
        
          case 3:
          System.out.println("Current Balance: " + account.getBalance() );
          break;
          case 4:
          Authenticator.logOut(customer);
          System.out.println("Thanks for banking at Globe Bank International!");
          break;

          default: 
          System.out.println("Invalid Option. Please try Again.");
          break;
      }
    }

  }
}



