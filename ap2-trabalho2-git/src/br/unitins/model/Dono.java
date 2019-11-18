package br.unitins.model;

public class Dono {
	private String nome;
	private String cpf;
	private String telefone;
	private Boolean premium;
	
	//CONSTRUTORES
//	public Dono (String nome) {
//		this.nome = nome;
//	}
	
	public Dono (String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Dono(String nome, String cpf, String telefone, Boolean premium) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.premium = premium;
	}

	//GET E SET
	public String getNome() {
		return nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public Boolean getPremium() {
		return premium;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	//OVERRIDE
	@Override
	public String toString() {
		return getNome();
	}

}
