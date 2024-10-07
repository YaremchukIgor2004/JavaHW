package hw_05;

public class KitchenAppliance extends Appliance {
    private double pricePerSizeUnit;

    public KitchenAppliance(String name, double power, double size, double pricePerSizeUnit) {
        super(name, power, size);
        this.pricePerSizeUnit = pricePerSizeUnit;
    }

    @Override
    public double getPrice() {
        return getSize() * pricePerSizeUnit;
    }
}
