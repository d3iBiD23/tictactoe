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

    public void novaPartida() throws ExecutionControl.NotImplementedException{
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }

    public boolean jugadaGuanyadora(short fila, short columna) throws ExecutionControl.NotImplementedException{
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }

    public void jugar(short fila, short columna) throws ExecutionControl.NotImplementedException{
        throw new ExecutionControl.NotImplementedException("Mètode no creat");
    }
}
