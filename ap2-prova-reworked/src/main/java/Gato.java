package main.java;
public class Gato extends Animal {

	public Gato() {

	}

	public Gato(String nome) {
		super(nome);
	}

	@Override
	public String toString() {
		return super.toString() + ", o " + getClass().getSimpleName();
	}
}
