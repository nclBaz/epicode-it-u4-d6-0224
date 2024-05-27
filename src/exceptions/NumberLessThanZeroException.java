package exceptions;

public class NumberLessThanZeroException extends RuntimeException {
	// Se estendo RuntimeException sto creando un'eccezione UNCHECKED
	public NumberLessThanZeroException(int num) {
		super("Il numero " + num + " è minore di zero!");
	}
}
