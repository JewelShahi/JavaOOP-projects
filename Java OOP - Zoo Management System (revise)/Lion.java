/**
 * Lion
 */
public class Lion extends Animal {
	// ------------- Constructor --------------------
	public Lion(String name, int age) {
		super(name, age);
		// using super keyword makes a lot easyer to access the parent class fields
	}

	// ------------- Abstraction ----------------
	@Override
	public void animalSound() {
		System.out.println("Roooaaarr!");
	}

}
