package main;

import java.util.Scanner;

public final class Main {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("JEU DU 8 AMERICAIN\nR�alis� par Florian Esslinger et Guillaume Rousselet\n");
		
		Partie.getInstance();
		Partie.getInstance().lancerPartie();
	}	
		
}
