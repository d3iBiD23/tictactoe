import jdk.jshell.spi.ExecutionControl;
import java.util.InputMismatchException;

public class Main {
    static Joc joc = new Joc();
    static TUI tui = new TUI();

    public static void main(String[] args) {

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
            } catch (ExecutionControl.NotImplementedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void novaPartida()  {
        joc.novaPartida();
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
