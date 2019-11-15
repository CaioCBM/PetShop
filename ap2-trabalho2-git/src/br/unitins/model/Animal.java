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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}
}
