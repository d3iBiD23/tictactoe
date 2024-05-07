import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JocTest {

    // Comprovar que el tablero se genera limpio (nadie ha jugado)
    @Test
    void testNovaPartida_taulell() {
        Joc joc = new Joc();
        joc.novaPartida();

        char[][] taulellNet = {
                {'·','·','·'},
                {'·','·','·'},
                {'·','·','·'}
        };
        Assertions.assertArrayEquals(taulellNet,joc.getTaulell());
    }

    // Comprovar que es el turno 1
    @Test
    void testNovaPartida_torn() {
        Joc joc = new Joc();
        joc.novaPartida();

        Assertions.assertEquals(1, joc.getTorn());
    }

    @Test
    void testJugadaGuanyadora() {

    }

    @Test
    void jugar_torn1() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short) 3,(short) 3);

        char[][] taulell_torn1 = {
                {'X','·','·'},
                {'·','·','·'},
                {'·','·','·'}
        };

        Assertions.assertArrayEquals(taulell_torn1, joc.getTaulell());
        Assertions.assertEquals(1, joc.getTorn());
    }

    @Test
    void jugar_torn2() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short) 3,(short) 3);

        char[][] taulell_torn2 = {
                {'O','·','·'},
                {'·','·','·'},
                {'·','·','·'}
        };

        Assertions.assertArrayEquals(taulell_torn2, joc.getTaulell());
        Assertions.assertEquals(1, joc.getTorn());
    }
}
