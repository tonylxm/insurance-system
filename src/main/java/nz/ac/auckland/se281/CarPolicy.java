package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
  private String makeAndModel;
  private String licensePlate;

  public CarPolicy(
      int sumInsured,
      String makeAndModel,
      String licensePlate,
      boolean isBrokenDown,
      int loadedProfileAge) {
    super(sumInsured);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;

    // Calculate basePremium based on client's age:
    // - If they are under 25, basePremium = 15% of sumInsured
    // - If they are 25 and over, basePremium = 10% of sumInsured
    if (loadedProfileAge < 25) {
      basePremium = (int) (0.15 * (double) sumInsured);
    } else if (loadedProfileAge >= 25) {
      basePremium = (int) (0.1 * (double) sumInsured);
    }
    if (isBrokenDown) {
      basePremium += 80;
    }
  }

  // Since different policies have different details and different amount of details to print,
  // override the abstract method printPolicyDetails()
  @Override
  public void printPolicyDetails() {
    System.out.println(
        "Car Policy ("
            + makeAndModel
            + ", Sum Insured: $"
            + sumInsured
            + ", Premium: $"
            + basePremium
            + " -> $"
            + discountedPremium
            + ")");
  }
}
