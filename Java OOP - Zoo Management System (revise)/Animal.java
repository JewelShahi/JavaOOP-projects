/**
 * Animal
 */
abstract class Animal {

    // -------------------- Fields ----------------------
    // Name
    private String name;

    // Age
    private int age;

    // ------------- Constructor --------------------
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ------------------ Methods--------------------
    // Encapsulation for Name
    // Getter
    public String getName() {
        return this.name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Encapsulation for Age
    // Getter
    public int getAge() {
        return this.age;
    }

    // Setter
    public void setAge(int age) {
        this.age = age;
    }

    // Gett Whole Animal Info
    public void animalInfo() {
        System.out.println("-------------------------");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("-------------------------");
    }

    // Abstract Method
    public abstract void animalSound();
}
