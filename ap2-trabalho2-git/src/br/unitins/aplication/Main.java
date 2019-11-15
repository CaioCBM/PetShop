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

/**
 * @author Rafael
 *
 *         1. Adicionar Animal (Completo) 2. Imprimir Animal (Completo) 3.
 *         Deletar Animal 4. Alterar Animal
 *
 */

public class Main {

//	USUÁRIOS
	static final String usuario1 = "Anotherafael";
	static final String senha1 = "Gabs2";
	static final String usuario2 = "Caiocbm";
	static final String senha2 = "mainSona";

	static Scanner scan = new Scanner(System.in);

	static Integer login = 0;

	public static void main(String[] args) {

		Animal a1 = new Cachorro("Jonh", new Dono("Rafael"), Sexo.MACHO, 4);
		Animal a2 = new Cachorro("Amanda", new Dono("Rafael"), Sexo.FEMEA, 2);
		Animal a3 = new Gato("Nana", new Dono("Lisa"), Sexo.FEMEA, 5);
		Animal a4 = new Cachorro("Dudu", new Dono("Lisa"), Sexo.MACHO, 1);
		Animal a5 = new Gato("Suzie", new Dono("Rafael"), Sexo.FEMEA, 2);
		Animal a6 = new Gato("Felps", new Dono("Rafael"), Sexo.MACHO, 2);
		Animal a7 = new Gato("Rey", new Dono("Caio"), Sexo.FEMEA, 2);
		Animal a8 = new Gato("Luke", new Dono("Caio"), Sexo.MACHO, 1);
		Animal a9 = new Gato("Jessie", new Dono("Bento"), Sexo.FEMEA, 1);
		Animal a10 = new Gato("Pitchula", new Dono("Lisa"), Sexo.FEMEA, 6);

		List<Animal> animais = new ArrayList<Animal>();

		animais.add(a1);
		animais.add(a2);
		animais.add(a3);
		animais.add(a4);
		animais.add(a5);
		animais.add(a6);
		animais.add(a7);
		animais.add(a8);
		animais.add(a9);
		animais.add(a10);

//		LOGIN
		while (!login()) {
		}

//		MENU
		int opcao = 0;
		if (login == 1) {

			while (opcao != 3) {
				
				Collections.sort(animais);
				System.out.println("");
				System.out.println("Menu para Anotherafael");
				System.out.println("");
				System.out.println("1 - Menu de Adições");
				System.out.println("2 - Menu de Impressões");
				System.out.println("3 - Sair");
				System.out.print("Escolha: ");
				opcao = scan.nextInt();
				System.out.println("");

				switch (opcao) {
				case 1:

					System.out.println(".: Adicionando um animal :.");
					System.out.println("1 - Cachorro, 2 - Gato");
					System.out.print("Escolha: ");
					animais.add(Main.adicionarAnimal(scan.nextInt()));
					break;

				case 2:

					Main.imprimirAnimais(animais);
					break;

				case 3:

					System.out.println("Até mais, Anotherafael.");
					break;

				case 4:

					System.out.println(".: Removendo um animal :.");
					System.out.print("Escolha o id: ");
					Main.deletarAnimal(animais, scan.nextInt());
					break;
				}

			}

		} else if (login == 2) {

		}

	}

	/**
	 * @author Rafael
	 * 
	 *         Método que realiza o login do sistema.
	 */

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

	/**
	 * @author Rafael
	 * 
	 *         Método para criar um Dono a partir do Scanner.
	 * 
	 *         1. Evitar que seja registrado número no nome do Dono. 2. Limitar a
	 *         quantidade digitos (12) no cpf. 3. Evitar que seja registrado letra
	 *         no número de telefone. 4. Adicionar um método para adicionar premium.
	 * 
	 */

	public static Dono adicionarDono() {
		Dono dono = new Dono(scan.next());
		return dono;
	}

	/**
	 * @author Rafael
	 * 
	 *         Método para criar um animal a partir do Scanner.
	 * 
	 *         1. Evitar números no nome do animal e do dono. 2. Evitar outros
	 *         valores além de macho e fêmea. (COMPLETO) 3. Jogar uma exception
	 *         quando for instanciar a idade do Animal para caso o usuário digitar
	 *         algo que não seja um número inteiro.
	 * 
	 */

	public static Animal adicionarAnimal(int tipo) {

		if (tipo == 1) {
			System.out.println("Nome do animal e do dono");
			Animal animal = new Cachorro(scan.next(), Main.adicionarDono());

			for (int i = 0; i != 1;) {

				System.out.println("Sexo: macho ou fêmea?");
				String resposta = scan.next();

				if (resposta.equals("macho")) {
					animal.setSexo(Sexo.MACHO);
					i = 1;
				} else if (resposta.equals("fêmea")) {
					animal.setSexo(Sexo.FEMEA);
					i = 1;
				} else {
					System.out.println("");
					Main.recado();
				}
			}
			System.out.println("");
			System.out.println("Cachorro adicionado com sucesso.");
			return animal;
		} else {
			System.out.println("Nome do animal e do dono");
			Animal animal = new Gato(scan.next(), Main.adicionarDono());

			for (int i = 0; i != 1;) {

				System.out.println("Sexo: macho ou fêmea?");
				String resposta = scan.next();

				if (resposta.equals("macho")) {
					animal.setSexo(Sexo.MACHO);
					i = 1;
				} else if (resposta.equals("fêmea")) {
					animal.setSexo(Sexo.FEMEA);
					i = 1;
				} else {
					System.out.println("");
					Main.recado();
				}
			}
			System.out.println("");
			System.out.println("Gato adicionado com sucesso.");
			return animal;
		}
	}

	/**
	 * @author Rafael
	 * 
	 * Método para remover um animal da lista.
	 * 
	 * 1. Lidar com a exception gerada ao colocar um index inexistente.
	 */
	
	public static void deletarAnimal(List<Animal> lista, int indice) {
		try {
			lista.remove(indice - 1);
			System.out.println("Foi removido com sucesso.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Não existe animal registrado nesse endereço.");
		}
	}

	/**
	 * @author Rafael
	 * 
	 *         Método para a impressão de todos animais com a base de ordenação
	 *         definida nas classes Cachorro e Gato (compareTo).
	 */

	public static void imprimirAnimais(List<Animal> lista) {
		lista.forEach(animal -> System.out.println(animal));
	}

	/**
	 * @author Rafael
	 * 
	 *         Método apenas para imprimir uma frase.
	 */

	public static void recado() {
		System.out.println("Por favor, siga as instruções.");
	}
}
