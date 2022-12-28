package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {
  public static Customer logIn(String username, String password)throws LoginException{
//call getCustomer method from our DataSource class
//the method is static we dont neeed to instantiate a data source object to access the method
  Customer customer = DataSource.getCustomer(username); // added to a customer object
  //before checking this process is better to do an error check, to meake sure we actually 
  //recieve  data from the databases
  if (customer == null) {
    throw new LoginException("User name not found");
  }
// ckecking Password ///
// comparing objects it's safer to use equals method as it compares the value of the object
// equals equals operator compares the memory locations
  if (password.equals(customer.getPassword())){
    // set a flag to autenticated(field created in Customer class) to true 
    customer.setAuthenticated(true);//if match change to true and return customer
    return customer;
  }else{
    throw new LoginException("Incorrect Password");
  }

}

  public static void logOut(Customer customer){
// to unauthenticate we can do so  by setting  that authenticated flag to false
customer.setAuthenticated(false);
  }
}
