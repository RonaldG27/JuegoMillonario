package avance;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {

	private ArrayList<Pregunta> posiblesPreguntas;

	Scanner sc = new Scanner(System.in);

	public void menu() {
		System.out.println("MENU MODIFICAR TERMINO:" + "\n1. Visualizar preguntas" + "\n2. Agregar preguntas"
				+ "\n3. Eliminar preguntas\n");
		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			visualizarPregunta();
			break;
		case 2:
			System.out.println("-- INGRESE LA PREGUNTA A AGREGAR --");
			Pregunta pregunta1 = new Pregunta();
			agregarPregunta(pregunta1);
			break;
		case 3:

			// Pregunta pregunta11 = new Pregunta();
			eliminarPregunta();

		}
	}

	public void visualizarPregunta() {
		if (posiblesPreguntas != null) {
			int i = 1;
			for (Pregunta pregunta : posiblesPreguntas) {
				System.out.println(i + ".- " + pregunta);
				i += 1;
			}
		} else {
			System.out.println("No hay preguntas");
		}

	}

	public void agregarPregunta(Pregunta pregunta) {
		if (posiblesPreguntas == null) {
			posiblesPreguntas = new ArrayList<>();
		}
		System.out.println(pregunta);
		posiblesPreguntas.add(pregunta);

	}

	public void eliminarPregunta() {
		visualizarPregunta();

		int size = posiblesPreguntas.size();

		System.out.println("Cual de las estas " + size + " preguntas sea eliminar, ingrese el numero: ");
		int index = sc.nextInt();
		sc.nextLine();

		posiblesPreguntas.remove(index - 1);

	}

}
