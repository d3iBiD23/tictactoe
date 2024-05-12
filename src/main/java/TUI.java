import jdk.jshell.spi.ExecutionControl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI {
    private Scanner sc;

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
