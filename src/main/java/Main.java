public class Main {
    static Joc joc = new Joc();
    static TUI tui = new TUI();

    public static void main(String[] args) {
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
            } else if (joc.isEmpat()) {
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                tui.missatgeEmpat();
                partidaAcabada = true;
            }
        }
    }

    private static void carregarPartida() {
        // Afegir lògica per carregar una partida guardada
        System.out.println("Funcionalitat no implementada.");
    }

    private static void configuracio() {
        // Afegir lògica para configurar el joc
        System.out.println("Funcionalitat no implementada.");
    }

    private static void sortir() {
        System.out.println("Gràcies per jugar. ¡Fins ara!");
        System.exit(0);
    }
}
