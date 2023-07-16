package avance;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {
	
	private Materia materia;
	private Paralelo paralelo;
	private Termino termino;
	private Participante participante;
	private Participante companero;
	private Comodin comodin;
    private int preguntasPorNivel;
    private int nivelMaximoAlcanzado;
    private int preguntasContestadas;
    private String premio;
    private int preguntaActualIndex;
    private Configuracion configuracion;
    private ArrayList<Pregunta> preguntas;
    
    
    public Juego(Configuracion configuracion) {
        this.configuracion = configuracion;
    }
    
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    
    public void iniciarJuego() {
    	BienvenidaJuego();
    	mostrarPregunta();
    	
    }

    //seleciona materia, paralelo, estudiante y compañero
    public void BienvenidaJuego() {
    	
        System.out.println("¡Bienvenido al Nuevo juego!");
        
        configuracion.mostrarMateria();
        
        System.out.println("Seleccione la Materia: ");
        int indiceMateria = sc.nextInt();
        sc.nextLine();
        
        materia = configuracion.getLista_materias().get(indiceMateria - 1);
        preguntas = materia.getPreguntas();
        
        configuracion.mostrarParalelo();
        
        System.out.println("Seleccione el paralelo: ");
        int indiceParalelo = sc.nextInt();
        
        sc.nextLine();
        
        
        
        // Seleccionar o ingresar participante
        System.out.println("Ingrese el número de matrícula del participante (0 para seleccionar aleatoriamente): ");
        int matriculaParticipante = sc.nextInt();
   
        
        if (matriculaParticipante != 0) {
            participante = buscarPorMatricula(matriculaParticipante);
            if (companero== null) {
        		System.out.println("No se encontró al partipante con la matrícula ingresada. Se seleccionará uno aleatoriamente.");
        		participante = seleccionarAleatorio(); 
        		}
        }
        else {
            participante = seleccionarAleatorio();   
        }
        
        System.out.println("El participante seleccionado es: " + participante.getNombre());
        sc.nextLine();
        
        // Seleccionar compañero para comodin 50/50
        
        System.out.print("Ingresa el número de matrícula del compañero de apoyo(0 para seleccionar aleatoriamente): ");
        int matriculaCompanero = sc.nextInt();
        sc.nextLine();
        
        if (matriculaCompanero != 0) {
        	companero = buscarPorMatricula(matriculaCompanero);
        	if (companero== null) {
        		System.out.println("No se encontró al compañero con la matrícula ingresada. Se seleccionará uno aleatoriamente.");
        		companero = seleccionarAleatorio();
        	}
        }
        if (companero == null && matriculaCompanero == 0) {
        	companero = seleccionarAleatorio();
        }
      
        System.out.println("Compañero de apoyo: " + companero.getNombre());
        sc.nextLine();
        System.out.println("¡Que comience el juego!");
    }
    
        //mostrar preguntas y respuesta
    
    public void mostrarPregunta() {

        int nivelActual = 1;
        
        for (Pregunta pregunta : preguntas) {
        	
        	System.out.println("\n" + pregunta.getEnunciado());
        	
        	ArrayList<String> opciones = new ArrayList<>();
            opciones.add(pregunta.getRespuestaCorrecta());
            opciones.add(pregunta.getRespuestaInco1());
            opciones.add(pregunta.getRespuestaInco2());
            opciones.add(pregunta.getRespuestaInco3());
            
            // Mostrar las opciones de forma aleatoria
            for (int i = 0; i < 4; i++) {
                int indiceAleatorio = (int) (Math.random() * opciones.size());
                System.out.println((i + 1) + ". " + opciones.get(indiceAleatorio));
                opciones.remove(indiceAleatorio);
            }
            
            System.out.print("Seleccione la opción correcta : ");
            
            int opcionrespuesta = sc.nextInt();
            String respuestaCorrecta = pregunta.getRespuestaCorrecta();
            int preguntasCorrectas = 0;
            String respuestaSeleccionadaTexto = opciones.get(opcionrespuesta - 1);
            
            //si la repuesta es correcta sigue el juego si no finaliza
            
            if (respuestaSeleccionadaTexto .equals(respuestaCorrecta)) {
            	System.out.println("¡Correcto!"+"/n"+ "siguiente Prengunta");
                preguntasCorrectas++;
                
            } else {
            	System.out.println("¡Esto no fue correcto!"+"/n"+ "Intentar este juego de nuevo");
            	return;
            }
            //si contesta todo termina el juego   	
            if (preguntasContestadas == preguntas.size()) {
                System.out.println("¡Felicidades! Has respondido correctamente todas las preguntas del juego.");
                nivelMaximoAlcanzado = nivelActual;
                break;
                
            } else if(preguntasContestadas % preguntasPorNivel == 0) {
            	System.out.println("¡Has alcanzado el nivel " + nivelActual + "!");
                nivelActual++;
            }

            if (preguntasContestadas < preguntas.size()){
                System.out.print("Presiona enter para continuar...");
                sc.nextLine();
            }
        }

        if (nivelMaximoAlcanzado > 0) {
            System.out.println("Has alcanzado el nivel máximo: " + nivelMaximoAlcanzado);
            System.out.print("Ingresa el premio que has ganado: ");
            premio = sc.nextLine();
        }
     }
    
    
    
    public void mostrarSiguientePregunta() {
        if (preguntaActualIndex < preguntas.size()) {
            Pregunta preguntaActual = preguntas.get(preguntaActualIndex);
            System.out.println(preguntaActual);

            preguntaActualIndex++;
        } else {
            System.out.println("No hay más preguntas para mostrar");
        }
    }

    public Participante buscarPorMatricula(int matricula) {
    	
        for (Participante participante : configuracion.agregarEstudiantes()) {
            if (participante.getMatricula() == matricula) {
                return participante;
            }
        }
        return null;
    }
    
    public Participante seleccionarAleatorio(){
    	ArrayList<Participante> listaParticipantes = configuracion.agregarEstudiantes();
        int indiceAleatorio = (int) (Math.random() * listaParticipantes.size());
        return listaParticipantes.get(indiceAleatorio);
    }
    
    
}   
