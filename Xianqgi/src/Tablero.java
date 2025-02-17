import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends javax.swing.JFrame {
    private javax.swing.JButton[][] botones = new javax.swing.JButton[10][9];
    private Pieza[][] piezas = new Pieza[10][9];
    private int filaSeleccionada = -1;
    private int columnaSeleccionada = -1;

    public Tablero() {
        initComponents(); // Método generado por NetBeans para inicializar componentes
        inicializarBotones();
        inicializarPiezas();
        actualizarTablero();
    }

    private void inicializarBotones() {
    botones[0][0] = btn00;  
    botones[0][1] = btn01;
    botones[0][2] = btn02; 
    botones[0][3] = btn03; 
    botones[0][4] = btn04; 
    botones[0][5] = btn05; 
    botones[0][6] = btn06; 
    botones[0][7] = btn07; 
    botones[0][8] = btn08;
    
    botones[1][0] = btn10; 
    botones[1][1] = btn11; 
    botones[1][2] = btn12; 
    botones[1][3] = btn13; 
    botones[1][4] = btn14; 
    botones[1][5] = btn15; 
    botones[1][6] = btn16; 
    botones[1][7] = btn17; 
    botones[1][8] = btn18;
    
    botones[2][0] = btn20; 
    botones[2][1] = btn21; 
    botones[2][2] = btn22; 
    botones[2][3] = btn23; 
    botones[2][4] = btn24; 
    botones[2][5] = btn25; 
    botones[2][6] = btn26; 
    botones[2][7] = btn27; 
    botones[2][8] = btn28;
    
    botones[3][0] = btn30; 
    botones[3][1] = btn31; 
    botones[3][2] = btn32; 
    botones[3][3] = btn33; 
    botones[3][4] = btn34; 
    botones[3][5] = btn35; 
    botones[3][6] = btn36; 
    botones[3][7] = btn37; 
    botones[3][8] = btn38;
    
    botones[4][0] = btn40; 
    botones[4][1] = btn41; 
    botones[4][2] = btn42; 
    botones[4][3] = btn43; 
    botones[4][4] = btn44; 
    botones[4][5] = btn45; 
    botones[4][6] = btn46; 
    botones[4][7] = btn47; 
    botones[4][8] = btn48;
    
    botones[5][0] = btn50; 
    botones[5][1] = btn51; 
    botones[5][2] = btn52; 
    botones[5][3] = btn53; 
    botones[5][4] = btn54; 
    botones[5][5] = btn55; 
    botones[5][6] = btn56; 
    botones[5][7] = btn57; 
    botones[5][8] = btn58;
    
    botones[6][0] = btn60; 
    botones[6][1] = btn61; 
    botones[6][2] = btn62; 
    botones[6][3] = btn63; 
    botones[6][4] = btn64; 
    botones[6][5] = btn65; 
    botones[6][6] = btn66; 
    botones[6][7] = btn67; 
    botones[6][8] = btn68;
    
    botones[7][0] = btn70; 
    botones[7][1] = btn71; 
    botones[7][2] = btn72; 
    botones[7][3] = btn73; 
    botones[7][4] = btn74; 
    botones[7][5] = btn75; 
    botones[7][6] = btn76; 
    botones[7][7] = btn77; 
    botones[7][8] = btn78;
    
    botones[8][0] = btn80; 
    botones[8][1] = btn81; 
    botones[8][2] = btn82; 
    botones[8][3] = btn83; 
    botones[8][4] = btn84; 
    botones[8][5] = btn85; 
    botones[8][6] = btn86; 
    botones[8][7] = btn87; 
    botones[8][8] = btn88;
    
    botones[9][0] = btn90; 
    botones[9][1] = btn91; 
    botones[9][2] = btn92; 
    botones[9][3] = btn93; 
    botones[9][4] = btn94; 
    botones[9][5] = btn95; 
    botones[9][6] = btn96; 
    botones[9][7] = btn97; 
    botones[9][8] = btn98;
       
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                final int fila = i;
                final int columna = j;
                botones[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        manejarClic(fila, columna);
                    }
                });
            }
        }
    }

   private void inicializarPiezas() {
       
    // Colocar Generales
    piezas[0][4] = new General(0, 4, true);
    piezas[9][4] = new General(9, 4, false);

    // Colocar Soldados
    for (int j = 0; j < 9; j += 2) {
        piezas[3][j] = new Soldado(3, j, true);
        piezas[6][j] = new Soldado(6, j, false);
    }

    // Colocar Carros
    piezas[0][0] = new Carro(0, 0, true); piezas[0][8] = new Carro(0, 8, true);
    piezas[9][0] = new Carro(9, 0, false); piezas[9][8] = new Carro(9, 8, false);

    // Colocar Caballos
    piezas[0][1] = new Caballo(0, 1, true); piezas[0][7] = new Caballo(0, 7, true);
    piezas[9][1] = new Caballo(9, 1, false); piezas[9][7] = new Caballo(9, 7, false);

    // Colocar Elefantes
    piezas[0][2] = new Elefante(0, 2, true); piezas[0][6] = new Elefante(0, 6, true);
    piezas[9][2] = new Elefante(9, 2, false); piezas[9][6] = new Elefante(9, 6, false);

    // Colocar Oficiales
    piezas[0][3] = new Oficial(0, 3, true); piezas[0][5] = new Oficial(0, 5, true);
    piezas[9][3] = new Oficial(9, 3, false); piezas[9][5] = new Oficial(9, 5, false);

    // Colocar Canones
    piezas[2][1] = new Canon(2, 1, true); piezas[2][7] = new Canon(2, 7, true);
    piezas[7][1] = new Canon(7, 1, false); piezas[7][7] = new Canon(7, 7, false);
}
   
     private void actualizarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (piezas[i][j] != null) {
                    botones[i][j].setText(piezas[i][j].getClass().getSimpleName());
                } else {
                    botones[i][j].setText("");
                }
            }
        }
    }

    private void manejarClic(int fila, int columna) {
    if (filaSeleccionada == -1 && columnaSeleccionada == -1) {
        
        if (piezas[fila][columna] != null) {
            filaSeleccionada = fila;
            columnaSeleccionada = columna;
        }
    } else {
        
        Pieza pieza = piezas[filaSeleccionada][columnaSeleccionada];
        if (pieza.esMovimientoValido(fila, columna, piezas)) {
            piezas[fila][columna] = pieza;
            piezas[filaSeleccionada][columnaSeleccionada] = null;
            pieza.mover(fila, columna);
            actualizarBotones(filaSeleccionada, columnaSeleccionada, fila, columna);
        }
        filaSeleccionada = -1;
        columnaSeleccionada = -1;
    }
}

private void actualizarBotones(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
    
    botones[filaFinal][columnaFinal].setIcon(botones[filaInicial][columnaInicial].getIcon());
    
    botones[filaInicial][columnaInicial].setIcon(null);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn00 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn03 = new javax.swing.JButton();
        btn04 = new javax.swing.JButton();
        btn05 = new javax.swing.JButton();
        btn06 = new javax.swing.JButton();
        btn07 = new javax.swing.JButton();
        btn08 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn27 = new javax.swing.JButton();
        btn28 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn34 = new javax.swing.JButton();
        btn35 = new javax.swing.JButton();
        btn36 = new javax.swing.JButton();
        btn37 = new javax.swing.JButton();
        btn38 = new javax.swing.JButton();
        btn40 = new javax.swing.JButton();
        btn41 = new javax.swing.JButton();
        btn42 = new javax.swing.JButton();
        btn43 = new javax.swing.JButton();
        btn44 = new javax.swing.JButton();
        btn45 = new javax.swing.JButton();
        btn46 = new javax.swing.JButton();
        btn47 = new javax.swing.JButton();
        btn48 = new javax.swing.JButton();
        btn50 = new javax.swing.JButton();
        btn51 = new javax.swing.JButton();
        btn52 = new javax.swing.JButton();
        btn53 = new javax.swing.JButton();
        btn54 = new javax.swing.JButton();
        btn55 = new javax.swing.JButton();
        btn56 = new javax.swing.JButton();
        btn57 = new javax.swing.JButton();
        btn58 = new javax.swing.JButton();
        btn60 = new javax.swing.JButton();
        btn61 = new javax.swing.JButton();
        btn62 = new javax.swing.JButton();
        btn63 = new javax.swing.JButton();
        btn64 = new javax.swing.JButton();
        btn65 = new javax.swing.JButton();
        btn66 = new javax.swing.JButton();
        btn67 = new javax.swing.JButton();
        btn68 = new javax.swing.JButton();
        btn70 = new javax.swing.JButton();
        btn71 = new javax.swing.JButton();
        btn72 = new javax.swing.JButton();
        btn73 = new javax.swing.JButton();
        btn74 = new javax.swing.JButton();
        btn75 = new javax.swing.JButton();
        btn76 = new javax.swing.JButton();
        btn77 = new javax.swing.JButton();
        btn78 = new javax.swing.JButton();
        btn80 = new javax.swing.JButton();
        btn81 = new javax.swing.JButton();
        btn82 = new javax.swing.JButton();
        btn83 = new javax.swing.JButton();
        btn84 = new javax.swing.JButton();
        btn85 = new javax.swing.JButton();
        btn86 = new javax.swing.JButton();
        btn87 = new javax.swing.JButton();
        btn88 = new javax.swing.JButton();
        btn90 = new javax.swing.JButton();
        btn91 = new javax.swing.JButton();
        btn92 = new javax.swing.JButton();
        btn93 = new javax.swing.JButton();
        btn94 = new javax.swing.JButton();
        btn95 = new javax.swing.JButton();
        btn96 = new javax.swing.JButton();
        btn97 = new javax.swing.JButton();
        btn98 = new javax.swing.JButton();
        panelTablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn00.setBackground(new java.awt.Color(255, 255, 204));
        btn00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Carro Negro.png"))); // NOI18N
        btn00.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn00.setPreferredSize(new java.awt.Dimension(50, 50));
        btn00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn00ActionPerformed(evt);
            }
        });
        getContentPane().add(btn00, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btn01.setBackground(new java.awt.Color(255, 255, 204));
        btn01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Caballo Negro.png"))); // NOI18N
        btn01.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn01.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn01, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        btn02.setBackground(new java.awt.Color(255, 255, 204));
        btn02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Elefante Negro.png"))); // NOI18N
        btn02.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn02.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn02, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        btn03.setBackground(new java.awt.Color(255, 255, 204));
        btn03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Oficial Negro.png"))); // NOI18N
        btn03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn03.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn03, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        btn04.setBackground(new java.awt.Color(255, 255, 204));
        btn04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/General Negro.png"))); // NOI18N
        btn04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn04.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn04, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        btn05.setBackground(new java.awt.Color(255, 255, 204));
        btn05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Oficial Negro.png"))); // NOI18N
        btn05.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn05.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn05, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        btn06.setBackground(new java.awt.Color(255, 255, 204));
        btn06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Elefante Negro.png"))); // NOI18N
        btn06.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn06.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn06, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        btn07.setBackground(new java.awt.Color(255, 255, 204));
        btn07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Caballo Negro.png"))); // NOI18N
        btn07.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn07.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn07, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        btn08.setBackground(new java.awt.Color(255, 255, 204));
        btn08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Carro Negro.png"))); // NOI18N
        btn08.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn08.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn08, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        btn10.setBackground(new java.awt.Color(255, 255, 204));
        btn10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn10.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        btn11.setBackground(new java.awt.Color(255, 255, 204));
        btn11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn11.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btn12.setBackground(new java.awt.Color(255, 255, 204));
        btn12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn12.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        btn13.setBackground(new java.awt.Color(255, 255, 204));
        btn13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn13.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        btn14.setBackground(new java.awt.Color(255, 255, 204));
        btn14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn14.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        btn15.setBackground(new java.awt.Color(255, 255, 204));
        btn15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn15.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        btn16.setBackground(new java.awt.Color(255, 255, 204));
        btn16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn16.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        btn17.setBackground(new java.awt.Color(255, 255, 204));
        btn17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn17.setPreferredSize(new java.awt.Dimension(50, 50));
        btn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn17ActionPerformed(evt);
            }
        });
        getContentPane().add(btn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        btn18.setBackground(new java.awt.Color(255, 255, 204));
        btn18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn18.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        btn20.setBackground(new java.awt.Color(255, 255, 204));
        btn20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn20.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        btn21.setBackground(new java.awt.Color(255, 255, 204));
        btn21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cañon Negro.png"))); // NOI18N
        btn21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn21.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        btn22.setBackground(new java.awt.Color(255, 255, 204));
        btn22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn22.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        btn23.setBackground(new java.awt.Color(255, 255, 204));
        btn23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn23.setPreferredSize(new java.awt.Dimension(50, 50));
        btn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn23ActionPerformed(evt);
            }
        });
        getContentPane().add(btn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        btn24.setBackground(new java.awt.Color(255, 255, 204));
        btn24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn24.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        btn25.setBackground(new java.awt.Color(255, 255, 204));
        btn25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn25.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        btn26.setBackground(new java.awt.Color(255, 255, 204));
        btn26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn26.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        btn27.setBackground(new java.awt.Color(255, 255, 204));
        btn27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cañon Negro.png"))); // NOI18N
        btn27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn27.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn27, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, -1));

        btn28.setBackground(new java.awt.Color(255, 255, 204));
        btn28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn28.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn28, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        btn30.setBackground(new java.awt.Color(255, 255, 204));
        btn30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Negro.png"))); // NOI18N
        btn30.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn30.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        btn31.setBackground(new java.awt.Color(255, 255, 204));
        btn31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn31.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        btn32.setBackground(new java.awt.Color(255, 255, 204));
        btn32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Negro.png"))); // NOI18N
        btn32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn32.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        btn33.setBackground(new java.awt.Color(255, 255, 204));
        btn33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn33.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn33, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        btn34.setBackground(new java.awt.Color(255, 255, 204));
        btn34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Negro.png"))); // NOI18N
        btn34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn34.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn34, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        btn35.setBackground(new java.awt.Color(255, 255, 204));
        btn35.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn35.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn35, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        btn36.setBackground(new java.awt.Color(255, 255, 204));
        btn36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Negro.png"))); // NOI18N
        btn36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn36.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn36, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        btn37.setBackground(new java.awt.Color(255, 255, 204));
        btn37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn37.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn37, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        btn38.setBackground(new java.awt.Color(255, 255, 204));
        btn38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Negro.png"))); // NOI18N
        btn38.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn38.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn38, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        btn40.setBackground(new java.awt.Color(0, 153, 153));
        btn40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn40.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn40.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        btn41.setBackground(new java.awt.Color(0, 153, 153));
        btn41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn41.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        btn42.setBackground(new java.awt.Color(0, 153, 153));
        btn42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn42.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn42.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn42, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        btn43.setBackground(new java.awt.Color(0, 153, 153));
        btn43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn43.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn43.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn43, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        btn44.setBackground(new java.awt.Color(0, 153, 153));
        btn44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn44.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn44.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn44, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        btn45.setBackground(new java.awt.Color(0, 153, 153));
        btn45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn45.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn45.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn45, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        btn46.setBackground(new java.awt.Color(0, 153, 153));
        btn46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn46.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn46.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn46, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        btn47.setBackground(new java.awt.Color(0, 153, 153));
        btn47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn47.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn47.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn47, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        btn48.setBackground(new java.awt.Color(0, 153, 153));
        btn48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn48.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn48.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn48, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        btn50.setBackground(new java.awt.Color(0, 153, 153));
        btn50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn50.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn50.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

        btn51.setBackground(new java.awt.Color(0, 153, 153));
        btn51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn51.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn51.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        btn52.setBackground(new java.awt.Color(0, 153, 153));
        btn52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn52.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn52.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn52, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        btn53.setBackground(new java.awt.Color(0, 153, 153));
        btn53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn53.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn53.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn53, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        btn54.setBackground(new java.awt.Color(0, 153, 153));
        btn54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn54.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn54.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn54, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));

        btn55.setBackground(new java.awt.Color(0, 153, 153));
        btn55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn55.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn55.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn55, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        btn56.setBackground(new java.awt.Color(0, 153, 153));
        btn56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn56.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn56.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn56, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        btn57.setBackground(new java.awt.Color(0, 153, 153));
        btn57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn57.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn57.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn57, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        btn58.setBackground(new java.awt.Color(0, 153, 153));
        btn58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xianqgi/Imagenes/Imagenes/Peon Negro.png"))); // NOI18N
        btn58.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn58.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn58, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        btn60.setBackground(new java.awt.Color(255, 255, 204));
        btn60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Rojo.png"))); // NOI18N
        btn60.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn60.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        btn61.setBackground(new java.awt.Color(255, 255, 204));
        btn61.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn61.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        btn62.setBackground(new java.awt.Color(255, 255, 204));
        btn62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Rojo.png"))); // NOI18N
        btn62.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn62.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn62, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        btn63.setBackground(new java.awt.Color(255, 255, 204));
        btn63.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn63.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn63, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        btn64.setBackground(new java.awt.Color(255, 255, 204));
        btn64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Rojo.png"))); // NOI18N
        btn64.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn64.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn64, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        btn65.setBackground(new java.awt.Color(255, 255, 204));
        btn65.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn65.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn65, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        btn66.setBackground(new java.awt.Color(255, 255, 204));
        btn66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Rojo.png"))); // NOI18N
        btn66.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn66.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn66, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        btn67.setBackground(new java.awt.Color(255, 255, 204));
        btn67.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn67.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn67, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        btn68.setBackground(new java.awt.Color(255, 255, 204));
        btn68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Peon Rojo.png"))); // NOI18N
        btn68.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn68.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn68, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        btn70.setBackground(new java.awt.Color(255, 255, 204));
        btn70.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn70.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        btn71.setBackground(new java.awt.Color(255, 255, 204));
        btn71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cañon Rojo.png"))); // NOI18N
        btn71.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn71.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn71, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        btn72.setBackground(new java.awt.Color(255, 255, 204));
        btn72.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn72.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn72, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        btn73.setBackground(new java.awt.Color(255, 255, 204));
        btn73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn73.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn73, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        btn74.setBackground(new java.awt.Color(255, 255, 204));
        btn74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn74.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn74, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, -1));

        btn75.setBackground(new java.awt.Color(255, 255, 204));
        btn75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn75.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn75, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));

        btn76.setBackground(new java.awt.Color(255, 255, 204));
        btn76.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn76.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn76, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        btn77.setBackground(new java.awt.Color(255, 255, 204));
        btn77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cañon Rojo.png"))); // NOI18N
        btn77.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn77.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn77, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        btn78.setBackground(new java.awt.Color(255, 255, 204));
        btn78.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn78.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn78, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, -1));

        btn80.setBackground(new java.awt.Color(255, 255, 204));
        btn80.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn80.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn80, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, -1, -1));

        btn81.setBackground(new java.awt.Color(255, 255, 204));
        btn81.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn81.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn81, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        btn82.setBackground(new java.awt.Color(255, 255, 204));
        btn82.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn82.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn82, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        btn83.setBackground(new java.awt.Color(255, 255, 204));
        btn83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn83.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn83, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        btn84.setBackground(new java.awt.Color(255, 255, 204));
        btn84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn84.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn84, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, -1, -1));

        btn85.setBackground(new java.awt.Color(255, 255, 204));
        btn85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn85.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn85, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        btn86.setBackground(new java.awt.Color(255, 255, 204));
        btn86.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn86.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn86, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        btn87.setBackground(new java.awt.Color(255, 255, 204));
        btn87.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn87.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn87, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        btn88.setBackground(new java.awt.Color(255, 255, 204));
        btn88.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn88.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn88, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, -1));

        btn90.setBackground(new java.awt.Color(255, 255, 204));
        btn90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Carro Rojo.png"))); // NOI18N
        btn90.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn90.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));

        btn91.setBackground(new java.awt.Color(255, 255, 204));
        btn91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Caballo Rojo.png"))); // NOI18N
        btn91.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn91.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn91, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        btn92.setBackground(new java.awt.Color(255, 255, 204));
        btn92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Elefante Rojo.png"))); // NOI18N
        btn92.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn92.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn92, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        btn93.setBackground(new java.awt.Color(255, 255, 204));
        btn93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Oficial Rojo.png"))); // NOI18N
        btn93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn93.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn93, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, -1, -1));

        btn94.setBackground(new java.awt.Color(255, 255, 204));
        btn94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/General Rojo.png"))); // NOI18N
        btn94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn94.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn94, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, -1));

        btn95.setBackground(new java.awt.Color(255, 255, 204));
        btn95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Oficial Rojo.png"))); // NOI18N
        btn95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn95.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn95, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));

        btn96.setBackground(new java.awt.Color(255, 255, 204));
        btn96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Elefante Rojo.png"))); // NOI18N
        btn96.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn96.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn96, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        btn97.setBackground(new java.awt.Color(255, 255, 204));
        btn97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Caballo Rojo.png"))); // NOI18N
        btn97.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn97.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn97, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, -1));

        btn98.setBackground(new java.awt.Color(255, 255, 204));
        btn98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Carro Rojo.png"))); // NOI18N
        btn98.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn98.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(btn98, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));
        getContentPane().add(panelTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn00ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn00ActionPerformed

    private void btn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn17ActionPerformed

    private void btn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn23ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn00;
    public static javax.swing.JButton btn01;
    public static javax.swing.JButton btn02;
    public static javax.swing.JButton btn03;
    public static javax.swing.JButton btn04;
    public static javax.swing.JButton btn05;
    public static javax.swing.JButton btn06;
    public static javax.swing.JButton btn07;
    public static javax.swing.JButton btn08;
    public static javax.swing.JButton btn10;
    public static javax.swing.JButton btn11;
    public static javax.swing.JButton btn12;
    public static javax.swing.JButton btn13;
    public static javax.swing.JButton btn14;
    public static javax.swing.JButton btn15;
    public static javax.swing.JButton btn16;
    public static javax.swing.JButton btn17;
    public static javax.swing.JButton btn18;
    public static javax.swing.JButton btn20;
    public static javax.swing.JButton btn21;
    public static javax.swing.JButton btn22;
    public static javax.swing.JButton btn23;
    public static javax.swing.JButton btn24;
    public static javax.swing.JButton btn25;
    public static javax.swing.JButton btn26;
    public static javax.swing.JButton btn27;
    public static javax.swing.JButton btn28;
    public static javax.swing.JButton btn30;
    public static javax.swing.JButton btn31;
    public static javax.swing.JButton btn32;
    public static javax.swing.JButton btn33;
    public static javax.swing.JButton btn34;
    public static javax.swing.JButton btn35;
    public static javax.swing.JButton btn36;
    public static javax.swing.JButton btn37;
    public static javax.swing.JButton btn38;
    public static javax.swing.JButton btn40;
    public static javax.swing.JButton btn41;
    public static javax.swing.JButton btn42;
    public static javax.swing.JButton btn43;
    public static javax.swing.JButton btn44;
    public static javax.swing.JButton btn45;
    public static javax.swing.JButton btn46;
    public static javax.swing.JButton btn47;
    public static javax.swing.JButton btn48;
    public static javax.swing.JButton btn50;
    public static javax.swing.JButton btn51;
    public static javax.swing.JButton btn52;
    public static javax.swing.JButton btn53;
    public static javax.swing.JButton btn54;
    public static javax.swing.JButton btn55;
    public static javax.swing.JButton btn56;
    public static javax.swing.JButton btn57;
    public static javax.swing.JButton btn58;
    public static javax.swing.JButton btn60;
    public static javax.swing.JButton btn61;
    public static javax.swing.JButton btn62;
    public static javax.swing.JButton btn63;
    public static javax.swing.JButton btn64;
    public static javax.swing.JButton btn65;
    public static javax.swing.JButton btn66;
    public static javax.swing.JButton btn67;
    public static javax.swing.JButton btn68;
    public static javax.swing.JButton btn70;
    public static javax.swing.JButton btn71;
    public static javax.swing.JButton btn72;
    public static javax.swing.JButton btn73;
    public static javax.swing.JButton btn74;
    public static javax.swing.JButton btn75;
    public static javax.swing.JButton btn76;
    public static javax.swing.JButton btn77;
    public static javax.swing.JButton btn78;
    public static javax.swing.JButton btn80;
    public static javax.swing.JButton btn81;
    public static javax.swing.JButton btn82;
    public static javax.swing.JButton btn83;
    public static javax.swing.JButton btn84;
    public static javax.swing.JButton btn85;
    public static javax.swing.JButton btn86;
    public static javax.swing.JButton btn87;
    public static javax.swing.JButton btn88;
    public static javax.swing.JButton btn90;
    public static javax.swing.JButton btn91;
    public static javax.swing.JButton btn92;
    public static javax.swing.JButton btn93;
    public static javax.swing.JButton btn94;
    public static javax.swing.JButton btn95;
    public static javax.swing.JButton btn96;
    public static javax.swing.JButton btn97;
    public static javax.swing.JButton btn98;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
}
