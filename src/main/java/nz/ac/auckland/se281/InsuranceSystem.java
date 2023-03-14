package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Instance fields
  private ArrayList<Profile> database = new ArrayList<Profile>();


  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    int numProfiles = database.size();
    String numProfilesString = Integer.toString(numProfiles);
    
    if (database.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    }

    if (database.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      // FIX: very unreadable code to extract username and age from database to print out
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(numProfilesString, database.get(0).getUsername(), Integer.toString (database.get(0).getAge()));
    }

    if (database.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(numProfilesString, "s", ":");

      // implement logic to print whole database as stored in ArrayList using for / for each loop
    }
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
  
    userName = userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase();  
    int intAge = Integer.parseInt(age);

    Profile newProfile = new Profile(userName, intAge);
    
    // This logic prints out username extracted from the database
    // System.out.println(database.get(0).getUsername());
    
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      // FIX THIS boolean statement
    } else if (userName != newProfile.getUsername()) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (intAge <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else {
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
      database.add(newProfile);
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
