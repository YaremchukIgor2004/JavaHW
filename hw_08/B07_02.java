package hw_08;

import java.util.Arrays;

public class B07_02 {
    public static void main(String[] args) {
        String fileinp = "src\\hw_08\\input.toy";
        String fileout = "src\\hw_08\\output.toy";
        
        Toy[] toys = {
            new Toy("М'яч", 200.0, 3, 7),
            new Toy("Лялька", 250.0, 5, 10),
            new Toy("Конструктор", 1000.0, 7, 12)
        };
        
        Toy.write(toys, fileinp);
        Toy[] readToys = Toy.read(fileinp);
        System.out.println("Усі іграшки: " + Arrays.toString(readToys));
        int childAge = 6;
        Toy[] filteredToys = Toy.filterByAge(readToys, childAge);
        Toy.write(filteredToys, fileout);
        Toy[] resultToys = Toy.read(fileout);
        System.out.println("Іграшки для віку " + childAge + ": " + Arrays.toString(resultToys));
    }

}
