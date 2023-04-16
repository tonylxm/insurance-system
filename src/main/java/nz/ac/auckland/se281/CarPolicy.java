package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
  private String makeAndModel;
  private String licensePlate;
  private boolean isBrokenDown;
  private int loadedProfileAge;

  public CarPolicy(
      int sumInsured,
      String makeAndModel,
      String licensePlate,
      boolean isBrokenDown,
      int loadedProfileAge) {
    super(sumInsured);
    makeAndModel = this.makeAndModel;
    licensePlate = this.licensePlate;
    loadedProfileAge = this.loadedProfileAge;
  }

  @Override
  public void calculateBasePremium() {

    if (loadedProfileAge < 25) {
      basePremium = (int) (0.15 * (double) sumInsured);
    } else if (loadedProfileAge >= 25) {
      basePremium = (int) (0.1 * (double) sumInsured);
    }
    if (isBrokenDown) {
      basePremium += 80;
    }
  }
}
