// AUTHOR: Tony Lim
// DATE STARTED: 16/04/2023
// DATE LAST MODIFIED: 21/04/2023

package nz.ac.auckland.se281;

public class HomePolicy extends Policy {
  private String address;

  // Constructor method
  public HomePolicy(int sumInsured, String address, boolean isRental) {
    super(sumInsured);
    this.address = address;

    // Calculates basePremium depending on whether the house is a rental or not:
    // - If a rental, basePremium = 2% of sumInsured
    // - If not a rental, basePremium = 1% of sumInsured
    if (isRental) {
      basePremium = (int) (0.02 * (double) sumInsured);
    } else {
      basePremium = (int) (0.01 * (double) sumInsured);
    }
  }

  // Since different policies have different details and different amount of details to print,
  // override the abstract method printPolicyDetails()
  @Override
  public void printPolicyDetails() {
    System.out.println(
        "Home Policy ("
            + address
            + ", Sum Insured: $"
            + sumInsured
            + ", Premium: $"
            + basePremium
            + " -> $"
            + discountedPremium
            + ")");
  }
}
