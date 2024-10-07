package hw_05;

public class LivingRoomAppliance extends Appliance {
    private double pricePerSizeUnit;

    public LivingRoomAppliance(String name, double power, double size, double pricePerSizeUnit) {
        super(name, power, size);
        this.pricePerSizeUnit = pricePerSizeUnit;
    }

    @Override
    public double getPrice() {
        return getSize() * pricePerSizeUnit;
    }
}
