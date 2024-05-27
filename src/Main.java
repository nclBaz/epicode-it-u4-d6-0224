import entities.Student;
import exceptions.StringNotValidException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// ************************************ ECCEZIONI UNCHECKED ***********************************
		// Sono eccezioni che non ci costringono a doverle gestire con un try catch, ma che piuttosto richiedono qualche
		// accorgimento in più in termini di programmazione per prevenirle (come ad esempio un qualche if(...) )

		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int index = -2;

		if (index >= 0 && index <= numbers.length - 1) // <-- Se metto un controllo adeguato, non avrò neanche bisogno di utilizzare un try-catch
			// Con questo controllo è impossibile arrivare alla situazione in cui si verifica l'eccezione
			System.out.println(numbers[index]); // <-- ArrayIndexOutOfBoundsException

		System.out.println("Caro utente inseriscimi un numero:");
		String input = "ashdhsidhiuh";
		// System.out.println(Integer.parseInt(input)); // <-- NumberFormatException

		String qualcosa = "Qualcosa";
		qualcosa = null;

		if (qualcosa != null) System.out.println(qualcosa.length()); // <-- NullPointerException

		int num1 = 5;
		int num2 = 0;
		if (num2 != 0)
			System.out.println(num1 / num2); // <-- ArithmeticException


		// ************************************ ECCEZIONI CHECKED ***********************************
		// Questo tipo di eccezioni mi costringe a gestirle se voglio eseguire il codice, perché qua non è questione
		// di posso scrivere dei controlli per prevenire l'eccezione


		try {
			Thread.sleep(2000); // Sono costretto ad usare un try-catch perché qua non c'è un codice che mi prevenga l'eccezione
		} catch (InterruptedException e) { // Quindi la devo obbligatoriamente gestire
			throw new RuntimeException(e);
		}

		Student aldo = new Student("Aldo", "Baglio");

		try {
			aldo.setName("Aj");
		} catch (StringNotValidException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(aldo);

		// ******************************************* TRY CATCH ************************************
		Student giovanni = new Student("Giovanni", "Storti");
		try {
			giovanni.setName("Brazorf");
		} catch (StringNotValidException | NullPointerException ex) {
			// In caso di o eccezioni StringNotValidException o NullPointerException stampa il messaggio di errore
			System.out.println(ex.getMessage());
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Hai usato un indice sbagliato per l'array");
		} catch (Exception ex) { // Per tutti gli altri tipi di eccezione stampa "ERRORE GENERICO"
			System.out.println("ERRORE GENERICO");
		}
		// Fare più catch mi serve quando voglio distinguere la gestione degli errori a seconda del tipo di eccezione che mi capita
		// Se invece fossi interessato a gestire tutti le eccezioni nella stessa maniera, a prescindere quindi dal tipo di eccezione ottenuto,
		// mi basta mettere un unico catch di Exception come nell'esempio sottostante

		try {
			System.out.println(numbers[11]);
			System.out.println(qualcosa.length());
		} catch (Exception ex) {
			// Tramite il polimorfismo sto dicendo che tutte le eccezioni a prescindere dal tipo specifico verranno gestite qua dentro
			System.out.println(ex.getMessage());
		}


		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Dammi il primo numero");
			int primo = scanner.nextInt();
			System.out.println("Dammi il secondo numero");
			int secondo = scanner.nextInt();
			System.out.println("Il risultato della divisione é: " + (primo / secondo));
		} catch (ArithmeticException ex) {
			System.err.println("Non puoi dividere per zero!");
		} catch (InputMismatchException ex) {
			System.err.println("Non hai inserito un numero!");
		} finally {
			scanner.close(); // Non importa se le cose sono andate a buon fine o no, ma lo scanner andrebbe sempre chiuso (anche in caso di eccezione)
		}


		// ************************************ ECCEZIONI CUSTOM ***********************************

		// throw new NumberLessThanZeroException(-20); // <-- Col throw lancio esplicitamente un'eccezione


		// ******************************************** ERROR ***********************************************
		// stampa("CIAO");

	}

	public static void stampa(String stringa) {
		stampa(stringa); // <-- StackOverflowError
	}
}