package nz.ac.auckland.se281;

public class HomePolicy extends Policy {
  private String address;

  public HomePolicy(int sumInsured, String address, boolean isRental) {
    super(sumInsured);
    this.address = address;

    // calculates basePremium depending on whether the house is a rental or not
    if (isRental) {
      basePremium = (int) (0.02 * (double) sumInsured);
    } else {
      basePremium = (int) (0.01 * (double) sumInsured);
    }
  }

  @Override
  public void printPolicyDetails() {
    System.out.println(
        "Home Policy ("
            + address
            + ", Sum Insured: $"
            + sumInsured
            + ", Premium: $"
            + this.basePremium
            + " -> $"
            + this.discountedPremium
            + ")");
  }
}
