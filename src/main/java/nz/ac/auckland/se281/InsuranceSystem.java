package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    int numProfiles = 0;

    if (numProfiles == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.getMessage("0", "s", "."); 
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    }
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
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
