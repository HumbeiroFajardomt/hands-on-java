package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;


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
    
  }
}



