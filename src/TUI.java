import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI {
    private Scanner sc;

    public short mostrar_menu() {
        sc = new Scanner(System.in);
        short opcio_seleccionada = 0;

        System.out.println("TIC-TAC-TOE");
        System.out.println("-------------");
        System.out.println("1) Nova Partida");
        System.out.println("2) Carregar Partida");
        System.out.println("3) Configuració");
        System.out.println("4) Sortir");

        System.out.println("Escull una opció: ");

        while (true) {
            try {
                opcio_seleccionada = sc.nextShort();

                switch (opcio_seleccionada) {
                    case 1:
                        System.out.println("Has escollit: Nova Partida.");
                        mostrar_menu();
                    case 2:
                        System.out.println("Has escollit: Carregar Partida.");
                        mostrar_menu();
                    case 3:
                        System.out.println("Has escollit: Configuració.");
                        mostrar_menu();
                    case 4:
                        System.out.println("Has escollit: Sortir.");
                        System. exit(0);
                        break;
                    default:
                        System.out.println("Opció no vàlida. Torna a intentar.");
                        mostrar_menu();
                }
            } catch (InputMismatchException ex) {
                mostrar_menu();
            }
        }
        return opcio_seleccionada;
    }
}
