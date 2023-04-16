package nz.ac.auckland.se281;

public class HomePolicy extends Policy {
  private String address;
  private boolean isRental;

  public HomePolicy(int sumInsured, String address, boolean isRental) {
    super(sumInsured);

    if (isRental) {
      basePremium = (int) 0.02 * sumInsured;
    } else {
      basePremium = (int) 0.01 * sumInsured;
    }
  }
}
