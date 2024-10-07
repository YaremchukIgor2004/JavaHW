package hw_05;

public abstract class Appliance {
    private String name;
    private double power;
    private double size;

    public Appliance(String name, double power, double size) {
        this.name = name;
        this.power = power;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public double getSize() {
        return size;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return "Appliance{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", size=" + size +
                ", price=" + getPrice() +
                '}';
    }
}

