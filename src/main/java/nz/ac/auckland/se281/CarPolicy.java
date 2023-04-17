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

    // calculate basePremium based on client's age
    if (loadedProfileAge < 25) {
      basePremium = (int) (0.15 * (double) sumInsured);
    } else if (loadedProfileAge >= 25) {
      basePremium = (int) (0.1 * (double) sumInsured);
    }
    if (isBrokenDown) {
      basePremium += 80;
    }
  }

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
