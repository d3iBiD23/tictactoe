import org.junit.jupiter.api.Assertions;

public class JocTest {

    @org.junit.jupiter.api.Test
    void testNovaPartida() {
        // Instanciar joc
        Joc joc = new Joc();

        char[][] taulellNet = joc.getTaulell();
        // Comprovar que el tablero se genera limpio (nadie ha jugado)
        for (int i = 0; i < joc.getTaulell().length; i++){
            for (int j = 0; j < joc.getTaulell().length; j++){
                Assertions.assertEquals('·', taulellNet[i][j]);
            }
        }

        // Comprovar que es el turno 1
        Assertions.assertEquals(1, joc.getTorn());
    }

    @org.junit.jupiter.api.Test
    void testJugadaGuanyadora() {

    }

    @org.junit.jupiter.api.Test
    void jugar() {

    }
}
