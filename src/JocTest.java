import org.junit.jupiter.api.Assertions;

public class JocTest {

    // Comprovar que el tablero se genera limpio (nadie ha jugado)
    @org.junit.jupiter.api.Test
    void testNovaPartida_taulell() {
        Joc joc = new Joc();
        char[][] taulellNet = {
                {'·','·','·'},
                {'·','·','·'},
                {'·','·','·'}
        };
        Assertions.assertArrayEquals(taulellNet,joc.getTaulell());
    }

    // Comprovar que es el turno 1
    @org.junit.jupiter.api.Test
    void testNovaPartida_torn() {
        Joc joc = new Joc();
        Assertions.assertEquals(1, joc.getTorn());
    }



    @org.junit.jupiter.api.Test
    void testJugadaGuanyadora() {

    }

    @org.junit.jupiter.api.Test
    void jugar() {
        Joc joc = new Joc();

        char[][] taulell = joc.getTaulell();

        assett array equals()
        /*
        Comprovem que es posa una fitxa qualsevol a la primera casella,
        tenint en compte que està buit.
         */

        // no bucles asseerton

        Assertions.assertEquals('x', taulell[0][0]);

        Assertions.assertEquals('o', taulell[0][0]);

    }
}
