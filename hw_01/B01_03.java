package hw_01;

public class B01_03 {

	public static void main(String[] args) {
		int ans = 1;
		for (int i = 0; i < args.length; i++) {
			try {
				int a = Integer.parseInt(args[i]);
				ans *= a;
			} catch (NumberFormatException e) {
				System.out.println("Не цілий аргумент!");
			}
        }
		System.out.println(ans);
		
	}
	
}
