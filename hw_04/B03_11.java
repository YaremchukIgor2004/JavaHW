package hw_04;

public class B03_11 {
    public static void main(String[] args) {
        Abiturient[] abiturients = {
            new Abiturient("Мусієнко Ярослав", "хз", "хз", new int[]{100, 100, 100}),
            new Abiturient("Середюк Віктор", "хз", "хз", new int[]{95, 95, 95}),
            new Abiturient("Яремчук Ігор", "Юлії Здановської, 35", "+380677932416", new int[]{90, 90, 90}),
            new Abiturient("Тимочко Наталія", "Юлії Здановської, 55", "хз", new int[]{91, 91, 91}),
            new Abiturient("Путін Володимир", "Бомбити НАХУЙ", "+74956970349", new int[]{80, 80, 80}),
            new Abiturient("Кримський Міст", "Кримський Міст", "ЯДЕРКОЮ", new int[]{75, 75, 75})
        };

        int scoreLimit = 250;
        System.out.println("Абітурієнти із загальним балом менше ніж " + scoreLimit + ":");
        Abiturient.findAbiturientsWithLowScore(abiturients, scoreLimit)
                  .forEach(System.out::println);

        int n = 3;
        System.out.println("\nТоп " + n + " Абітурієнтів:");
        Abiturient.findTopNAbiturients(abiturients, n)
                  .forEach(System.out::println);
    }
}
