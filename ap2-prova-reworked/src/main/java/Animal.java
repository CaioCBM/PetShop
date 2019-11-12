package main.java;

public class Animal implements Comparable<Animal> {

	protected String nome;

	public Animal() {

	}

	protected Animal(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome;
	}

	@Override
	public int compareTo(Animal outroAnimal) {
		return this.nome.compareTo(outroAnimal.getNome());
	}
}
