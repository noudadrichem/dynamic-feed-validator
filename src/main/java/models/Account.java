package models;

public class Account {
  private String id;
  private String name;
  private String password;
  private String emailAdress;
  private String rol;

  public Account(String id, String name, String password, String emailAdress, String rol) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.emailAdress = emailAdress;
    this.rol = rol;
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
    return emailAdress;
  }

  public void setEmailAdress(String emailAdress) {
    this.emailAdress = emailAdress;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }
}