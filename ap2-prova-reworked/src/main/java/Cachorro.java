package main.java;

public class Cachorro extends Animal {

	public Cachorro() {
		super();
	}

	public Cachorro(String nome) {
		super(nome);
	}

	@Override
	public String toString() {
		return super.toString() + ", o " + getClass().getSimpleName();
	}
}
