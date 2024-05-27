public class Main {
	public static void main(String[] args) {

		// ************************************ ECCEZIONI ***********************************

		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int index = 11;

		if (index <= numbers.length - 1)
			System.out.println(numbers[index]); // <-- ArrayIndexOutOfBoundsException

		System.out.println("Caro utente inseriscimi un numero:");
		String input = "ashdhsidhiuh";
		// System.out.println(Integer.parseInt(input)); // <-- NumberFormatException

		String qualcosa = "Qualcosa";
		qualcosa = null;

		if (qualcosa != null) System.out.println(qualcosa.length()); // <-- NullPointerException

		int num1 = 5;
		int num2 = 0;

		System.out.println(num1 / num2); // <-- ArithmeticException


	}
}