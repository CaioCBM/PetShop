package br.unitins.model;

public abstract class Animal implements Comparable<Animal> {
	protected String nome;
	protected Dono dono;
	protected Sexo sexo;
	protected Integer idade;

	//CONSTRUTORES
	public Animal () {
		
	}
	
	//GET E SET
	public String getNome() {
		return nome;
	}
	public Dono getDono() {
		return dono;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public Integer getIdade() {
		return idade;
	}
	
	//OVERRIDE
	@Override
	public String toString() {
		return "[Nome: " + getNome() + ", " + getSexo() + " - " + getDono();
	}
}
