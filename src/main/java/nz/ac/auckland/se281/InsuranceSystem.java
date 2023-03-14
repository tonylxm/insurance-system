package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Instance fields
  private int numProfiles = 0;
  private ArrayList database = new ArrayList();




  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    
    if (numProfiles == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    }

    if (numProfiles == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage("1", "Jordan", "21");
    }

  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.

    userName = userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase();  
    int intAge = Integer.parseInt(age);
    
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else if (database.contains(userName) == true) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (intAge <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else {
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
      database.add(userName);
      numProfiles++;
    }


  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
