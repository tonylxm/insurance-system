// AUTHOR: Tony Lim
// DATE STARTED: 16/04/2023
// DATE LAST MODIFIED: 21/04/2023

package nz.ac.auckland.se281;

// Constructor - instance field protected so that only classes that inherit from Policy.java (i.e.
// policy types classes) can access and modify
public abstract class Policy {
  protected int sumInsured;
  protected int basePremium;
  protected int discountedPremium;

  public Policy(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  public int getBasePremium() {
    return basePremium;
  }

  public int getDiscountedPremium() {
    return discountedPremium;
  }

  // 2 policies on 1 account = 10% discount on premiums for both the 2 polciies (total 10% discount
  // for totalToPay).
  // 3 or more policies on 1 account = 20% discount on premiums for the 3 or more polciies (total
  // 20% discount for totalToPay).
  public void calculateDiscountPremium(int numPolicies) {
    this.discountedPremium = basePremium;
    if (numPolicies == 2) {
      discountedPremium = (int) ((double) basePremium - 0.1 * (double) basePremium);
    } else if (numPolicies >= 3) {
      discountedPremium = (int) ((double) basePremium - 0.2 * (double) basePremium);
    }
  }

  // Abstract method so classes that inherit this class (types of policies) must override this
  // method
  public abstract void printPolicyDetails();
}
