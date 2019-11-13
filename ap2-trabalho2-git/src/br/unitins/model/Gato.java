package br.unitins.model;

public class Gato extends Animal {

	//CONSTRUTORES
	public Gato (String nome, Dono dono) {
		this.nome = nome;
		this.dono = dono;
	}
	
	public Gato (String nome, Dono dono, Sexo sexo, Integer idade) {
		this.nome = nome;
		this.dono = dono;
		this.sexo = sexo;
		this.idade = idade;
	}
	
	//OVERRIDES
	@Override
	public String toString() {
		return super.toString() + " - Animal: " + getClass().getSimpleName();
	}
	
	@Override
	public int compareTo(Animal outroAnimal) {
		return this.getNome().compareTo(outroAnimal.getNome());
	}
}
