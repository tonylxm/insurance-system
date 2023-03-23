// AUTHOR: Tony Lim
// DATE STARTED: 14/03/2023
// DATE LAST MODIFIED: 23/03/2023

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
    int count = 1;

    if (numProfiles() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    } else if (numProfiles() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          "1", formatUserName(database.get(0).getUserName()), database.get(0).getStringAge());
    } else if (numProfiles() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage((numProfiles().toString()), "s", ":");
      for (Profile profile : database) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            Integer.toString(count), formatUserName(profile.getUserName()), profile.getStringAge());
        count++;
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // Formatting the userName: first letter being capatilised with the rest being lowercase.
    String formattedUserName = formatUserName(userName);

    // Try parse input age, otherwise throw an error message that age is invalid.
    try {
      Integer parsedAge = Integer.parseInt(age);
      Profile newProfile = new Profile(formattedUserName, parsedAge);
      String formattedAge = parsedAge.toString();

      // Creates a new profile and adds to the Insurance System database given:
      // 1) userName is more than 3 characters
      // 2) userName is unique across all other userNames in the database
      // 3) age is a positive integer (including 0)
      if (newProfile.isUserNameLongEnough() == false) {
        MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(formattedUserName);
      } else if (isUniqueUserName(formattedUserName) == false) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(formattedUserName);
      } else if (newProfile.isAgeGreaterEqualThanZero() == false) {
        MessageCli.INVALID_AGE.printMessage(formattedAge, formattedUserName);
      } else {
        MessageCli.PROFILE_CREATED.printMessage(formattedUserName, formattedAge);
        database.add(newProfile);
      }
    } catch (Exception e) {
      MessageCli.INVALID_AGE.printMessage(age, formattedUserName);
    }
  }

  public void loadProfile(String userName) {

    String formattedUserName = formatUserName(userName);

    // If the userName is in the database, load the profile. Otherwise return an error message.
    if (!isUniqueUserName(formattedUserName)) {
      MessageCli.PROFILE_LOADED.printMessage(formattedUserName);
    } else {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(formattedUserName);
    }
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

  // returns number of profiles in database
  public Integer numProfiles() {
    return database.size();
  }

  // formats userName to database convention
  public String formatUserName(String userName) {
    return userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
  }

  // Check if userName is unique in ArrayList database
  public boolean isUniqueUserName(String userName) {
    String currentUserName = userName;

    for (int i = 0; i < numProfiles(); i++) {
      if (currentUserName.equals(database.get(i).getUserName())) {
        return false;
      }
    }
    return true;
  }
}
