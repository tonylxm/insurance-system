package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Instance fields
  // ArrayLists of both userNames and ages (indexes of each userName in userNameList corresponds to the same index of age in ageList)
  private ArrayList<String> userNameList = new ArrayList<String>();
  private ArrayList<String> ageList = new ArrayList<String>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {

    if (userNameList.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    }

    if (userNameList.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage("1", userNameList.get(0), ageList.get(0));
    }

    if (userNameList.size() > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(userNameList.size()), "s", ":");
      for (int i = 0; i < userNameList.size(); i++) {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(Integer.toString(i + 1), userNameList.get(i), ageList.get(i));
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
  
    userName = userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase();  
    int intAge = Integer.parseInt(age);

    Profile newProfile = new Profile(userName, intAge);
       
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      // FIX THIS boolean statement
    } else if (userNameList.contains(userName)) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (intAge <= 0) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else {
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
      userNameList.add(userName);
      ageList.add(age);
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
