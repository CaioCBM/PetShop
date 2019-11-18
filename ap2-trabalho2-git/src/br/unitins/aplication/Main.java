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
 * Classe Main, onde tudo será executado.
 *
 * AÇÕES: 1. Login de dois possíveis usuários. 2. Adicionar animais. 3. Excluir
 * animais. 4. Imprimir animais. 5. Alterar animais.
 * 
 * @author Rafael e Caio
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

//		REGISTROS PRÉ-PROGRAMADOS.
		Dono d1 = new Dono("Rafael", "111", "984054066", true);
		Dono d2 = new Dono("Lisa", "222", "981783422", true);
		Dono d3 = new Dono("Caio", "333", "999756844", false);

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

//		INSTÂNCIA DA LISTA.
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

//		MENU (Anotherafael = 1, Caiocbm = 2)
		int opcao = 0;
		
		if (Main.login == 1) {

			while (opcao != 4) {

				Collections.sort(listAnimais);
				System.out.println("");
				System.out.println("Menu para " + usuario1);
				System.out.println("");
				System.out.println("1 - Menu de Deletar");
				System.out.println("2 - Menu de Alteração");
				System.out.println("3 - Menu de Impressões");
				System.out.println("4 - Sair");
				System.out.print("Escolha: ");
				opcao = scan.nextInt();
				System.out.println("");

				switch (opcao) {

				case 1:

					Main.imprimirAnimais(listAnimais);
					System.out.println("");
					System.out.println(".: Removendo um animal :.");
					System.out.print("Escolha o id: ");
					Main.deletarAnimal(listAnimais, scan.nextInt());
					opcao = 0;
					break;

				case 2:

					Main.imprimirAnimais(listAnimais);
					System.out.println("");
					System.out.println(".: Alterando um animal :.");
					System.out.println("Escolha o ID do Animal que busca mudar: ");
					Main.alterarAnimal(listAnimais, scan.nextInt());
					opcao = 0;
					break;
				
				case 3:

					int opcaoImpressao = 0;
					while (opcaoImpressao != 6) {

						System.out.println("1 - Animais, 2 - Donos, 3 - Donos Premium, 4 - Cachorros, 5 - Gatos, 6 - Sair");
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
							
							listAnimais.sort((new Comparator<Animal>() {
								@Override
								public int compare(Animal animal, Animal outroAnimal) {
									return animal.getDono().getNome().compareTo(outroAnimal.getDono().getNome());
								}
							}));
							Main.imprimirDonosPremium(listAnimais);
							Collections.sort(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;
							
						case 4:

							Main.imprimirCachorros(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;

						case 5:

							Main.imprimirGatos(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;
							
						case 6:

							System.out.println(".:AVISO: Saindo da Impressão :.");
							break;

						default:

							System.out.println("AVISO: Não existe essa opção");
							opcaoImpressao = 0;
							break;
						}
					}
					break;

				case 4:

					System.out.println("AVISO: Até mais, " + usuario1 + ".");
					break;

				default:
					Main.recado();

				}
			}

		} else if (Main.login == 2) {
			while (opcao != 4) {

				Collections.sort(listAnimais);
				System.out.println("");
				System.out.println("Menu para " + usuario2);
				System.out.println("");
				System.out.println("1 - Menu de Adições");
				System.out.println("2 - Menu de Alteração");
				System.out.println("3 - Menu de Impressões");
				System.out.println("4 - Sair");
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

					Main.imprimirAnimais(listAnimais);
					System.out.println("");
					System.out.println(".: Alterando um animal :.");
					System.out.println("Escolha o ID do Animal que busca mudar: ");
					Main.alterarAnimal(listAnimais, scan.nextInt());
					opcao = 0;
					break;

				case 3:

					int opcaoImpressao = 0;
					while (opcaoImpressao != 6) {

						System.out.println("1 - Animais, 2 - Donos, 3 - Donos Premium, 4 - Cachorros, 5 - Gatos, 6 - Sair");
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
							
							listAnimais.sort((new Comparator<Animal>() {
								@Override
								public int compare(Animal animal, Animal outroAnimal) {
									return animal.getDono().getNome().compareTo(outroAnimal.getDono().getNome());
								}
							}));
							Main.imprimirDonosPremium(listAnimais);
							Collections.sort(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;
							
						case 4:

							Main.imprimirCachorros(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;

						case 5:

							Main.imprimirGatos(listAnimais);
							System.out.println("");
							opcaoImpressao = 0;
							break;
							
						case 6:

							System.out.println(".:AVISO: Saindo da Impressão :.");
							break;

						default:

							System.out.println("AVISO: Não existe essa opção");
							opcaoImpressao = 0;
							break;
						}
					}
					break;

				case 4:

					System.out.println("AVISO: Até mais, " + usuario2 + ".");
					break;

				default:
					Main.recado();
				}
			}

		}

	}

	/**
	 *	Método que realiza o login do sistema.
	 *	
	 *	@author Rafael e Caio        
	 *	@return boolean
	 */

	public static Boolean login() {
		System.out.print("Digite o usuário: ");
		String usuario = scan.next();
		System.out.print("Digite a senha: ");
		String senha = scan.next();

		if (usuario.equals(usuario1) && senha.equals(senha1)) {
			System.out.println("AVISO: Login autorizado!");
			Main.login = 1;
			return true;
		} else if (usuario.equals(usuario2) && senha.equals(senha2)) {
			System.out.println("AVISO: Login autorizado!");
			Main.login = 2;
			return true;
		}
		System.out.println("AVISO: Login não autorizado.");
		return false;
	}

	/**
	 * Método utilizado para criar um objeto do tipo Dono.
	 * 
	 * @author Rafael e Caio
	 * @return Dono.
	 */

	public static Dono adicionarDono() {
		System.out.println("Nome, CPF e Telefone do dono:");
		Dono dono = new Dono(scan.next(), scan.next(), scan.next());
		
		System.out.println("Premium?");
		String resposta = scan.next();
		
		for (int i = 0; i != 1;) {
			if (resposta.equals("Sim") || resposta.equals("sim")) {
				dono.setPremium(true);
				i = 1;
			} else if (resposta.equals("Não") || resposta.equals("não")) {
				dono.setPremium(false);
				i = 1;
			} else {
				Main.recado();
				System.out.println("");
			}
		}
		
		return dono;
	}

	/**
	 *	Método para criar um animal a partir do Scanner.
	 *
	 *	@author Rafael e Caio
	 *	@param lista
	 *	@param tipo
	 *	@return Animal.
	 */

	public static Animal adicionarAnimal(List<Animal> lista, int tipo) {

		/**
		 * Verificação de qual objeto criar: Cachorro (1) ou Gato (2).
		 */
		if (tipo == 1) {
			System.out.println("Nome e idade do animal: ");
			Animal animal = new Cachorro(scan.next(), scan.nextInt(), Main.adicionarDono());

			/**
			 * Conferir se o CPF informado pelo usuário já existe em outro objeto. Caso tanto o nome quanto o cpf forem iguais
			 * não impedirá de criar, mas se o nome distinguir, será pedido para alterar.
			 */
			lista.forEach(animal2 -> {

				if (animal2.getDono().getCpf().equals(animal.getDono().getCpf())
						&& !(animal2.getDono().getNome().equals(animal.getDono().getNome()))) {
					System.out.println("AVISO: Já existe um Dono com esse CPF. (" + animal2.getDono().getNome() + ")");
					System.out.print("Novo CPF: ");
					animal.getDono().setCpf(scan.next());
				}
			});

			/**
			 * Definir se o animal é macho ou fêmea. É necessário que o usuário siga com afinco a instrução, pois se usar maiusculo ou
			 * esquecer o acento, dará como errado.
			 */
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
			System.out.println("Nome e idade do animal: ");
			Animal animal = new Gato(scan.next(), scan.nextInt(), Main.adicionarDono());

			lista.forEach(animal2 -> {

				if (animal2.getDono().getCpf().equals(animal.getDono().getCpf())
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
			System.out.println("AVISO: Gato adicionado com sucesso.");
			return animal;
		}
	}

	/**
	 *	Método para remover um animal da lista.
	 *         
	 *	@author Rafael e Caio
	 *	@param lista
	 *	@param indice
	 */

	public static void deletarAnimal(List<Animal> lista, int indice) {
		
		/**
		 * Confere se ocorrerá uma IndexOutOfBoundsException (Index inexistente). E caso ocorra, lancará um aviso.
		 */
		try {
			lista.remove(indice - 1);
			System.out.println("AVISO: Foi removido com sucesso.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("AVISO: Não existe animal registrado nesse endereço.");
		}
	}

	/**
	 *	Método para a impressão de todos animais.
	 *	
	 *	@author Rafael e Caio
	 *	@param lista
	 */

	public static void imprimirAnimais(List<Animal> lista) {
		System.out.println("Quantidade de Animais: " + lista.stream().count() + "\n");
		lista.forEach(animal -> {
			animal.imprimirAnimais();
		});
	}

	/**
	 *	Método para a impressão dos Donos e seus respectivos animais.
	 *	
	 *	@author Rafael e Caio
	 *	@param lista
	 */
	
	public static void imprimirDonos(List<Animal> lista) {
		lista.forEach(animal -> animal.imprimirDonos());
	}
	
	/**
	 * Método para impessão de somente Donos que são premium.
	 * 
	 * @author Rafael e Caio
	 * @param lista
	 */
	
	public static void imprimirDonosPremium(List<Animal> lista) {
		lista.forEach(animal -> animal.imprimirDonosPremium());
	}

	/**
	 *	Método para a impressão de somente Cachorros
	 *	
	 *	@author Rafael e Caio
	 *	@param lista
	 */
	
	public static void imprimirCachorros(List<Animal> lista) {
		System.out.println(".: Cachorros :.");
		lista.forEach(animal -> {
			if (animal.getClass().getSimpleName().equals("Cachorro")) {
				animal.imprimirCachorros();
			}
		});
	}

	/**
	 *	Método para a impressão de somente Gatos.
	 *	
	 *	@author Rafael e Caio
	 *	@param lista
	 */
	
	public static void imprimirGatos(List<Animal> lista) {
		System.out.println(".: Gatos :.");
		lista.forEach(animal -> {
			if (animal.getClass().getSimpleName().equals("Gato")) {
				animal.imprimirCachorros();
			}
		});
	}
	
	/**
	 * Método para alterar informações contidas na lista de animais.
	 * 
	 * @author Rafael e Caio
	 * @param lista
	 * @param indice
	 */

	public static void alterarAnimal(List<Animal> lista, int indice) {
		
		lista.get(indice);
		System.out.println("Qual dos fatores do componente " + indice + " você gostaria de mudar:");
		System.out.println("1 - NomeDoPet, 2 - Sexo, 3 - DonoNome, 4 - DonoCPF, 5 - DonoTelefone, 6 - DonoPremium");
		System.out.print("Escolha: ");
		int opcao = scan.nextInt();

		switch (opcao) {

		case 1:

			System.out.println("Qual o novo nome do Pet?");
			String nomeTemp = scan.next();
			System.out.println(
					"Voce entao quer trocar o nome " + lista.get(indice - 1).getNome() + " por " + nomeTemp + "?");
			System.out.println("1 - Sim, 2 - Não");
			System.out.print("Escolha: ");
			opcao = scan.nextInt();

			switch (opcao) {

			case 1:

				lista.get(indice - 1).setNome(nomeTemp);
				System.out.println("Alterado Nome do Pet com sucesso!");
				opcao = 0;
				break;

			case 2:

				System.out.println("Operação Cancelada com Sucesso");
				opcao = 0;
				break;
			}
			opcao = 0;
			break;

		case 2:

			System.out.println("Definir o Sexo como 1 - MACHO ou 2 - FEMEA");
			System.out.print("Escolha: ");
			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				lista.get(indice - 1).setSexo(Sexo.MACHO);
				System.out.println("Alterado Sexo do Pet para MACHO com sucesso!");
				opcao = 0;
				break;

			case 2:
				lista.get(indice - 1).setSexo(Sexo.FEMEA);
				System.out.println("Alterado Sexo do Pet para FEMEA com sucesso!");
				opcao = 0;
				break;

			}
			opcao = 0;
			break;

		case 3:

			System.out.println("Qual o novo nome do Dono?");
			nomeTemp = scan.next();
			System.out.println("Voce entao quer trocar o nome " + lista.get(indice - 1).getDono().getNome() + " por "
					+ nomeTemp + "?");
			System.out.println("1 - Sim, 2 - Não");
			System.out.print("Escolha: ");
			opcao = scan.nextInt();

			switch (opcao) {

			case 1:

				lista.get(indice - 1).getDono().setNome(nomeTemp);
				;
				System.out.println("Alterado Nome do Dono com sucesso!");
				opcao = 0;
				break;

			case 2:

				System.out.println("Operação Cancelada com Sucesso");
				opcao = 0;
				break;
			}
			opcao = 0;
			break;

		case 4:

			System.out.println("Qual o novo CPF do Dono?");
			nomeTemp = scan.next();
			System.out.println("Voce entao quer trocar o CPF " + lista.get(indice - 1).getDono().getCpf() + " por "
					+ nomeTemp + "?");
			System.out.println("1 - Sim, 2 - Não");
			System.out.print("Escolha: ");
			opcao = scan.nextInt();

			switch (opcao) {

			case 1:

				lista.get(indice - 1).getDono().setCpf(nomeTemp);
				System.out.println("Alterado CPF do Dono com sucesso!");
				opcao = 0;
				break;

			case 2:

				System.out.println("Operação Cancelada com Sucesso");
				opcao = 0;
				break;
			}
			opcao = 0;
			break;

		case 5:

			System.out.println("Qual o novo telefone do Dono?");
			nomeTemp = scan.next();
			System.out.println("Voce entao quer trocar o telefone " + lista.get(indice - 1).getDono().getTelefone()
					+ " por " + nomeTemp + "?");
			System.out.println("1 - Sim, 2 - Não");
			System.out.print("Escolha: ");
			opcao = scan.nextInt();

			switch (opcao) {

			case 1:

				lista.get(indice - 1).getDono().setTelefone(nomeTemp);
				System.out.println("Alterado CPF do Dono com sucesso!");
				opcao = 0;
				break;

			case 2:

				System.out.println("Operação Cancelada com Sucesso");
				opcao = 0;
				break;
			}
			opcao = 0;
			break;

		case 6:

			System.out.println("Qual o novo Status do Dono?");
			System.out.println("1 - Premium, 2 - Não Premium, 3 - Cancelar");
			opcao = scan.nextInt();

			switch (opcao) {

			case 1:

				lista.get(indice - 1).getDono().setPremium(true);
				System.out.println("Alterado Status de Conta do Dono para PREMIUM com sucesso!");
				opcao = 0;
				break;

			case 2:

				lista.get(indice - 1).getDono().setPremium(false);
				System.out.println("Alterado Status de Conta do Dono para NÃO PREMIUM com sucesso!");
				opcao = 0;
				break;

			case 3:

				System.out.println("Operação Cancelada com Sucesso!");
				opcao = 0;
				break;
			}
			opcao = 0;
			break;

		default:

			Main.recado();
			opcao = 0;
			break;
		}
	}
	
	/**
	 * Método apenas para a impressão de mensagem de alerta.
	 */

	public static void recado() {
		System.out.println("AVISO: Por favor, siga as instruções.");
	}
}
