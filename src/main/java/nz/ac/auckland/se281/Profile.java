package nz.ac.auckland.se281;

public class Profile {

    // Instance fields
    private String userName;
    private int age;

	// Constructor
	public Profile(String userName, int age) {
		this.userName = userName;
		this.age = age;
	}

    // instance method
	public String getUsername() {
		return userName;
	}

	// instance method
	public int getAge() {
		return age;
	}
}
