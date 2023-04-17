package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

  public LifePolicy(int sumInsured, int loadedProfileAge) {
    super(sumInsured);

    // calculate basePremium based on client's age
    basePremium = (int) (((1 + (0.01 * (double) loadedProfileAge)) / 100) * sumInsured);
  }

  @Override
  public void printPolicyDetails() {
    System.out.println(
        "Life Policy (Sum Insured: $"
            + sumInsured
            + ", Premium: $"
            + basePremium
            + " -> $"
            + discountedPremium
            + ")");
  }
}
