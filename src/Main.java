import jdk.jshell.spi.ExecutionControl;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();

        // CREAR SPRINT, CREAR USERSTORY,
        // LEER ENUNCIADO Y METERLO AL USERSTORY.
        //
        //
        // - VER EN QUE PUNTO ESTAMOS
        //      PARA PODER SABER TASQUES (ATOMIQUES, TREBALL EN PARALEL)
        // LUNES 29/04 TIENE QUE ESTAR ACABADO
        //
        // TENER EN CUENTA TASQUES EN GIT Y TAIGA (DETALLADOS)
        //
        // MAIN HECHO

        tui.mostrarMenu();

        while (tui.mostrarMenu() != 4) {
            try {
                switch (tui.mostrarMenu()) {
                    case 1:
                        novaPartida();
                        tui.mostrarMenu();
                    case 2:
                        carregarPartida();
                        tui.mostrarMenu();
                    case 3:
                        configuracio();
                        tui.mostrarMenu();
                    case 4:
                        sortir();
                        break;
                    default:
                        System.out.println("Opció no vàlida. Torna a intentar.");
                        break;
                }
            } catch (InputMismatchException ex) {
                tui.mostrarMenu();
            }
        }
    }
    private static void novaPartida() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Metode no creat");

    }
    private static void carregarPartida() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Metode no creat");
    }
    private static void configuracio() throws ExecutionControl.NotImplementedException{
        throw new ExecutionControl.NotImplementedException("Metode no creat");
    }
    private static void sortir() throws ExecutionControl.NotImplementedException  {
        throw new ExecutionControl.NotImplementedException("Metode no creat");
    }
}
