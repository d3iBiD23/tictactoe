import jdk.jshell.spi.ExecutionControl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI {
    private Scanner sc;

    //mostra el menu d'opcions
    public short mostrarMenu() {
        sc = new Scanner(System.in);

        System.out.println("TIC-TAC-TOE");
        System.out.println("-------------");
        System.out.println("1) Nova Partida");
        System.out.println("2) Carregar Partida");
        System.out.println("3) Configuració");
        System.out.println("4) Sortir");

        System.out.println("Escull una opció: ");

        try {
            return sc.nextShort();
        }catch (InputMismatchException ex){
            sc.next();  // netejar entrada no vàlida
            return -1;
        }
    }

    // mostra el taulell maequetat amb delimitadors de casella
    public void mostrarTaulell(char[][] taulell, short torn) {
        System.out.println("Torn del jugador " + (torn == 1 ? '1' : '2'));

        for (int i = 0; i < taulell.length; i++) {
            // Mostrar cada fila del tablero
            for (int j = 0; j < taulell[i].length; j++) {
                System.out.print(taulell[i][j]);

                // Si no es la última columna, añadir una barra vertical
                if (j < taulell[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            // Nueva línea después de cada fila
            System.out.println();

            // Si no es la última fila, añadir una línea divisoria
            if (i < taulell.length - 1) {
                System.out.println("---------");
            }
        }
    }
    public short[][] recollirJugada() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }
    public short fiDePartida(short guanyador) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }
}
