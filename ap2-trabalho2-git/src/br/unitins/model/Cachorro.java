package br.unitins.model;

public class Cachorro extends Animal {

	//CONSTRUTORES
	public Cachorro (String nome, Dono dono) {
		this.nome = nome;
		this.dono = dono;
	}
	
	public Cachorro (String nome, Dono dono, Sexo sexo, Integer idade) {
		this.nome = nome;
		this.dono = dono;
		this.sexo = sexo;
		this.idade = idade;
	}
	
	//OVERRIDES
	@Override
	public String toString() {
		return super.toString() + " - Animal: " + getClass().getSimpleName() + "]";
	}
	
	@Override
	public int compareTo(Animal outroAnimal) {
		return getDono().getNome().compareTo(outroAnimal.getDono().getNome());
	}
	
}
