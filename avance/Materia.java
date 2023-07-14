package avance;

import java.util.Scanner;

public class Materia {
	private String codigo;
	private String nombre;
	private int numNiveles;
	Scanner sc = new Scanner(System.in);

	public Materia() {
		System.out.println("Ingrese el codigo: ");
		this.codigo = sc.nextLine();
		System.out.println("Ingrese el nombre: ");
		this.nombre = sc.nextLine();
		System.out.println("Ingrese el numero de niveles: ");
		this.numNiveles = sc.nextInt();
	}

	public Materia(String c, String n, int nm) {
		this.codigo = c;
		this.nombre = n;
		this.numNiveles = nm;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumNiveles() {
		return numNiveles;
	}

	public void setNumNiveles(int numNiveles) {
		this.numNiveles = numNiveles;
	}

}
