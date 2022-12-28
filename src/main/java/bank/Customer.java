package bank;

public class Customer {

  private int id;
  private String name;
  private String username;
  private String password;
  private int account_Id;
  // create field to Authenticate LogIn It was not create at the begining
  private boolean authenticated; //genrate gettters and setters 


  public Customer(int id, String name, String password, String username, int account_Id){
    setId(id);
    setName(name);
    setUsername(username);
    setPassword(password);
    setAccount_Id(account_Id);
    setAuthenticated(false);


  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public int getAccount_Id() {
    return account_Id;
  }
  public void setAccount_Id(int account_Id) {
    this.account_Id = account_Id;
  }
  
  public boolean isAuthenticated() {
    return authenticated;
  }

  public void setAuthenticated(boolean authenticated){
    this.authenticated = authenticated;
  }

  
}
