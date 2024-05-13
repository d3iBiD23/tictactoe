public class Joc {
    private char[][] taulell;
    private short torn;

    public char[][] getTaulell() {
        return taulell;
    }

    public short getTorn() {
        return torn;
    }

    public void novaPartida(){
       // genera un taulell de 3x3 amb punts
       taulell = new char[3][3];
       for (int i = 0; i < taulell.length; i++){
           for (int j = 0; j < taulell.length; j++){
               taulell [i][j] = '·';
           }
       }
        // Inicia la partida amb el torn 1, és a dir, el nostre torn
       torn = 1;
    }

    public boolean jugadaGuanyadora(short fila, short columna)  {
        char jugador = taulell[fila][columna];

        // Si la casella esta buida, no pot haver-hi victoria
        if (jugador == '·'){
            return false;
        }

        // Verificar victoria horitzontal
        boolean victoriaHoritzontal = true;
        for (int j = 0; j < 3; j++){
            if (taulell[fila][j] != jugador){
                victoriaHoritzontal = false;
                break;
            }
        }
        if (victoriaHoritzontal){
            return true;
        }

        // Verificar victoria vertical
        boolean victoriaVertical = true;
        for (int i = 0; i < 3; i++){
            if (taulell[i][columna] != jugador){
                victoriaVertical = false;
                break;
            }
        }
        if (victoriaVertical){
            return true;
        }

        // Verificar victoria diagonal
        boolean victoriaDiagonal = true;
        if (fila == columna){
            for (int i = 0; i < 3; i++){
                if (taulell[i][i] != jugador){
                    victoriaDiagonal = false;
                    break;
                }
            }
            if (victoriaDiagonal){
                return true;
            }
        }

        // Verificar victoria diagonal inversa
        boolean victoriaDiagonalInversa = true;
        if (fila + columna == 2) {
            for (int i = 0; i < 3; i++) {
                if (taulell[i][2 - i] != jugador) {
                    victoriaDiagonalInversa = false;
                    break;
                }
            }
            return victoriaDiagonalInversa;
        }

        return false;
    }

    // RETORNAR BOOL PARA COMPROVAR SI S'HA POGUT FICAR FITXA O NO
    public boolean jugar(short fila, short columna) {
        // Si fila està entre 0 i taulell.length
        // Si columna està entre 0 i taulell.length
        // Passem a col·locar la fitxa.

        if (fila >= 0 && fila < taulell.length && columna >= 0 && columna < taulell[fila].length){
            // Comprovar si la primera casella es buida
            if (taulell[fila][columna] == '·'){
                taulell[fila][columna] = (torn == 1) ? 'X' : 'O';
                torn = (torn == 1 ) ? (short) 2: (short) 1;
                return true; // jugada exitosa
            }
        }
        return false; // Casella ja ocupada
    }

    // Nou mètode per saber si és empat
    public boolean isEmpat(){
        for (char[] fila : taulell) {
            for (char cel : fila) {
                if (cel == '·') {
                    return false;
                }
            }
        }
        return true;
    }
}