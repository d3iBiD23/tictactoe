import jdk.jshell.spi.ExecutionControl;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    static Joc joc = new Joc();
    static TUI tui = new TUI();

    public static void main(String[] args) throws IOException {
        while (true) {
            int opcio = tui.mostrarMenu();
            switch (opcio) {
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
        }
    }

    // COMIENZA NUEVA PARTIDA Y DETECTA SI ACABA LA PARTIDA (HAY QUE METERLO EN LA CLASE JOC)
    private static void novaPartida()  {
        joc.novaPartida();
        boolean partidaAcabada = false;

        while (!partidaAcabada){
            tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
            short[] jugada = tui.recollirJugada(joc);

            joc.jugar(jugada[0], jugada[1]);

            if (joc.jugadaGuanyadora(jugada[0],jugada[1])){
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                tui.fiDePartida(joc.getTorn() == 1 ? (short) 2 : (short) 1);
                partidaAcabada = true;
            } else if (isEmpat()) {
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                partidaAcabada = true;
            }
        }
    }

    // Nou mètode per saber si es empat
    private static boolean isEmpat(){
        char[][] taulell = joc.getTaulell();
        for (char[] fila : taulell) {
            for (char cel : fila) {
                if (cel == '·') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void carregarPartida() {
        // Añadir lógica para cargar una partida guardada
        System.out.println("Funcionalitat no implementada.");
    }

    private static void configuracio() throws IOException {
        boolean sortirConfig = false;
        while (!sortirConfig) {
            int opcio = tui.mostrarMenuConfig();
            switch (opcio) {
                case 1:
                joc.archiuMidaTaulell(tui.MenuMidaTaulell());
                break;
                case 2:
                    sortirConfig = true;
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna a intentar.");
                    break;
            }
        }
    }

    private static void sortir() {
        System.out.println("Gracias per jugar. ¡Fins ara!");
        System.exit(0);
    }
}
