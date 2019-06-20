package persistence.user;

public interface UserDao {
  abstract public String findRoleForUser(String name, String pass);
}