import jdk.jshell.spi.ExecutionControl;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Joc {
    private char[][] taulell;
    private short torn;


    public char[][] getTaulell() {
        return taulell;
    }

    public short getTorn() {
        return torn;
    }

    public boolean archiuMidaTaulell(short mida) throws IOException {
        FileWriter wrtTaulell = new FileWriter("config.txt");
        wrtTaulell.write(""+mida);
        wrtTaulell.close();
        return true;
    }

    public short llegirMidaTaulell() throws IOException {
        File config = new File("config.txt");
        Scanner sc = new Scanner(config);
        short valor = sc.nextShort();
        return valor;
    }

    public void novaPartida() throws IOException {
        short mida = llegirMidaTaulell();
       // genera un taulell de mida X mida amb punts
       taulell = new char[mida][mida];
       for (int i = 0; i < taulell.length; i++){
           for (int j = 0; j < taulell.length; j++){
               taulell [i][j] = '·';
           }
       }
        // Inicia la partida amb el torn 1, es a dir, el nostre torn
       torn = 1;
    }

    public boolean jugadaGuanyadora(short fila, short columna)  {
        char jugador = taulell[fila][columna];

        // Si la casella esta buida, no pot haver-hi victoria
        if (jugador == '·'){
            return false;
        }

        // Verificar victoria horitzontal
        boolean victoriaHoritzontal = true;
        for (int j = 0; j < 3; j++){
            if (taulell[fila][j] != jugador){
                victoriaHoritzontal = false;
                break;
            }
        }
        if (victoriaHoritzontal){
            return true;
        }

        // Verificar victoria vertical
        boolean victoriaVertical = true;
        for (int i = 0; i < 3; i++){
            if (taulell[i][columna] != jugador){
                victoriaVertical = false;
                break;
            }
        }
        if (victoriaVertical){
            return true;
        }

        // Verificar victoria diagonal
        boolean victoriaDiagonal = true;
        if (fila == columna){
            for (int i = 0; i < 3; i++){
                if (taulell[i][i] != jugador){
                    victoriaDiagonal = false;
                    break;
                }
            }
            if (victoriaDiagonal){
                return true;
            }
        }

        // Verificar victoria diagonal inversa
        boolean victoriaDiagonalInversa = true;
        if (fila + columna == 2) {
            for (int i = 0; i < 3; i++) {
                if (taulell[i][2 - i] != jugador) {
                    victoriaDiagonalInversa = false;
                    break;
                }
            }
            return victoriaDiagonalInversa;
        }

        return false;
    }

    // DEVOLVER BOOL PARA COMPROBAR SI SE HA PODIDO PONER FICHA O NO
    public boolean jugar(short fila, short columna) {

        // Comprobar si la primera casilla es buida
        if (taulell[fila][columna] == '·'){
            taulell[fila][columna] = (torn == 1) ? 'X' : 'O';
            torn = (torn == 1 ) ? (short) 2: (short) 1;
            return true; // jugada exitosa
        }
        return false; // Casella ja ocupada
    }

}