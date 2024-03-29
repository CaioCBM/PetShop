package br.unitins.model;

public class Gato extends Animal {

	// CONSTRUTORES
	public Gato (String nome, Integer idade, Dono dono) {
		super(nome, idade, dono);
	}

	public Gato(String nome, Dono dono, Sexo sexo, Integer idade) {
		this.nome = nome;
		this.dono = dono;
		this.sexo = sexo;
		this.idade = idade;
	}

	// OVERRIDES
	@Override
	public String toString() {
		return super.toString() + " - " + getClass().getSimpleName() + "]";
	}

	@Override
	public int compareTo(Animal outroAnimal) {
		return getNome().compareTo(outroAnimal.getNome());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}