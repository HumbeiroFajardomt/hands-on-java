package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
  
  public static Connection connect(){
    String db_file = "jdbc:sqlite:resources/bank.db";
    //Declaration of connection object
    Connection connection = null;
    //it is neccesary handle the exception for getConnection 
    
    try{
      connection = DriverManager.getConnection(db_file);
      System.out.println("we're Connected");//Message to check Connection 
    }catch(SQLException e){
      e.printStackTrace();//git a log of the code execution path
    }

    return connection;//Test our connection by calling this method from the main method
    
  }
    
  public static void main(String[] args){
    connect();
  }

}
