package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		List<Animal> animais = new ArrayList<Animal>();

		int opcao = 0;
		while (opcao != 3) {
			System.out.println("1 - Cachorro, 2 - Gato, 3 - Impress�o");
			System.out.print("Escolha: ");
			opcao = scan.nextInt();
			if (opcao == 1) {
				System.out.print("Digite o nome: ");
				Animal animal = Principal.lerDadosAnimais(opcao);
				animais.add(animal);
				System.out.println("Foi adicionado um cachorro!");
			} else if (opcao == 2) {
				System.out.print("Digite o nome: ");
				Animal animal = Principal.lerDadosAnimais(opcao);
				animais.add(animal);
				System.out.println("Foi adicionado um gato!");
			}
		}
		Collections.sort(animais);

		opcao = 0;
		while (opcao != 4) {

			System.out.println("Imprima: 1 - Cachorro, 2 - Gato, 3 - Todos, 4 - Sair");
			System.out.print("Escolha: ");
			opcao = scan.nextInt();
			Principal.imprimir(animais, opcao);

			if (opcao == 4)
				System.out.println("Obrigado por usar nosso programa!");
		}
	}

	public static Scanner scan = new Scanner(System.in);

	public static Animal lerDadosAnimais(int opcao) {

		if (opcao == 1) {
			Animal animal = new Cachorro(scan.next());
			return animal;
		} else if (opcao == 2) {
			Animal animal = new Gato(scan.next());
			return animal;
		}
		return null;
	}

	/**
	 * M�todo utilizado para selecionar a impress�o.
	 * 
	 * @param animal                    = Lista de animais;
	 * @param tipo                      = Op��o de impress�o;
	 * @param animal.forEach(copyAnimal -> {...}) = M�todo utilizado para acessar
	 *                                  cada informa��o da lista animal;
	 */

	public static void imprimir(List<Animal> animal, int tipo) {

//		Aqui foi feita uma "List<Animal> animal" para receber como par�metro uma lista de animais. O atributo "copyAnimal", como o pr�prio nome diz: � uma 
//		c�pia que ser� utilizada somente no met�do forEach, serve para acessar cada informa��o dentro da List<Animal> animal.
		animal.forEach(copyAnimal -> {
			if (copyAnimal.getClass().getSimpleName().equals("Cachorro") && tipo == 1) {
				System.out.println(copyAnimal);
			} else if (copyAnimal.getClass().getSimpleName().equals("Gato") && tipo == 2) {
				System.out.println(copyAnimal);
			} else if (tipo == 3) {
				System.out.println(copyAnimal);
			}
		});
	}
}
