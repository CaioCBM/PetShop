package br.unitins.aplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.unitins.model.Animal;
import br.unitins.model.Cachorro;
import br.unitins.model.Dono;
import br.unitins.model.Gato;
import br.unitins.model.Sexo;

public class Main {
	// Inicialização de 2 Usuarios aleatorios
	static final String usuario1 = "Anotherafael";
	static final String senha1 = "Gabs2";
	static final String usuario2 = "Caiocbm";
	static final String senha2 = "mainSona";

	static Scanner scan = new Scanner(System.in);

	static Integer login = 0;

	public static void main(String[] args) {

//		Inicialização de 2 Donos
//		Dono dono1 = new Dono("Premius", "032543654-69", "06385954521", true);
//		Dono dono2 = new Dono("Ney Tam Premium", "021420634-42", "1196664269", false);
//		
//		Inicialização de 4 Animais aleatorios
//		Animal ani1 = new Gato("Rey", dono1, Sexo.FEMEA, 5);
//		Animal ani2 = new Gato("Luke", dono2, Sexo.MACHO, 12);
//		Animal ani3 = new Cachorro("RafaCanina", dono2, Sexo.FEMEA, 15);
//		Animal ani4 = new Cachorro("LittleJohn", dono1, Sexo.MACHO, 6);

		List<Animal> animais = new ArrayList<Animal>();

		while (!login()) { // Loop de Login
		}

		int opcao = 0;
		if (login == 1) { // MENU COMPLETO
			while (opcao != 4) {
				System.out.println("");
				System.out.println("Menu para AnotheRafael");
				System.out.println("");
				System.out.println("1 - Menu de Adições");
				System.out.println("2- Menu de Alterações");
				System.out.println("3 - Menu de Impressões");
				System.out.println("4 - Sair");
				System.out.print("Escolha: ");
				opcao = scan.nextInt();
				System.out.println("");
				
				if (opcao == 1) {
					System.out.println("1 - Cachorro, 2 - Gato");
					System.out.print("Escolha: ");
					int tipo = scan.nextInt();
					animais.add(Main.adicionarAnimal(tipo));
				} else if (opcao == 3) {
					Main.imprimirAnimais(animais);
				}
			}
		} else if (login == 2) {
			System.out.println("");
			System.out.println("----------------");
			System.out.println("Menu para Caiocbm");
			System.out.println("----------------");
			System.out.println("Digite 1 para Abrir Menu de Exclusão");
			System.out.println("Digite 2 para Abrir Menu de Impressões");
			System.out.println("Digite 3 para Sair");
			System.out.println("----------------");
			System.out.println("");

			opcao = scan.nextInt();

			if (opcao == 1) {
				// MENU DE IMPRESSÕES
				/*
				 * 1. Imprimir Donos 1.1. Imprimir Donos Premium = TRUE 1.2. imprimir Donos
				 * Premium = FALSE
				 * 
				 * 2. Imprimir Animais 2.1. Imprimir só Gatos 2.2. Imprimir só Cachorros
				 */
			} else {
				System.out.println("");
				System.out.println("----------------");
				System.out.println("Menu para Caiocbm");
				System.out.println("----------------");
				login = 5;
			}

		}

	}


	// METODOS

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

	public static Dono adicionarDono() {
		Dono dono = new Dono(scan.next());
		return dono;
	}

	public static Animal adicionarAnimal(int tipo) {

		if (tipo == 1) {
			System.out.println("Nome do animal e do dono");
			Animal animal = new Cachorro(scan.next(), Main.adicionarDono());
			System.out.println("Sexo: macho ou femea?");
			String resposta = scan.next();
			if (resposta.equals("macho") || resposta.equals("Macho"))
				animal.setSexo(Sexo.MACHO);
			else
				animal.setSexo(Sexo.FEMEA);
			System.out.println("Foi adicionado um cachorro");
			return animal;
		} else {
			System.out.println("Nome do animal e do dono");
			Animal animal = new Gato(scan.next(), Main.adicionarDono());
			System.out.println("Sexo: macho ou femea?");
			String resposta = scan.next();
			if (resposta.equals("macho") || resposta.equals("Macho"))
				animal.setSexo(Sexo.MACHO);
			else
				animal.setSexo(Sexo.FEMEA);
			System.out.println("Foi adicionado um gato");
			return animal;
		}
	}
	
	public static void imprimirAnimais (List<Animal> lista) {
		Collections.sort(lista);
		lista.forEach(animal -> System.out.println(animal));
	}
}
