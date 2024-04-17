import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("TIC-TAC-TOE \n");
            System.out.println("------------- \n");
            System.out.println("1) Nova Partida");
            System.out.println("2) Carregar Partida");
            System.out.println("3) Configuració");
            System.out.println("4) Sortir");

            System.out.println("Escull una opció:");
            int opció_seleccionada = sc.nextInt();

            switch(opció_seleccionada) {
                case 1:
                    System.out.println("Nova partida");
                    break;
                case 2:
                    System.out.println("Carregar Partida");
                    break;
                case 3:
                    System.out.println("Configuració");
                    break;
                case 4:
                    System.out.println("Sortir");
                    break;

            }
        }
    }
}