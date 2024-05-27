package entities;

import exceptions.StringNotValidException;

public class Student {
	private String name;
	private String surname;

	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws StringNotValidException {
		// Throws serve è un'alternativa al try catch che fa una cosa diversa. Throws informa il chiamante (colui il quale invocherà questo metodo), che
		// il metodo potrebbe, in determinati casi, lanciare questa eccezione CHECKED. In qualche maniera è quindi come se delegasse la gestione di tale
		// eccezione a chi chiamerà questo metodo
		if (name.length() <= 3) throw new StringNotValidException(name);
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) throws StringNotValidException {
		if (surname.length() <= 3) throw new StringNotValidException(surname);
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}
}
