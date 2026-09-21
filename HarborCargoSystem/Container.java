package HarborCargoSystem;

import java.util.Objects;

public class Container {
    private final String id;
    private final double weight;
    private final CargoType cargoType;

    public Container(String id, double weight, CargoType cargoType){
        this.id = id;
        this.weight = weight;
        this.cargoType = cargoType;
    }

    public String getId() {
        return this.id;
    }

    public double getWeight() {
        return this.weight;
    }

    public CargoType getCargoType() {
        return this.cargoType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Double.compare(weight, container.weight) == 0
                && Objects.equals(id, container.id)
                && cargoType == container.cargoType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, cargoType);
    }

    @Override
    public String toString() {
        return String.format(
                "Container{\nid=%s\nweight=%f\ncargoType=%s}",
                getId(), getWeight(), getCargoType()
        );
    }
}
