package br.unitins.aplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
 *         Deletar Animal (Completo) 4. Alterar Animal
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

		Dono d1 = new Dono("Rafael", "111");
		Dono d2 = new Dono("Lisa", "222");
		Dono d3 = new Dono("Caio", "333");
		
		Animal a1 = new Cachorro("Jonh", d1, Sexo.MACHO, 4);
		Animal a2 = new Cachorro("Amanda", d1, Sexo.FEMEA, 2);
		Animal a3 = new Gato("Nana", d2, Sexo.FEMEA, 5);
		Animal a4 = new Cachorro("Dudu", d3, Sexo.MACHO, 1);
		Animal a5 = new Gato("Suzie", d1, Sexo.FEMEA, 2);
		Animal a6 = new Gato("Felps", d1, Sexo.MACHO, 2);
		Animal a7 = new Gato("Rey", d3, Sexo.FEMEA, 2);
		Animal a8 = new Gato("Luke", d3, Sexo.MACHO, 1);
		Animal a9 = new Gato("Jessie", d2, Sexo.FEMEA, 1);
		Animal a10 = new Gato("Pitchula", d2, Sexo.FEMEA, 6);

		List<Animal> listAnimais = new ArrayList<Animal>();

		listAnimais.add(a1);
		listAnimais.add(a2);
		listAnimais.add(a3);
		listAnimais.add(a4);
		listAnimais.add(a5);
		listAnimais.add(a6);
		listAnimais.add(a7);
		listAnimais.add(a8);
		listAnimais.add(a9);
		listAnimais.add(a10);

//		LOGIN
		while (!login()) {
		}

//		MENU
		int opcao = 0;
		if (login == 1) {

			while (opcao != 5) {

				Collections.sort(listAnimais);
				System.out.println("");
				System.out.println("Menu para Anotherafael");
				System.out.println("");
				System.out.println("1 - Menu de Adições");
				System.out.println("2 - Menu de Impressões");
				System.out.println("3 - Menu de Deletar");
				System.out.println("4 - Menu de Alteração");
				System.out.println("5 - Sair");
				System.out.print("Escolha: ");
				opcao = scan.nextInt();
				System.out.println("");

				switch (opcao) {
				case 1:

					System.out.println(".: Adicionando um animal :.");
					System.out.println("1 - Cachorro, 2 - Gato");
					System.out.print("Escolha: ");
					opcao = scan.nextInt();
					Animal animal = Main.adicionarAnimal(listAnimais, opcao);

					listAnimais.add(animal);
					opcao = 0;
					break;

				case 2:

					int opcaoImpressao = 0;
					while (opcaoImpressao != 5) {

						System.out.println("1 - Animais, 2 - Donos, 3 - Cachorros, 4 - Gatos, 5 - Sair");
						System.out.print("Escolha: ");
						opcaoImpressao = scan.nextInt();
						System.out.println("");

						switch (opcaoImpressao) {
						case 1:

							Main.imprimirAnimais(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;

						case 2:

							listAnimais.sort((new Comparator<Animal>() {
								@Override
								public int compare(Animal animal, Animal outroAnimal) {
									return animal.getDono().getNome().compareTo(outroAnimal.getDono().getNome());
								}
							}));
							Main.imprimirDonos(listAnimais);
							Collections.sort(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;

						case 3:

							Main.imprimirCachorros(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;

						case 4:

							Main.imprimirGatos(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;

						case 5:

							System.out.println(".:AVISO: Saindo da Impressão :.");
							break;

						default:

							System.out.println("AVISO: Não existe essa opção");
							opcaoImpressao = 0;
							break;
						}
					}
					break;

				case 3:

					Main.imprimirAnimais(listAnimais);
					System.out.println("");
					System.out.println(".: Removendo um animal :.");
					System.out.print("Escolha o id: ");
					Main.deletarAnimal(listAnimais, scan.nextInt());
					opcao = 0;
					break;

				case 4:

					Main.imprimirAnimais(listAnimais);
					System.out.println("");
					System.out.println(".: Alterando um animal :.");
					System.out.println("Escolha o ID do Animal que busca mudar: ");
					Main.alterarAnimal(listAnimais, scan.nextInt());
					opcao = 0;
					break;

				case 5:

					System.out.println("AVISO: Até mais, Anotherafael.");
					break;
				}
			}

		} else if (login == 2) {

		}

	}

	// METODOS

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
			System.out.println("AVISO: Login autorizado!");
			login = 1;
			return true;
		} else if (usuario.equals(usuario2) && senha.equals(senha2)) {
			System.out.println("AVISO: Login autorizado!");
			login = 2;
			return true;
		}
		System.out.println("AVISO: Login não autorizado.");
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
		System.out.println("Nome e CPF do dono:");
		Dono dono = new Dono(scan.next(), scan.next());
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

	public static Animal adicionarAnimal(List<Animal> lista, int tipo) {

		if (tipo == 1) {
			System.out.println("Nome do animal: ");
			Animal animal = new Cachorro(scan.next(), Main.adicionarDono());

			lista.forEach(animal2 -> {

				if (	animal2.getDono().getCpf().equals(animal.getDono().getCpf())
						&& !(animal2.getDono().getNome().equals(animal.getDono().getNome()))) {
					System.out.println("AVISO: Já existe um Dono com esse CPF. (" + animal2.getDono().getNome() + ")");
					System.out.print("Novo CPF: ");
					animal.getDono().setCpf(scan.next());
				}
			});

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
			System.out.println("AVISO: Cachorro adicionado com sucesso.");
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
			System.out.println("AVISO: Gato adicionado com sucesso.");
			return animal;
		}
	}

	/**
	 * @author Rafael
	 * 
	 *         Método para remover um animal da lista.
	 * 
	 *         1. Lidar com a exception gerada ao colocar um index inexistente.
	 *         (Completo)
	 */

	public static void deletarAnimal(List<Animal> lista, int indice) {
		try {
			lista.remove(indice - 1);
			System.out.println("AVISO: Foi removido com sucesso.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("AVISO: Não existe animal registrado nesse endereço.");
		}
	}

	/**
	 * @author Rafael
	 * 
	 *         Método para a impressão de todos animais.
	 */

	public static void imprimirAnimais(List<Animal> lista) {
		System.out.println("Quantidade de Animais: " + lista.stream().count() + "\n");
		lista.forEach(animal -> {
			animal.imprimirAnimais();
		});
	}

	public static void imprimirDonos(List<Animal> lista) {
		lista.forEach(animal -> animal.imprimirDonos());
	}

	public static void imprimirCachorros(List<Animal> lista) {
		System.out.println(".: Cachorros :.");
		lista.forEach(animal -> {
			if (animal.getClass().getSimpleName().equals("Cachorro")) {
				animal.imprimirCachorros();
			}
		});
	}

	public static void imprimirGatos(List<Animal> lista) {
		System.out.println(".: Gatos :.");
		lista.forEach(animal -> {
			if (animal.getClass().getSimpleName().equals("Gato")) {
				animal.imprimirCachorros();
			}
		});
	}

	/**
	 * @author Caio
	 * 
	 *         "Update". Alterando um componente.
	 * 
	 *         OBS: 1. Exception quando não tem o indice na lista. (Completo) 2.
	 *         Exception quando digita valor diferente de número quando usa
	 *         scan.nextInt(). 3.
	 *
	 *
	 */

	public static void alterarAnimal(List<Animal> lista, int indice) {
		try {
			lista.get(indice);
			System.out.println("Qual dos fatores do componente " + indice + " você gostaria de mudar:");
			System.out.println("1 - NomeDoPet, 2 - Sexo, 3 - Dono");
			int opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Qual o novo nome do Pet?");
				lista.get(indice - 1).setNome(scan.next());
				System.out.println("Alterado Nome do Pet com sucesso!");
				opcao = 0;

				break;

			case 2:
				System.out.println("Definir o Sexo como 1 - MACHO ou 2 - FEMEA");
				scan.nextInt();

				switch (opcao) {
				case 1:
					lista.get(indice - 1).setSexo(Sexo.MACHO);
					System.out.println("Alterado Sexo do Pet para Macho com sucesso!");
					opcao = 0;

					break;
				case 2:
					lista.get(indice - 1).setSexo(Sexo.FEMEA);
					System.out.println("Alterado Sexo do Pet para Fêmea com sucesso!");
					opcao = 0;

					break;
				}
				opcao = 0;

				break;
			case 3:
				System.out.println("Qual o nome do Dono?");
				lista.get(indice - 1).setDono(Main.adicionarDono());
				opcao = 0;

				break;
			default:
				System.out.println("AVISO: Escolha uma Opção de 1 a 3, por favor, babaca");
				System.out.println("By Rafael");
				break;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("AVISO: Não existe animal registrado nesse endereço.");
		}
	}

	/**
	 * @author Rafael
	 * 
	 *         Método apenas para imprimir uma frase.
	 */

	public static void recado() {
		System.out.println("AVISO: Por favor, siga as instruções.");
	}
}
