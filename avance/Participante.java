package avance;

public class Participante {

	int matricula;
	String nombre;
	String correo;

	public Participante(int matricula, String nombre, String correo) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Participante [matricula=" + matricula + ", nombre=" + nombre + ", correo=" + correo + "]";
	}

}
