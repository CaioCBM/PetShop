package br.unitins.model;

public class Gato extends Animal {

	//CONSTRUTORES
	public Gato (String nome, Sexo sexo) {
		this.nome = nome;
		this.sexo = sexo;
	}
	
	public Gato (Dono dono) {
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
}
