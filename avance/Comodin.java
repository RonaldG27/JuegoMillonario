package avance;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Comodin {
	private int cantidadDisponible;
	private int cantidadUtilizada;
	private Pregunta pregunta;
	private Participante companero;
	
	Scanner sc = new Scanner(System.in);
	
	public void eliminarRespuestasIncorrectas(Pregunta pregunta) {
		String respuestaInco1 = pregunta.getRespuestaInco1();
		String respuestaInco2 = pregunta.getRespuestaInco2();
		String respuestaInco3 = pregunta.getRespuestaInco2();

		Random random = new Random();
        int respuestasEliminadas = 0;
        
        while (respuestasEliminadas < 2 ) {
            int indiceAleatorio = random.nextInt(4);

            if (!pregunta.getRespuestaCorrecta().equalsIgnoreCase(pregunta.getRespuestas().get(indiceAleatorio))) {
                pregunta.getRespuestas().remove(indiceAleatorio);
                respuestasEliminadas++;
            }
        }
        System.out.println("Respuestas incorrectas eliminadas.");
	}
	public void consultarCompanero() {
        System.out.println("El compañero " + companero.getNombre());
        
       }
    public String consultarRespuestaSalon() {
        int maxConteo = 0;
        String respuestaMasComun = "";

        for (String respuesta : respuestasIncorrectas) {
            int conteo = Collections.frequency(respuestas, respuesta);

            if (conteo > maxConteo) {
                maxConteo = conteo;
                respuestaMasComun = respuesta;
            }
        }

        return respuestaMasComun;
    }

    public Comodin(int cantidadDisponible) {
        this.cantidadDisponible = 3;
        this.cantidadUtilizada = 0;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }
    
    

    public boolean usarComodin() {
    	if (cantidadDisponible > 0) {
    		cantidadDisponible--;

            System.out.println("\nComodines disponibles: " + cantidadDisponible);
            System.out.println("Comodines: 50/50 (1), Consulta al compañero (2), consulta al salon (3)");

            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el número del comodín a utilizar: ");
            int comodin = sc.nextInt();
            sc.nextLine();

            switch (comodin) {
                case 1:
                    eliminarRespuestasIncorrectas(pregunta);
                    break;
                case 2:
                	consultarCompanero();
                    break;
                case 3:
                	consultarRespuestaSalon();
                default:
                    System.out.println("Comodín inválido.");
                    break;
            }
        } else {
            System.out.println("No tienes comodines disponibles.");
       
        if (cantidadDisponible > cantidadUtilizada) {
            cantidadUtilizada++;
            System.out.println("¡Has utilizado un comodín!");
            return true;
        }
}
