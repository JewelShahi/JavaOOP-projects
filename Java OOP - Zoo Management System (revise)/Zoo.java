
// Imports
import java.util.List;
import java.util.ArrayList;

/**
 * Zoo
 */

public class Zoo {

	private List<Animal> animals;

	public Zoo() {
		this.animals = new ArrayList<Animal>();
	}

	public void addAnimal(Animal animal) {
		this.animals.add(animal);
	}

	public void makeAllAnimalsSound() {
		for (Animal animal : this.animals) {
			animal.animalSound();
		}
	}

	public void performActionOnAllAnimals(AnimalAction action) {
		for (Animal animal : animals) {
			action.performAction(animal);
		}
	}
}
