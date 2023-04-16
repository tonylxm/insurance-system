package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
  private String makeAndModel;
  private String licensePlate;
  private boolean isBrokenDown;

  public CarPolicy(int sumInsured, String makeAndModel, String licensePlate, boolean isBrokenDown) {
    super(sumInsured);

    if (isBrokenDown) {
      basePremium += 80;
    }
  }
}
