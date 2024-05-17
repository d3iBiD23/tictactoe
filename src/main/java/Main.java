import java.io.*;
import java.io.IOException;

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
                    tui.missatgeNoValid();
                    break;
            }
        }
    }

    // COMENÇA NOVA PARTIDA I DETECTA SI ACABA LA PARTIDA
    private static void novaPartida() throws IOException {
        joc.novaPartida();
        boolean partidaAcabada = false;

        while (!partidaAcabada){
            tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
            short[] jugada = tui.recollirJugada(joc);

            if (jugada[0] == -1 && jugada[1] == -1){
                joc.desarPartida();
                partidaAcabada = true;
                continue;
            }

            joc.jugar(jugada[0], jugada[1]);

            if (joc.jugadaGuanyadora(jugada[0],jugada[1])){
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                tui.fiDePartida(joc.getTorn() == 1 ? (short) 2 : (short) 1);
                partidaAcabada = true;
            } else if (joc.isEmpat()) {
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                tui.missatgeEmpat();
                partidaAcabada = true;
            }
        }
    }
    private static void carregarPartida() {
        joc.llistarPartides();
        String[] fitxers = (new File("savedgames").list());

        if (fitxers != null && fitxers.length > 0){
            short opcio = tui.demanarOpcioCarregarPartida();
            if (opcio > 0 && opcio <= fitxers.length){
                if (joc.carregarPartida(fitxers[opcio - 1])){
                    tui.missatgeDesat();
                    continuarPartida();
                    return;
                }
            }
        }
        tui.missatgeNoValid();
    }
    private static void continuarPartida(){
        boolean partidaAcabada = false;

        while (!partidaAcabada){
            tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
            short[] jugada = tui.recollirJugada(joc);

            if (jugada[0] == -1 && jugada[1] == -1){
                joc.desarPartida();
                tui.missatgeDesat();
                partidaAcabada = true;
                continue;
            }

            joc.jugar(jugada[0], jugada[1]);

            if (joc.jugadaGuanyadora(jugada[0],jugada[1])){
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                tui.fiDePartida(joc.getTorn() == 1 ? (short)2 : (short) 1);
                partidaAcabada = true;
            } else if (joc.isEmpat()) {
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                tui.missatgeEmpat();
                partidaAcabada = true;
            }
        }
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
                    tui.missatgeNoValid();
                    break;
            }
        }
    }

    private static void sortir() {
        tui.comiat();
        System.exit(0);
    }
}
