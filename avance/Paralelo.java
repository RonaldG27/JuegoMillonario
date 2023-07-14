package avance;

import java.util.ArrayList;

public class Paralelo {
	private Materia materia;
	private Termino termino;
	private int numParalelo;

	public Paralelo() {
		System.out.println("");
	}

	public Paralelo(Materia materia, Termino termino, int numParalelo, ArrayList<Participante> participantes) {
		this.materia = materia;
		this.termino = termino;
		this.numParalelo = numParalelo;
	}

	public Materia getMateria() {
		return materia;
	}

	public Termino getTermino() {
		return termino;
	}

	public int getNumParalelo() {
		return numParalelo;
	}

}
