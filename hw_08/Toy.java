package hw_08;

import java.io.*;
import java.util.ArrayList;

public class Toy implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private double price;
    private int minAge;
    private int maxAge;
    
    public Toy(String name, double price, int minAge, int maxAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    
    @Override
    public String toString() {
        return name + ": " + price + " грн, для віку від " + minAge + " до " + maxAge;
    }
    
    public static void write(Toy[] array, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Toy toy : array) {
                oos.writeObject(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Toy[] read(String filename) {
        ArrayList<Toy> toyList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    toyList.add((Toy) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return toyList.toArray(new Toy[0]);
    }
    
    public static Toy[] filterByAge(Toy[] toys, int childAge) {
        ArrayList<Toy> filteredToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.minAge <= childAge && toy.maxAge >= childAge) {
                filteredToys.add(toy);
            }
        }
        return filteredToys.toArray(new Toy[0]);
    }
}

