package br.unitins.aplication;

import java.util.Scanner;

import br.unitins.model.Animal;
import br.unitins.model.Cachorro;
import br.unitins.model.Dono;
import br.unitins.model.Gato;
import br.unitins.model.Sexo;

public class Main {
	//Inicialização de 2 Usuarios aleatorios
	static final  String usuario1 = "Anotherafael";
	static final  String senha1 = "Gabs2";
	static final  String usuario2 = "Caiocbm";
	static final  String senha2 = "mainSona";
	
	//Inicialização de 2 Donos
	Dono dono1 = new Dono("Premius", "032543654-69", "06385954521", true);
	Dono dono2 = new Dono("Ney Tam Premium", "021420634-42", "1196664269", false);
	
	//Inicialização de 4 Animais aleatorios
	Animal ani1 = new Gato("Rey", dono1, Sexo.FEMEA, 5);
	Animal ani2 = new Gato("Luke", dono2, Sexo.MACHO, 12);
	Animal ani3 = new Cachorro("RafaCanina", dono2, Sexo.FEMEA, 15);
	Animal ani4 = new Cachorro("LittleJohn", dono1, Sexo.MACHO, 6);
	
	
	static Scanner scan = new Scanner(System.in);

	static Integer login = 0;
	
	public static void main(String[] args) {
		
		while (!login()) { //Loop de Login
		}
		
		if (login == 1) { //MENU COMPLETO
			System.out.println("");
			System.out.println("----------------");
			System.out.println("Menu para AnotheRafael");
			System.out.println("----------------");
			System.out.println("Digite 1 para Abrir Menu de Listas");
			System.out.println("Digite 2 para Abrir Menu de Adições");
			System.out.println("Digite 3 para Abrir Menu de Exclusão");
			System.out.println("Digite 4 para Abrir Menu de Alterações");
			System.out.println("Digite 5 para Sair");			
			System.out.println("----------------");
			System.out.println("");
		} else { //MENU MINIMALIZADO
			System.out.println("");
			System.out.println("----------------");
			System.out.println("Menu para Caiocbm");
			System.out.println("----------------");
			System.out.println("Digite 1 para Abrir Menu de Listas");
			System.out.println("Digite 5 para Sair");			
			System.out.println("----------------");
			System.out.println("");

		}
		
	}
	
	//METODOS
	
	public static Boolean login() {
		System.out.print("Digite o usuário: ");
		String usuario = scan.next();
		System.out.print("Digite a senha: ");
		String senha = scan.next();
		
		if (usuario.equals(usuario1) && senha.equals(senha1)) {
			System.out.println("Login autorizado!");
			login = 1;
			return true;
		} else if (usuario.equals(usuario2) && senha.equals(senha2)) {
			System.out.println("Login autorizado!");
			login = 2;
			return true;
		} 
		System.out.println("Login não autorizado.");
		return false;
	}
}
