import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    /*
        Partint d’un taulell en blanc
        Que la crida al mètode retorna “False” per a totes les posicions.
    */
    @ParameterizedTest
    @CsvSource({
                "0,0", "0,1", "0,2",
                "1,0", "1,1", "1,2",
                "2,0", "2,1", "2,2"})
    void testJugadaGuanyadora_taulell_net(short fila, short columna) {
        Joc joc = new Joc();
        joc.novaPartida();

        Assertions.assertFalse(joc.jugadaGuanyadora(fila,columna));
    }

    /*
        Partint d’un taulell que només té una casella ocupada.
        Que la crida al mètode retorna “False” per a totes les posicions.
    */
    @ParameterizedTest
    @CsvSource({
                "0,0", "0,1", "0,2",
                "1,0", "1,1", "1,2",
                "2,0", "2,1", "2,2"})
    void testJugadaGuanyadora_una_casella_ocupada(short fila, short columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short)0,(short)1); // J1

        Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }

    /*
        Partint d’un taulell on hi ha caselles ocupades,
        i una jugada a una casella faria guanyar al jugador 1.
        La crida al mètode retorna “True” només a la casella guanyadora.
    */
    @ParameterizedTest
    @CsvSource({
    /*
        JUGADES GUANYADORES (Jugador1)
    */
            "0,0,0,1,0,2",
//          "1,0,1,1,1,2", Aquestes jugades no es poden fer ja que al test es solapen.
            "2,0,2,1,2,2",
//          "0,0,1,0,2,0",
            "0,1,1,1,2,1",
//          "0,2,1,2,2,2",
            "0,0,1,1,2,2",
            "0,2,1,1,2,0"
    })
    void testJugadaGuanyadora_caselles_ocupades_j1(short jugada1Fila, short jugada1Col, short jugada2Fila, short jugada2Col, short jugadaGuanyadoraFila, short jugadaGuanyadoraCol) {
        Joc joc = new Joc();
        joc.novaPartida();

        joc.jugar(jugada1Fila, jugada1Col); // J1
        joc.jugar((short) 1, (short) 0); // J2
        joc.jugar(jugada2Fila, jugada2Col); // J1
        joc.jugar((short)1, (short) 2); // J2
        joc.jugar(jugadaGuanyadoraFila,jugadaGuanyadoraCol); // J1 Última jugada per guanyar

        Assertions.assertTrue(joc.jugadaGuanyadora(jugadaGuanyadoraFila, jugadaGuanyadoraCol)); // J1 ha de guanyar
    }

    /*
        Partint d’un taulell on hi ha caselles ocupades,
        i una jugada a una casella faria guanyar al jugador 2.
        La crida al mètode retorna “True” només a la casella guanyadora.
    */
    @ParameterizedTest
    @CsvSource({
    /*
        JUGADES GUANYADORES (Jugador2)
    */
            "0,0,0,1,0,2",
//          "1,0,1,1,1,2", Aquestes jugades no es poden fer ja que al test es solapen.
//          "2,0,2,1,2,2",
//          "0,0,1,0,2,0",
//          "0,1,1,1,2,1",
            "0,2,1,2,2,2",
            "0,0,1,1,2,2",
//          "0,2,1,1,2,0"
    })
    void testJugadaGuanyadora_caselles_ocupades_j2(short jugada1Fila, short jugada1Col, short jugada2Fila, short jugada2Col, short jugadaGuanyadoraFila, short jugadaGuanyadoraCol) {
        Joc joc = new Joc();
        joc.novaPartida();

        joc.jugar((short) 2, (short)0); // J1
        joc.jugar(jugada1Fila, jugada1Col); // J2

        joc.jugar((short) 1, (short)0); // J1
        joc.jugar(jugada2Fila, jugada2Col); // J2

        joc.jugar((short) 2, (short)1); // J1

        joc.jugar(jugadaGuanyadoraFila, jugadaGuanyadoraCol); //J2 Guanya

        Assertions.assertTrue(joc.jugadaGuanyadora(jugadaGuanyadoraFila,jugadaGuanyadoraCol));
    }

    @Test
    void jugar_torn1() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short) 0,(short) 0);

        char[][] taulell_torn1 = {
                {'X','·','·'},
                {'·','·','·'},
                {'·','·','·'}
        };

        Assertions.assertArrayEquals(taulell_torn1, joc.getTaulell());
        Assertions.assertEquals(2, joc.getTorn());
    }

    @Test
    void jugar_torn2() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short) 0,(short) 0);
        joc.jugar((short) 0,(short) 1);

        char[][] taulell_torn2 = {
                {'X','O','·'},
                {'·','·','·'},
                {'·','·','·'}
        };
        Assertions.assertArrayEquals(taulell_torn2, joc.getTaulell());
        Assertions.assertEquals(1, joc.getTorn());
    }

    @ParameterizedTest
    @CsvSource({"0,0","0,1","0,2","1,0","1,1","1,2","2,0","2,1","2,2"})
    void jugar_qualsevol_pos_j1(short fila, short columna){
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila,columna);

        char[][] taulell_esperat = {
                {'·','·','·'},
                {'·','·','·'},
                {'·','·','·'}
        };

        taulell_esperat[fila][columna] = 'X';
        Assertions.assertArrayEquals(taulell_esperat, joc.getTaulell());
    }

    @ParameterizedTest
    @CsvSource({"0,1","0,2","1,0","1,1","1,2","2,0","2,1","2,2"})
    void jugar_qualsevol_pos_j2(short fila, short columna){
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short)0,(short)0);
        joc.jugar(fila,columna);

        char[][] taulell_esperat = {
                {'X','·','·'},
                {'·','·','·'},
                {'·','·','·'}
        };

        taulell_esperat[fila][columna] = 'O';
        Assertions.assertArrayEquals(taulell_esperat, joc.getTaulell());
    }
}
