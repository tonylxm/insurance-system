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

  public void calculateDiscountPremium(int numPolicies) {
    discountedPremium = basePremium;
    if (numPolicies == 2) {
      discountedPremium -= (int) (0.1 * (double) basePremium);
    } else if (numPolicies >= 3) {
      discountedPremium -= (int) (0.2 * (double) basePremium);
    }
  }

  public abstract void printPolicyDetails();
}
