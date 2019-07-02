package models;

public class Account {
  private String id;
  private String name;
  private String password;
  private String emailAddress;
  private String role;

  public Account(String id, String name, String password, String emailAddress, String role) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.emailAddress = emailAddress;
    this.role = role;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmailAdress() {
    return emailAddress;
  }

  public void setEmailAdress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getRol() {
    return role;
  }

  public void setRol(String role) {
    this.role = role;
  }
}