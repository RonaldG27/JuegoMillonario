import java.util.ArrayList;
import java.util.Scanner;


public class Reporte{
  private ArrayList<Juego> juegos;

    public Reporte() {
        juegos = new ArrayList<>();
    }

    public void agregarJuego(Juego juego) {
        juegos.add(juego);
    }


    public void mostrarReporte() {
        // Solicitar el término académico, código de materia y paralelo
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el término académico: ");
        Termino termino = buscarTermino(sc.nextLine());
        if (termino == null) {
            System.out.println("Término académico no encontrado.");
            return;
        }

        System.out.print("Ingrese el código de materia: ");
        String codigoMateria = sc.nextLine();
        Materia materia = buscarMateria(codigoMateria);
        if (materia == null) {
            System.out.println("Código de materia no encontrado.");
            return;
        }

        System.out.print("Ingrese el número de paralelo: ");
        int numParalelo = sc.nextInt();
        Paralelo paralelo = buscarParalelo(materia, termino, numParalelo);
        if (paralelo == null) {
            System.out.println("Paralelo no encontrado.");
            return;
        }

        // Filtrar y mostrar la información de los juegos
        System.out.println("\n----- Reporte de Juegos -----\n");
        for (Juego juego : juegos) {
            if (juego.getTermino().equals(termino) && juego.getMateria().equals(materia) && juego.getParalelo().equals(paralelo)) {
                System.out.println("Participante: " + juego.getParticipante());
                System.out.println("Nivel máximo alcanzado: " + juego.getNivelMaximoAlcanzado());
                System.out.println("Tiempo: " + juego.getTiempo());
                System.out.println("Cantidad de preguntas contestadas: " + juego.getPreguntasContestadas());
                System.out.println("Comodines utilizados: " + juego.getComodinesUtilizados()); //falta 
                System.out.println("-------------------------------------\n");
            }
        }
    }
//metodos para hacer la busqueda dentro de las listas
    private Termino buscarTermino(String terminoAcademico) {
        for (Termino termino : Configuracion.lista_terminos) {
            if (termino.toString().equals(terminoAcademico)) {
                return termino;
            }
        }
        return null;
    }

    private Materia buscarMateria(String codigoMateria) {
        for (Materia materia : Configuracion.lista_materias) {
            if (materia.getCodigo().equals(codigoMateria)) {
                return materia;
            }
        }
        return null;
    }

    private Paralelo buscarParalelo(Materia materia, Termino termino, int numParalelo) {
        for (Paralelo paralelo : Configuracion.lista_paralelos) {
            if (paralelo.getMateria().equals(materia) && paralelo.getTermino().equals(termino) && paralelo.getNumParalelo() == numParalelo) {
                return paralelo;
            }
        }
        return null;
    }
}

