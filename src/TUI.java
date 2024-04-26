import jdk.jshell.spi.ExecutionControl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI {
    private Scanner sc;

    public short mostrar_menu() {
        sc = new Scanner(System.in);
        short opcio_seleccionada;

        System.out.println("TIC-TAC-TOE");
        System.out.println("-------------");
        System.out.println("1) Nova Partida");
        System.out.println("2) Carregar Partida");
        System.out.println("3) Configuració");
        System.out.println("4) Sortir");

        System.out.println("Escull una opció: ");

        while (true) {

            try {
                opcio_seleccionada = sc.nextShort();

                switch (opcio_seleccionada) {
                    case 1:
                        System.out.println("Has escollit: Nova Partida.");
                        mostrar_menu();
                    case 2:
                        System.out.println("Has escollit: Carregar Partida.");
                        mostrar_menu();
                    case 3:
                        System.out.println("Has escollit: Configuració.");
                        mostrar_menu();
                    case 4:
                        System.out.println("Has escollit: Sortir.");
                        System.exit(0);
                    default:
                        System.out.println("Opció no vàlida, torna a intentar.");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Opció no vàlida, torna a intentar.");
                mostrar_menu();
            }
        }
    }
    public void mostrarTaulell(char[][] taulell, short turn) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }
    public short[][] recollirJugada() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }
    public short fiDePartida(short guanyador) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }
}
