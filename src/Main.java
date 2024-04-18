import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("TIC-TAC-TOE \n");
            System.out.println("------------- \n");
            System.out.println("1) Nova Partida");
            System.out.println("2) Carregar Partida");
            System.out.println("3) Configuració");
            System.out.println("4) Sortir");

            System.out.println("Escull una opció: ");
            try {
                int opcio_seleccionada = sc.nextInt();

                switch (opcio_seleccionada) {
                    case 1:
                        System.out.println("Has escollit: Nova partida");
                        break;
                    case 2:
                        System.out.println("Has escollit: Carregar Partida");
                        break;
                    case 3:
                        System.out.println("Has escollit: Configuració");
                        break;
                    case 4:
                        System.out.println("Has escollit: Sortir");
                        salir = true; // Sortir del bucle
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
    }
}
