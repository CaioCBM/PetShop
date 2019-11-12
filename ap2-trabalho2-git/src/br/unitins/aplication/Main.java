package br.unitins.aplication;

import java.util.Scanner;

public class Main {

	static final  String usuario1 = "Anotherafael";
	static final  String senha1 = "Gabs2";
	static final  String usuario2 = "Caiocbm";
	static final  String senha2 = "mainSona";
	
	static Scanner scan = new Scanner(System.in);

	static Integer login = 0;
	
	public static void main(String[] args) {
		
		while (!login()) {
		}
		
		if (login == 1) {
			System.out.println("Menu para Anotherafael");
		} else {
			System.out.println("Menu para Caiocbm");
		}
		
	}
	
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
