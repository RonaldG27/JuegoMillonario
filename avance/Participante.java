package avance;

public class Participante {

	private int matricula;
	private String nombre;
	private String correo;

	public Participante(int matricula, String nombre, String correo) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.correo = correo;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}

	@Override
	public String toString() {
		return "Participante [matricula=" + matricula + ", nombre=" + nombre + ", correo=" + correo + "]";
	}

}
