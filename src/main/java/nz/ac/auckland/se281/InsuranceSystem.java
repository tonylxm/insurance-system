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
    // Prints the Insurance System Database

    if (numProfiles() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (numProfiles() == 1) {
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage("1", getUserNameDatabase(0), getAgeDatabase(0));
    } else if (numProfiles() > 1) {
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(IntToString(numProfiles()), "s", ":");
        for (int i = 0; i < numProfiles(); i++) {
          MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(Integer.toString(i + 1), getUserNameDatabase(i), getAgeDatabase(i));
        }
      }
    }

  public void createNewProfile(String userName, String age) {
    // Creates a new profile and adds to the Insurance System database given the username and age are valid

    // userName formatted to database convention
    userName = formatUserName(userName);

     // Create new Profile
    Profile newProfile = new Profile(userName, StringToInt(age));

    if (newProfile.isUserNameLongEnough() == false) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else if (isUniqueUserName(userName) == false) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (newProfile.isAgeValid() == false) {
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

  // ****** HELPER METHODS START ******

  // returns number of profiles in database
  public int numProfiles() {
    return database.size();
  }

  public String IntToString(int number) {
    return Integer.toString(number);
  }

  public int StringToInt(String number) {
    return Integer.parseInt(number);
  }

   // method that formats userName to have the first letter captial and the rest lowercase
   public String formatUserName(String userName) {
    return userName = userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase();
  }

  // Returns userName at specific index extracted from database
  public String getUserNameDatabase(int index) {
    return database.get(index).getUsername();
  }

  // Returns age at specific index extracted from database
  public String getAgeDatabase(int index) {
    return Integer.toString(database.get(index).getAge());
  }

  // Check if userName is unique in database
  public boolean isUniqueUserName(String userName) {
    String currentUserName = userName;

    for (int i = 0; i < numProfiles(); i++) {
      if (currentUserName.equals(getUserNameDatabase(i))) {
        return false;
      }
    }
    return true;
  }

  // ****** HELPER METHODS END ******
}
