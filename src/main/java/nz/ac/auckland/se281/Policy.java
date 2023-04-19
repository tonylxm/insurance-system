package nz.ac.auckland.se281;

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

  public abstract void printPolicyDetails();
}
