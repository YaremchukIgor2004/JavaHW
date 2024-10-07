package hw_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ApplianceManager {
    private List<Appliance> appliances;

    public ApplianceManager() {
        appliances = new ArrayList<>();
    }

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public void sortAppliancesBySize() {
        Collections.sort(appliances, Comparator.comparingDouble(Appliance::getSize));
    }

    public List<Appliance> findAppliancesInPriceRange(double minPrice, double maxPrice) {
        List<Appliance> result = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance.getPrice() >= minPrice && appliance.getPrice() <= maxPrice) {
                result.add(appliance);
            }
        }
        return result;
    }

    public double calculateTotalPowerConsumption() {
        double totalPower = 0;
        for (Appliance appliance : appliances) {
            totalPower += appliance.getPower();
        }
        return totalPower;
    }

    public void displayAppliances() {
        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }
    }
}
