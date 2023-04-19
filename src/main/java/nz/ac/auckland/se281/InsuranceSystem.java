// AUTHOR: Tony Lim
// DATE STARTED: 14/03/2023
// DATE LAST MODIFIED: 19/04/2023

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
    // passed into the print statment depending on the number of Profiles (0, 1 or greater than
    // 1).
    int count = 1;

    switch (numProfiles()) {
      case 0:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
        break;

      case 1:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
        // If the profile is loading, print *** to indicate the profile is loaded.
        if (database.get(0).getIsLoading()) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              Integer.toString(count),
              formatUserName(database.get(0).getUserName()),
              database.get(0).getStringAge(),
              database.get(0).getStringNumPolicies(),
              getArguementBasedOnNumProfiles(0),
              database.get(0).getTotalToPay());
          database.get(0).printPolicyDatabase();
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              "1",
              formatUserName(database.get(0).getUserName()),
              database.get(0).getStringAge(),
              database.get(0).getStringNumPolicies(),
              getArguementBasedOnNumProfiles(0),
              database.get(0).getTotalToPay());
          database.get(0).printPolicyDatabase();
        }
        break;

      default:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage((numProfiles().toString()), "s", ":");
        for (Profile profile : database) {
          // If the profile is loading, print *** to indicate the profile is loaded.
          if (profile.getIsLoading()) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "*** ",
                Integer.toString(count),
                formatUserName(profile.getUserName()),
                profile.getStringAge(),
                profile.getStringNumPolicies(),
                getArguementBasedOnNumProfiles(count - 1),
                profile.getTotalToPay());
            count++;
            profile.printPolicyDatabase();
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
                "",
                Integer.toString(count),
                formatUserName(profile.getUserName()),
                profile.getStringAge(),
                profile.getStringNumPolicies(),
                getArguementBasedOnNumProfiles(count - 1),
                profile.getTotalToPay());
            count++;
            profile.printPolicyDatabase();
          }
        }
    }
  }

  public void createNewProfile(String userName, String age) {
    // If profile is loaded, return error message and do not create any new profiles
    if (isAnyProfileLoaded()) {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(getLoadedProfile().getUserName());
    } else {
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
        } else if (isUserNameUnique(formattedUserName) == false) {
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
  }

  public void loadProfile(String userName) {
    String formattedUserName = formatUserName(userName);

    // If the userName is in the database, load the profile. Otherwise return an error message.
    if (!isUserNameUnique(formattedUserName)) {
      if (isAnyProfileLoaded()) {
        unloadProfile();
      }
      getProfileGivenUserName(formattedUserName).setIsLoading(true);
      MessageCli.PROFILE_LOADED.printMessage(formattedUserName);
    } else {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(formattedUserName);
    }
  }

  public void unloadProfile() {
    if (!isAnyProfileLoaded()) {
      MessageCli.NO_PROFILE_LOADED.printMessage();
    } else {
      MessageCli.PROFILE_UNLOADED.printMessage(getLoadedProfile().getUserName());
      getLoadedProfile().setIsLoading(false);
    }
  }

  public void deleteProfile(String userName) {
    String formattedUserName = formatUserName(userName);

    // If the userName is in the database and the profile is not currently loading, delete the
    // profile.
    if (!isUserNameUnique(formattedUserName)) {
      if (getProfileGivenUserName(formattedUserName).getIsLoading()) {
        // Cannot delete profile while it is currently loaded
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(formattedUserName);
      } else {
        database.remove(getProfileGivenUserName(formattedUserName));
        MessageCli.PROFILE_DELETED.printMessage(formattedUserName);
      }
    } else {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(formattedUserName);
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    // Make sure there is a profile loaded to create a policy for
    if (!isAnyProfileLoaded()) {
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
    } else {
      // Getting variables from respective classes
      int sumInsured = Integer.parseInt(options[0]);
      int loadedProfileAge = getLoadedProfile().getAge();
      String loadedProfileUserName = getLoadedProfile().getUserName();

      switch (type) {
        case HOME:
          // Preliminary
          boolean isRental = false;
          if (options[2].contains("y")) {
            isRental = true;
          }

          HomePolicy newHomePolicy = new HomePolicy(sumInsured, options[1], isRental);
          getLoadedProfile()
              .addPolicy(
                  newHomePolicy); // Add the home policy to the loaded profile's policy arraylist
          MessageCli.NEW_POLICY_CREATED.printMessage("home", loadedProfileUserName);
          break;

        case CAR:
          boolean isBrokenDown = false;
          if (options[3].contains("y")) {
            isBrokenDown = true;
          }

          CarPolicy newCarPolicy =
              new CarPolicy(sumInsured, options[1], options[2], isBrokenDown, loadedProfileAge);
          getLoadedProfile()
              .addPolicy(
                  newCarPolicy); // Add the car policy to the loaded profile's policy arraylist
          MessageCli.NEW_POLICY_CREATED.printMessage("car", loadedProfileUserName);
          break;

        case LIFE:
          // Check if profile is over age (> 100 years old)
          if (loadedProfileAge > 100) {
            MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(loadedProfileUserName);
            // Check if profile already has life policy by checking boolean value
          } else if (getLoadedProfile().getHasLifePolicy()) {
            MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(loadedProfileUserName);
          } else {
            LifePolicy newLifePolicy = new LifePolicy(sumInsured, loadedProfileAge);
            getLoadedProfile()
                .addPolicy(
                    newLifePolicy); // Add the life policy to the loaded profile's policy arraylist
            getLoadedProfile()
                .setHasLifePolicy(); // This profile now has life policy, so mark it down by
                                     // changing a boolean value to 'true'
            MessageCli.NEW_POLICY_CREATED.printMessage("life", loadedProfileUserName);
            break;
          }
      }

      // Apply discounts to premiums based on numPolicies for the loaded profile
      getLoadedProfile().calculateAllDiscountedPremiums(getLoadedProfile().getNumPolicies());
    }
  }

  // ****** HELPER METHODS START ******

  // returns number of profiles in database
  public Integer numProfiles() {
    return database.size();
  }

  // formats userName to database convention
  public String formatUserName(String userName) {
    return userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
  }

  // Check if userName is unique in ArrayList database
  public boolean isUserNameUnique(String userName) {
    String currentUserName = userName;

    for (int i = 0; i < numProfiles(); i++) {
      if (currentUserName.equals(database.get(i).getUserName())) {
        return false;
      }
    }
    return true;
  }

  // Must check if userName is in database FIRST, otherwise will return null
  public Profile getProfileGivenUserName(String userName) {
    for (Profile profile : database) {
      if (userName.equals(profile.getUserName())) {
        return profile;
      }
    }
    return null;
  }

  // Check if any profile in database is loaded
  public boolean isAnyProfileLoaded() {
    for (Profile profile : database) {
      if (profile.getIsLoading()) {
        return true;
      }
    }
    return false;
  }

  // Return the loaded profile
  public Profile getLoadedProfile() {
    for (Profile profile : database) {
      if (profile.getIsLoading()) {
        return profile;
      }
    }
    return null;
  }

  // For 0 or > 1 policies, return 'ies' to append to 'polic' in string message. 
  // For 1 policy, return 'y' to append to 'polic' in string message.
  public String getArguementBasedOnNumProfiles(int index) {
    if (database.get(index).getNumPolicies() == 0 || database.get(index).getNumPolicies() > 1) {
      return "ies";
    } else {
      return "y";
    }
  }

  // ****** HELPER METHODS END ******
}
