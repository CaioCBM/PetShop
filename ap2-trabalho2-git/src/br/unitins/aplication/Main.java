package br.unitins.aplication;

import br.unitins.model.Animal;
import br.unitins.model.Cachorro;
import br.unitins.model.Dono;
import br.unitins.model.Sexo;

public class Main {

	public static void main(String[] args) {
		
		Animal animal = new Cachorro ("Jonh", Sexo.MACHO, new Dono("Rafael"));
		
		System.out.println(animal);
	}
}
