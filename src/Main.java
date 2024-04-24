import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();

        tui.mostrar_menu(); // retorna opció

        // CREAR SPRINT, CREAR USERSTORY,
        // LEER ENUNCIADO Y METERLO AL USERSTORY.
        //
        //
        // - VER EN QUE PUNTO ESTAMOS
        //      PARA PODER SABER TASQUES (ATOMIQUES, TREBALL EN PARALEL)
        // LUNES 29/04 TIENE QUE ESTAR ACABADO
        //
        // TENER EN CUENTA TASQUES EN GIT Y TAIGA (DETALLADOS)

        while (tui.mostrar_menu() != 4) {

            try {
                switch (tui.mostrar_menu()) {
                    case 1:
                        novaPartida();
                        break;
                    case 2:
                        carregarPartida();
                        break;
                    case 3:
                        configuracio();
                        break;
                    case 4:
                        sortir();
                        break;
                    default:
                        System.out.println("Opció no vàlida. Torna a intentar.");
                        break;
                }
            } catch (InputMismatchException ex) {
                tui.mostrar_menu();
            }
        }
    }
    private static void novaPartida(){

    }
    private static void carregarPartida(){

    }
    private static void configuracio(){

    }
    private static void sortir(){

    }
}
