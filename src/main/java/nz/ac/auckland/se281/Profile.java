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
  
  // instance method that gets userName
  public String getUsername() {
	  return userName;
  }

  // instance method that gets age as an integer
  public int getAge() {
	  return age;
  }

  // instance method that gets age as a String
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
