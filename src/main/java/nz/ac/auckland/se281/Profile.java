package nz.ac.auckland.se281;

public class Profile {

  // Instance fields
  private String userName;
  private Integer age;

  // Constructor
  public Profile(String userName, Integer age) {
    this.userName = userName;
    this.age = age;
  }

  public String getUserName() {
    return userName;
  }

  public int getAge() {
    return age;
  }

  public String getStringAge() {
    return age.toString();
  }

  // method that checks if userName is greater than 3 characters
  public boolean isUserNameLongEnough() {
    if (userName.length() < 3) {
      return false;
    }
    return true;
  }

  // method that checks if age is a positive integer (greater or equal to 0)
  public boolean isAgeGreaterEqualThanZero() {
    if (age < 0) {
      return false;
    }
    return true;
  }
}
