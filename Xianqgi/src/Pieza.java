/**
 *
 * @author Nadiesda Fuentes
 */
public abstract class Pieza {
    protected int fila, columna;
    protected boolean esRojo;

    public Pieza(int fila, int columna, boolean esRojo) {
        this.fila = fila;
        this.columna = columna;
        this.esRojo = esRojo;
    }

    public abstract boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] piezas);

    public void mover(int nuevaFila, int nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }

    public boolean esRojo() {
        return esRojo;
    }

    public boolean esEnemigo(Pieza otra) {
        return otra != null && this.esRojo != otra.esRojo;
    }
}

public class Soldado extends Pieza {
    public Soldado(int fila, int columna, boolean esRojo) {
        super(fila, columna, esRojo);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] piezas) {
        int direccion = esRojo ? -1 : 1; // Rojo arriba, Negro abajo

        // Antes de cruzar el río
        if ((esRojo && fila > 4) || (!esRojo && fila < 5)) {
            return nuevaFila == fila + direccion && nuevaColumna == columna;
        }

        // Después del río, puede moverse lateralmente
        return (nuevaFila == fila + direccion && nuevaColumna == columna) || 
               (nuevaFila == fila && Math.abs(nuevaColumna - columna) == 1);
    }
}

public class General extends Pieza {
    public General(int fila, int columna, boolean esRojo) {
        super(fila, columna, esRojo);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] piezas) {
        // Limites del palacio
        int minFila = esRojo ? 7 : 0;
        int maxFila = esRojo ? 9 : 2;

        if (nuevaFila < minFila || nuevaFila > maxFila || nuevaColumna < 3 || nuevaColumna > 5) {
            return false;
        }

        // Solo puede moverse 1 casilla en vertical u horizontal
        return (Math.abs(nuevaFila - fila) == 1 && nuevaColumna == columna) || 
               (Math.abs(nuevaColumna - columna) == 1 && nuevaFila == fila);
    }
}

public class Oficial extends Pieza {
    public Oficial(int fila, int columna, boolean esRojo) {
        super(fila, columna, esRojo);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] piezas) {
        int minFila = esRojo ? 7 : 0;
        int maxFila = esRojo ? 9 : 2;

        if (nuevaFila < minFila || nuevaFila > maxFila || nuevaColumna < 3 || nuevaColumna > 5) {
            return false;
        }

        // Movimiento diagonal (1 casilla)
        return Math.abs(nuevaFila - fila) == 1 && Math.abs(nuevaColumna - columna) == 1;
    }
}

public class Elefante extends Pieza {
    public Elefante(int fila, int columna, boolean esRojo) {
        super(fila, columna, esRojo);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] piezas) {
        if ((esRojo && nuevaFila < 5) || (!esRojo && nuevaFila > 4)) {
            return false; // No puede cruzar el río
        }

        // Movimiento en diagonal exactamente 2 casillas
        if (Math.abs(nuevaFila - fila) == 2 && Math.abs(nuevaColumna - columna) == 2) {
            int intermediaFila = (fila + nuevaFila) / 2;
            int intermediaColumna = (columna + nuevaColumna) / 2;

            // Verificar que la casilla intermedia esté vacía
            return piezas[intermediaFila][intermediaColumna] == null;
        }
        return false;
    }
}

public class Carro extends Pieza {
    public Carro(int fila, int columna, boolean esRojo) {
        super(fila, columna, esRojo);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] piezas) {
        if (fila == nuevaFila) { // Movimiento horizontal
            int menor = Math.min(columna, nuevaColumna);
            int mayor = Math.max(columna, nuevaColumna);
            for (int i = menor + 1; i < mayor; i++) {
                if (piezas[fila][i] != null) return false; // No puede saltar piezas
            }
            return true;
        } else if (columna == nuevaColumna) { // Movimiento vertical
            int menor = Math.min(fila, nuevaFila);
            int mayor = Math.max(fila, nuevaFila);
            for (int i = menor + 1; i < mayor; i++) {
                if (piezas[i][columna] != null) return false;
            }
            return true;
        }
        return false;
    }
}

public class Caballo extends Pieza {
    public Caballo(int fila, int columna, boolean esRojo) {
        super(fila, columna, esRojo);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] piezas) {
        int diffFila = nuevaFila - fila;
        int diffColumna = nuevaColumna - columna;

        if (Math.abs(diffFila) == 2 && Math.abs(diffColumna) == 1) {
            int intermediaFila = fila + (diffFila / 2);
            if (piezas[intermediaFila][columna] == null) return true;
        }

        if (Math.abs(diffFila) == 1 && Math.abs(diffColumna) == 2) {
            int intermediaColumna = columna + (diffColumna / 2);
            if (piezas[fila][intermediaColumna] == null) return true;
        }

        return false;
    }
}

public class Canon extends Pieza {
    public Canon(int fila, int columna, boolean esRojo) {
        super(fila, columna, esRojo);
    }

    @Override
    public boolean esMovimientoValido(int nuevaFila, int nuevaColumna, Pieza[][] piezas) {
        if (fila == nuevaFila) { // Movimiento horizontal
            int menor = Math.min(columna, nuevaColumna);
            int mayor = Math.max(columna, nuevaColumna);
            int obstaculos = 0;

            for (int i = menor + 1; i < mayor; i++) {
                if (piezas[fila][i] != null) {
                    obstaculos++;
                }
            }
            if (piezas[nuevaFila][nuevaColumna] == null) {
                return obstaculos == 0; // Movimiento normal (sin obstáculos)
            } else {
                return obstaculos == 1 && esEnemigo(piezas[nuevaFila][nuevaColumna]); // Captura con 1 obstáculo
            }
        } else if (columna == nuevaColumna) { // Movimiento vertical
            int menor = Math.min(fila, nuevaFila);
            int mayor = Math.max(fila, nuevaFila);
            int obstaculos = 0;

            for (int i = menor + 1; i < mayor; i++) {
                if (piezas[i][columna] != null) {
                    obstaculos++;
                }
            }

            if (piezas[nuevaFila][nuevaColumna] == null) {
                return obstaculos == 0;
            } else {
                return obstaculos == 1 && esEnemigo(piezas[nuevaFila][nuevaColumna]);
            }
        }
        return false;
    }
}