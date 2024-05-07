import jdk.jshell.spi.ExecutionControl;

public class Joc {
    private char[][] taulell;
    private short torn;

    public char[][] getTaulell() {
        return taulell;
    }

    public short getTorn() {
        return torn;
    }

    public void novaPartida(){
       // genera un taulell de 3x3 amb punts
       taulell = new char[3][3];
       for (int i = 0; i < taulell.length; i++){
           for (int j = 0; j < taulell.length; j++){
               taulell [i][j] = '·';
           }
       }
        // Inicia la partida amb el torn 1, es a dir, el nostre torn
       torn = 1;
    }

    public boolean jugadaGuanyadora(short fila, short columna) throws ExecutionControl.NotImplementedException{
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }

    public void jugar(short fila, short columna) throws ExecutionControl.NotImplementedException{
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }
}