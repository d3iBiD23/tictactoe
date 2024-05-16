import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        // Inicia la partida amb el torn 1, és a dir, el nostre torn
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

    // RETORNAR BOOL PARA COMPROVAR SI S'HA POGUT FICAR FITXA O NO
    public boolean jugar(short fila, short columna) {
        // Si fila està entre 0 i taulell.length
        // Si columna està entre 0 i taulell.length
        // Passem a col·locar la fitxa.

        if (fila >= 0 && fila < taulell.length && columna >= 0 && columna < taulell[fila].length){
            // Comprovar si la primera casella es buida
            if (taulell[fila][columna] == '·'){
                taulell[fila][columna] = (torn == 1) ? 'X' : 'O';
                torn = (torn == 1 ) ? (short) 2: (short) 1;
                return true; // jugada exitosa
            }
        }
        return false; // Casella ja ocupada
    }

    // Nou mètode per saber si és empat
    public boolean isEmpat(){
        for (char[] fila : taulell) {
            for (char cel : fila) {
                if (cel == '·') {
                    return false;
                }
            }
        }
        return true;
    }
    public void desarPartida(){
        try {
            // Crear directori "savedgames" si no existeix
            File directori = new File("savedgames");
            if (!directori.exists()){
                directori.mkdir();
            }
            // Crear nom d'arxiu amb la data actual
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String nomFitxer = dateFormat.format(new Date());

            // Escriure l'estat del joc en l'arxiu
            FileWriter writer = new FileWriter("savedgames/" + nomFitxer);
            writer.write(torn + "\n"); // Desar el torn del jugador
            for (char[] fila : taulell){
                for (char cel : fila){
                    writer.write(cel);
                }
                writer.write("\n");
            }
            writer.close();

        }catch (IOException e){
            System.out.println("Error al desar partida");
        }
    }
    public boolean carregarPartida(String nomFitxer){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("savedgames/" + nomFitxer));
            torn = Short.parseShort(reader.readLine());
            taulell = new char[3][3]; // Iniciem el taulell abans de carregar les dades

            for (int i = 0; i < 3; i++){
                String fila = reader.readLine();
                for (int j = 0; j < 3; j++){
                    taulell[i][j] = fila.charAt(j);
                }
            }
            reader.close();
            return true;

        }catch (IOException e){
            System.out.println("Error al carregar partida");
            return false;
        }
    }

    public void llistarPartides(){
        File directori = new File("savedgames");
        String[] fitxers = directori.list();
        if (fitxers != null && fitxers.length > 0) {
            System.out.println("Partides guardades:");
            for (int i = 0; i < fitxers.length; i++) {
                System.out.println((i + 1) + ") " + fitxers[i]);
            }
        } else {
            System.out.println("No hi ha partides guardades.");
        }
    }
}