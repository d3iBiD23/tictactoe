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

        tui.mostrar_menu();

        while (tui.mostrar_menu() != 4) {
            try {
                switch (tui.mostrar_menu()) {
                    case 1:
                        nova_partida();
                        tui.mostrar_menu();
                    case 2:
                        carregar_partida();
                        tui.mostrar_menu();
                    case 3:
                        configuracio();
                        tui.mostrar_menu();
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
    private static void nova_partida(){

    }
    private static void carregar_partida(){

    }
    private static void configuracio(){

    }
    private static void sortir(){

    }
}
