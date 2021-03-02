package es.ieslavereda.Chess.tools;

import java.util.Scanner;

public class Input {

	public static String getString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int getInt(String msg) {
		int salida = 0;
		boolean error = true;

		do {
			try {
				salida = Integer.parseInt(getString(msg));
				error = false;
			} catch (Exception e) {
				System.out.println("Debe introducir un numero.");
			}
		} while (error);

		return salida;

	}
}
