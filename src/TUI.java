import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI {
    private Scanner sc;

    public short mostrar_menu() {
        sc = new Scanner(System.in);
        boolean sortir = false;
        short opcio_seleccionada = 0;

        System.out.println("TIC-TAC-TOE");
        System.out.println("-------------");
        System.out.println("1) Nova Partida");
        System.out.println("2) Carregar Partida");
        System.out.println("3) Configuració");
        System.out.println("4) Sortir");

        System.out.println("Escull una opció: ");

        while (!sortir) {

            try {
                opcio_seleccionada = sc.nextShort();

                switch (opcio_seleccionada) {
                    case 1:
                        System.out.println("Has escollit: Nova Partida");
                        break;
                    case 2:
                        break;
                    case 3:
                        op3();
                        break;
                    case 4:
                        sortir();

                        sortir = true;
                        break;
                    default:
                        System.out.println("Opció no vàlida. Torna a intentar.");
                        break;
                }
            } catch (InputMismatchException ex) {
                sc.nextLine();
            }
        }
        sc.close();
        return (short)opcio_seleccionada;
    }
}
