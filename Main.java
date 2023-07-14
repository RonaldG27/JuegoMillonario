package avance;

public class Main {

	public static void main(String[] args) {
		Configuracion juego = new Configuracion();

		// while (true) {
		// juego.menuPregunta();
		// }
		boolean validar = true;
		while (validar) {
			validar = juego.menuTermino();
		}

	}

}
