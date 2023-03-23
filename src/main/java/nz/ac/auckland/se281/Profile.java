package nz.ac.auckland.se281;

public class Profile {

  // Instance fields
  private String userName;
  private int age;

  // Constructor
  public Profile(String userName, int age) {
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
    String stringAge = Integer.toString(age);
    return stringAge;
  }

  // method that checks if userName is greater than 3 characters
  public boolean isUserNameLongEnough() {
    if (userName.length() < 3) {
      return false;
    }
    return true;
  }

  // method that checks if age is a positive integer (greater or equal to 0)
  public boolean isAgeValid() {
    if (age < 0) {
      return false;
    }
    return true;
  }
}
