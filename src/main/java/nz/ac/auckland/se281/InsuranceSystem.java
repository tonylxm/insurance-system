// AUTHOR: Tony Lim
// DATE STARTED: 14/03/2023
// DATE LAST MODIFIED: 19/03/2023

package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private ArrayList<Profile> database = new ArrayList<Profile>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // Prints all profiles created in that point in time when invoked. Different arguments are
    // passed into the print statment depending on the number of Profiles (0, 1 or greater than 1).

    if (numProfiles() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (numProfiles() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          "1", getUserNameDatabase(0), getAgeDatabase(0));
    } else if (numProfiles() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(intToString(numProfiles()), "s", ":");
      for (int i = 0; i < numProfiles(); i++) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            Integer.toString(i + 1), getUserNameDatabase(i), getAgeDatabase(i));
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // Creates a new profile and adds to the Insurance System database given:
    // 1) userName is more than 3 characters
    // 2) userName is unique across all other userNames in the database
    // 3) age is a positive integer (including 0)

    Profile newProfile = new Profile(userName, stringToInt(age));
    // Formatting the userName: first letter being capatilised with the rest being lowercase.
    String formattedUserName = newProfile.getUserName();

    if (newProfile.isUserNameLongEnough() == false) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(formattedUserName);
    } else if (isUniqueUserName(formattedUserName) == false) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(formattedUserName);
    } else if (newProfile.isAgeValid() == false) {
      MessageCli.INVALID_AGE.printMessage(age, formattedUserName);
    } else {
      MessageCli.PROFILE_CREATED.printMessage(formattedUserName, age);
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

  public String intToString(int number) {
    return Integer.toString(number);
  }

  public int stringToInt(String number) {
    return Integer.parseInt(number);
  }

  // Returns userName at specific index extracted from database
  public String getUserNameDatabase(int index) {
    return database.get(index).getUserName();
  }

  // Returns age at specific index extracted from database
  public String getAgeDatabase(int index) {
    return Integer.toString(database.get(index).getAge());
  }

  // Check if userName is unique in ArrayList database
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
