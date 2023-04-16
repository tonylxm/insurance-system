package nz.ac.auckland.se281;

public class LifePolicy extends Policy {
  private int loadedProfileAge;

  public LifePolicy(int sumInsured, int loadedProfileAge) {
    super(sumInsured);
    loadedProfileAge = this.loadedProfileAge;
  }

  @Override
  public void calculateBasePremium() {
    basePremium = (int) (1 + ((double) loadedProfileAge / 100));
  }
}
