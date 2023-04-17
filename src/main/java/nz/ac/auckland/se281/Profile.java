package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {
  // Instance fields
  private String userName;
  private Integer age;
  private boolean isLoading;
  private boolean hasLifePolicy;
  private ArrayList<Policy> policyDatabase;
  private Integer totalToPay;

  // Constructor
  public Profile(String userName, Integer age) {
    this.userName = userName;
    this.age = age;
    this.isLoading = false;
    this.hasLifePolicy = false;
    this.policyDatabase = new ArrayList<Policy>();
    this.totalToPay = 0;
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

  public boolean getIsLoading() {
    return isLoading;
  }

  // method that returns if profile is being loaded
  public void setIsLoading(boolean value) {
    if (value) {
      isLoading = true;
    } else if (!value) {
      isLoading = false;
    }
  }

  public boolean getHasLifePolicy() {
    return hasLifePolicy;
  }

  public void setHasLifePolicy() {
    hasLifePolicy = true;
  }

  public int getNumPolicies() {
    return policyDatabase.size();
  }

  public String getStringNumPolicies() {
    Integer numPolicies = policyDatabase.size();
    return numPolicies.toString();
  }

  // adds new created policy to policyDatabase
  public void addPolicy(Policy newPolicy) {
    policyDatabase.add(newPolicy);
  }

  public void printPolicyDatabase() {
    for (Policy policy : policyDatabase) {
      policy.printPolicyDetails();
    }
  }

  public void calculateAllDiscountedPremiums(int numPolicies) {
    for (Policy policy : policyDatabase) {
      policy.calculateDiscountPremium(numPolicies);
    }
  }

  public String getTotalToPay() {
    // calculate the total amount to pay by adding up all the discounted premiums on all policies
    // for that account
    for (Policy policy : policyDatabase) {
      totalToPay += policy.getDiscountedPremium();
    }
    return totalToPay.toString();
  }
}
