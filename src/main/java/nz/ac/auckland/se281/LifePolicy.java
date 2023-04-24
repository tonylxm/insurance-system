// AUTHOR: Tony Lim
// DATE STARTED: 16/04/2023
// DATE LAST MODIFIED: 24/04/2023

package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

  // Constructor method
  public LifePolicy(int sumInsured, int loadedProfileAge) {
    super(sumInsured);

    // calculate basePremium based on client's age:
    // basePremium = (1 + age/100)% of sumInsured
    basePremium = (int) (((1 + (0.01 * (double) loadedProfileAge)) / 100) * sumInsured);
  }

  @Override
  // Since different policies have different details and different amount of details to print,
  // override the abstract method printPolicyDetails()
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
