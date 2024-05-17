import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class JocTest {

    @Test
    void creacioFicherTaulell() throws IOException {
        // Elimina el archivo si ya existe
        File configFile = new File("config.txt");
        if (configFile.exists()) {
            configFile.delete();
        }
        Joc joc = new Joc();
        boolean result = joc.archiuMidaTaulell((short) 5);

        Assertions.assertTrue(result);
        Assertions.assertTrue(configFile.exists());
    }

    // Comprovar que el taulell es genera net (ningú ha jugat)
    @Test
    void testNovaPartida_taulell() throws IOException {
        Joc joc = new Joc();
        joc.novaPartida();

        char[][] taulellNet = {
                {'·','·','·'},
                {'·','·','·'},
                {'·','·','·'}
        };
        Assertions.assertArrayEquals(taulellNet,joc.getTaulell());
    }

    // Comprovar que és el torn 1
    @Test
    void testNovaPartida_torn() throws IOException {
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
    void testJugadaGuanyadora_taulell_net(short fila, short columna) throws IOException {
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
    void testJugadaGuanyadora_una_casella_ocupada(short fila, short columna) throws IOException {
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
    void testJugadaGuanyadora_caselles_ocupades_j1(short jugada1Fila, short jugada1Col, short jugada2Fila, short jugada2Col, short jugadaGuanyadoraFila, short jugadaGuanyadoraCol) throws IOException {
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
    void testJugadaGuanyadora_caselles_ocupades_j2(short jugada1Fila, short jugada1Col, short jugada2Fila, short jugada2Col, short jugadaGuanyadoraFila, short jugadaGuanyadoraCol) throws IOException {
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
    void jugar_torn1() throws IOException {
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
    void jugar_torn2() throws IOException {
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
    void jugar_qualsevol_pos_j1(short fila, short columna) throws IOException {
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
    void jugar_qualsevol_pos_j2(short fila, short columna) throws IOException {
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

    /*
        Test per verificar que el directori es crea correctament
        fent la crida al metode desar partida.
        Evidentment per revisar-ho abans hem de revisar si el directori
        no ha sigut creat ja.
     */
    @Test
    void desarPartida_directoriTest() throws IOException {
        Joc joc = new Joc();

        File directori = new File("savedgames");

        // Esborrar directori savedgames si el directori existeix abans de cridar el metode
        if (directori.exists()){
            directori.delete();
        }

        // Generar una nova partida per que es pugui desar
        joc.novaPartida();
        joc.jugar((short)2,(short)2); // J1
        joc.jugar((short)2,(short)1); // J2
        joc.jugar((short)0,(short)2); // J1

        // Cridar el metode que haura de crear el directori
        joc.desarPartida();

        // Verificar si el directori savedgames s'ha creat
        Assertions.assertTrue(directori.exists());
    }

    /*
        Test per verificar que l'arxiu es genera dintre del
        directori savedgames
     */
    @Test
    void desarPartida_arxiuTest() throws IOException {
        Joc joc = new Joc();

        // Generar una nova partida per que es pugui desar
        joc.novaPartida();
        joc.jugar((short)2,(short)2); // J1
        joc.jugar((short)2,(short)1); // J2
        joc.jugar((short)0,(short)2); // J1

        joc.desarPartida();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String nomFitxer = dateFormat.format(new Date());
        File arxiu = new File("savedgames/" + nomFitxer);
        Assertions.assertTrue(arxiu.exists());
    }
    /*
        Verificar la integritat de l'arxiu sigui correcte
     */
    @Test
    public void desarPartida_ContingutTest() throws IOException{
        Joc joc = new Joc();

        // Generar una nova partida per que es pugui desar
        joc.novaPartida();
        joc.jugar((short)2,(short)2); // J1
        joc.jugar((short)2,(short)1); // J2
        joc.jugar((short)0,(short)2); // J1

        joc.desarPartida();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String nomFitxer = dateFormat.format(new Date());
        BufferedReader reader = new BufferedReader(new FileReader("savedgames/" + nomFitxer));

        // Verificar torn del jugador
        Assertions.assertEquals(joc.getTorn(), Character.getNumericValue(reader.read()));
        reader.readLine(); // Consumir una linia
        reader.readLine(); // Llegir la mida del taulell

        // Verificar el contingut del taulell
        char[][] taulellEsperat = joc.getTaulell();
        char[][] taulellActual = llegirTaulellArxiu(reader, taulellEsperat.length);
        Assertions.assertTrue(taulellsIguals(taulellEsperat,taulellActual));
        reader.close();
    }

    private char[][] llegirTaulellArxiu(BufferedReader reader, int files) throws IOException{
        char[][] board = new char[files][];
        for (int i = 0; i < files; i++){
            String fila = reader.readLine();
            board[i] = fila.toCharArray();
        }
        return board;
    }

    private boolean taulellsIguals(char[][] esperat, char[][] actual){
        if (esperat.length != actual.length || esperat[0].length != actual[0].length){
            return false;
        }
        for (int i = 0; i < esperat.length; i++) {
            for (int j = 0; j < esperat[i].length; j++) {
                if (esperat[i][j] != actual[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void carregarPartida() {
    }

    @Test
    void llistarPartides() {
    }
}
