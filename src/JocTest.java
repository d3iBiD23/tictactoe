import org.junit.jupiter.api.Assertions;

public class JocTest {

    @org.junit.jupiter.api.Test
    void testNovaPartida() {
        // Instanciar joc
        Joc j = new Joc();

        // Comprovar que es el turno 1
        Assertions.assertEquals(1, j.getTorn());

        // Comprovar que el tablero se genera limpio (nadie ha jugado)
    }

    @org.junit.jupiter.api.Test
    void testJugadaGuanyadora() {
    }

    @org.junit.jupiter.api.Test
    void jugar() {

    }
}
