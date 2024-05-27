package exceptions;

public class StringNotValidException extends Exception {
	// Se estendo Exception sto creando un'eccezione CHECKED
	public StringNotValidException(String stringa) {
		super("La stringa " + stringa + " non è valida");
	}
}
