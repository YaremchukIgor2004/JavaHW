package hw_05;

import java.util.List;

public class B04_02 {
	public static void main(String[] args) {
        ApplianceManager manager = new ApplianceManager();

        manager.addAppliance(new KitchenAppliance("Холодильник", 150, 1.5, 10000));
        manager.addAppliance(new KitchenAppliance("Плита", 2000, 2.0, 5000));
        manager.addAppliance(new LivingRoomAppliance("Телевізор", 100, 1.2, 12000));
        manager.addAppliance(new LivingRoomAppliance("Диван", 0, 2.0, 4000));
        manager.addAppliance(new BedroomAppliance("Лампа", 60, 0.3, 2000));
        manager.addAppliance(new BedroomAppliance("Обігрівач", 1500, 0.8, 5000));

        System.out.println("Всі електроприлади:");
        manager.displayAppliances();
        
        double totalPowerConsumption = manager.calculateTotalPowerConsumption();
        System.out.println("\nЗагальна споживана потужність: " + totalPowerConsumption + " Вт");

        manager.sortAppliancesBySize();
        System.out.println("\nПрилади, відсортовані за розміром:");
        manager.displayAppliances();

        double minPrice = 4000;
        double maxPrice = 12000;
        List<Appliance> foundAppliances = manager.findAppliancesInPriceRange(minPrice, maxPrice);
        System.out.println("\nПрилади в ціновому діапазоні [" + minPrice + ", " + maxPrice + "]:");
        for (Appliance appliance : foundAppliances) {
            System.out.println(appliance);
        }
    }
}
