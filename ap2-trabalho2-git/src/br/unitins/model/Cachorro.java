package br.unitins.model;

public class Cachorro extends Animal {

	//CONSTRUTORES
	public Cachorro (String nome, Sexo sexo, Dono dono) {
		this.nome = nome;
		this.sexo = sexo;
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
		return super.toString() + " - Animal: " + getClass().getSimpleName();
	}
	
}
