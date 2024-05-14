import jdk.jshell.spi.ExecutionControl;

import java.sql.SQLOutput;
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

    public short[] recollirJugada(Joc joc) {
        short fila = -1; // Inicialitza fila amb un valor per defecte, en aquest cas -1.
        short columna = -1; // Inicialitza columna amb un valor per defecte, en aquest cas -1.
        boolean jugadaExitosa = false;

        while (!jugadaExitosa){
            try {
                System.out.println("Introdueix la fila (0, 1, 2): ");
                fila = sc.nextShort();
                System.out.println("Introdueix la columna (0, 1, 2): ");
                columna = sc.nextShort();

                jugadaExitosa = joc.jugar(fila,columna);

                if (!jugadaExitosa){
                    System.out.println("La casella ja està ocupada. Si us plau, torna a intentar-ho.");
                }
            }catch (InputMismatchException ex){
                sc.next(); // Netejar entrada no vàlida
                System.out.println("Entrada invàlida, si us plau, torna a intentar-ho.");
            }
        }
        return new short[]{fila,columna};
    }

    public void fiDePartida(short guanyador) {
        System.out.println("El jugador " + (guanyador == 1 ? '1' : '2') + " ha guanyat!");
    }

    public short mostrarMenuConfig() {
        sc = new Scanner(System.in);

        System.out.println("CONFIGURACIÓ");
        System.out.println("-------------");
        System.out.println("La mida predeterminada del taulell és 3");
        System.out.println(" ");
        System.out.println("1) Cambiar mida taulell");
        System.out.println("2) Tornar Enrere");
        System.out.println(" ");
        System.out.println("Escull una opció: ");

        try {
            return sc.nextShort();
        }catch (InputMismatchException ex){
            sc.next();  // netejar entrada no vàlida
            return -1;
        }
    }

    public short MenuMidaTaulell() {
        sc = new Scanner(System.in);

        System.out.println("Escull la mida del taulell: (Min 3 - Max 10)");
        System.out.println("---------------------");
        System.out.println("Escull una mida: ");
        try {
            short opcion = sc.nextShort();
            if (opcion < 3 || opcion > 10){
                System.out.println("Mida introduida no valida. Prova amb un altre");
            }else{
                System.out.println("Mida cambiada correctement! La mida actual és " + opcion);
                return opcion;
            }
        }catch (InputMismatchException ex){
            sc.next();  // netejar entrada no vàlida
            return -1;
        }
        return 0;
    }
}
