/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author xp
 */
public class VentanaDibujo extends javax.swing.JFrame {

    private static int DIMENSION_ARRAY = 8;

    //imagen en la que pintaré los círculos
    //es una variable parecida a un Image pero acelerado
    BufferedImage buffer = null;

    int r = 1;
    int puntoX =0;
    int puntoY = 0;
    
    //boolean rellenar = false;
    
    //indica numero de círculos que hay en el array
    int indice = 0;

    //declaro el array en el que voy a guardar las formas

    //ahora en esta versión utilizaré un ArrayList
    ArrayList  listaFormas = new ArrayList();
    
    //variable que almacena el tipo de forma que estoy dibujando
    // si vale 0 ==> dibujo círculos
    // si vale 1 ==> dibujo triangulos
    int forma = 0;
    
    //variable para almacenar el color elegido
    Color colorElegido = Color.BLACK;
    
    //variables para almacenar la posicion en la que se empieza a dibujar la forma
    int posX = 0;
    int posY = 0;
    
    /**
     * Creates new form VentanaDibujo
     */
    public VentanaDibujo() {
        initComponents();
        //hace que la ventana se inicie en el centro de la pantalla
        setLocationRelativeTo(null);
        //pone un titulo a la ventana
        setTitle("Paint");
        //hace que la ventana no se pueda expandir
        setResizable(false);
        //coloca el icono en la barra de herramientas en vez del propio de java
        //y tambien lo pone en el lateral izq de la pantalla cambiando tambien el 
        //propio de java
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
        //creo un buffer del tamaño del jPanel1
        buffer = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        //creo la parte modificable de la imagen
        buffer.createGraphics();
        //apunto al buffer
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        //dibujo un cuadrado blanco del tamaño del buffer
        g2.setColor(Color.white);
        g2.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());

    }


    private boolean chequeaPunto(int x, int y){
        boolean contiene = false;
        for (int i = 0; i < listaFormas.size(); i++) {
            if( ((Shape) listaFormas.get(i)).contains(x,y) ){
                //si en algun momento el contains devuelve true
                //es porque el punto que he pasado está en una forma
                //de las que tengo guardadas en el arraylist
                contiene = true;
            }
        }
        return contiene;
        
    }
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        //dibujo un cuadrado blanco del tamaño del buffer
        g2.setColor(Color.white);
        g2.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        //dibujo todos los elementos del array menores que el indice
        for (int i = 0; i < listaFormas.size(); i++) {
            //las formas a pintar
            if (listaFormas.get(i) instanceof Circulo ){
                 ((Circulo) listaFormas.get(i)).pintaYColorea(g2);
            }
            if (listaFormas.get(i) instanceof Triangulo ){
                ((Triangulo) listaFormas.get(i)).pintaYColorea(g2);
            } 
            if (listaFormas.get(i) instanceof Rombo ){
                ((Rombo) listaFormas.get(i)).pintaYColorea(g2);
            }
            if (listaFormas.get(i) instanceof Cruz ){
                ((Cruz) listaFormas.get(i)).pintaYColorea(g2);
            }
            if (listaFormas.get(i) instanceof Estrella ){
                ((Estrella) listaFormas.get(i)).pintaYColorea(g2);
            }
            
            if (listaFormas.get(i) instanceof Linea ){
                ((Linea) listaFormas.get(i)).pintaYColorea(g2);
            }
            if (listaFormas.get(i) instanceof Cuadrado ){
                ((Cuadrado) listaFormas.get(i)).pintaYColorea(g2);
            }
        }
        //apunto al jPanel
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer, 0, 0, jPanel1.getWidth(), jPanel1.getHeight(), null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        deshacer = new javax.swing.JButton();
        circulo = new javax.swing.JButton();
        cuadrado = new javax.swing.JButton();
        rombo = new javax.swing.JButton();
        triangulo = new javax.swing.JButton();
        cruz = new javax.swing.JButton();
        estrella = new javax.swing.JButton();
        linea = new javax.swing.JButton();
        colores = new javax.swing.JButton();
        borrarTodo = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        aceptar.setText("ACEPTAR");
        aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aceptarMousePressed(evt);
            }
        });

        cancelar.setText("CANCELAR");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(aceptar)
                        .addGap(97, 97, 97)
                        .addComponent(cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("250");

        jSlider1.setMaximum(500);
        jSlider1.setMinimum(1);
        jSlider1.setValue(250);
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSlider1MousePressed(evt);
            }
        });

        deshacer.setText("DESHACER");
        deshacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deshacerMousePressed(evt);
            }
        });

        circulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/circulo.png"))); // NOI18N
        circulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                circuloMousePressed(evt);
            }
        });

        cuadrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        cuadrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuadradoMousePressed(evt);
            }
        });

        rombo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rombo.png"))); // NOI18N
        rombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                romboMousePressed(evt);
            }
        });

        triangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        triangulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trianguloMousePressed(evt);
            }
        });

        cruz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cruz.png"))); // NOI18N
        cruz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cruzMousePressed(evt);
            }
        });

        estrella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrella.png"))); // NOI18N
        estrella.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                estrellaMousePressed(evt);
            }
        });

        linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linea.png"))); // NOI18N
        linea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lineaMousePressed(evt);
            }
        });

        colores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/color.png"))); // NOI18N
        colores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                coloresMousePressed(evt);
            }
        });

        borrarTodo.setText("BORRA TODO");
        borrarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                borrarTodoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deshacer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(circulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(triangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cruz, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(estrella, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(colores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352)
                .addComponent(borrarTodo)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(circulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(triangulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cruz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(estrella, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(linea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(colores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cuadrado, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(borrarTodo)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(deshacer)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Guardar");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menu.add(jMenu1);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       
        r=1;
       Graphics2D g2 = (Graphics2D) jPanel1.getGraphics();
       //posicion del raton al presionarlo 
       posX = evt.getX();
       posY = evt.getY();
     //casos posibles a pintar segun el boton pulsado
     switch(forma){
          case 0: {
              Circulo aux = new Circulo(evt.getX(), evt.getY(), 1, colorElegido, rootPaneCheckingEnabled);
              listaFormas.add( new Circulo(evt.getX(), evt.getY(), 1, colorElegido, true));
          } break;
         
          case 1: {
              Triangulo aux = new Triangulo(evt.getX(), evt.getY(), 1, colorElegido, rootPaneCheckingEnabled);
              listaFormas.add( new Triangulo(evt.getX(), evt.getY(), 1, colorElegido, true));
          } break;
          
          case 2: {
              Rombo aux = new Rombo(evt.getX(), evt.getY(), 1, 1, colorElegido, rootPaneCheckingEnabled);
              listaFormas.add( new Rombo(evt.getX(), evt.getY(), 1, 1, colorElegido, true));
          } break;
          
          case 3: {
              Cruz aux = new Cruz(evt.getX(), evt.getY(), 1, colorElegido, rootPaneCheckingEnabled);
              listaFormas.add( new Cruz(evt.getX(), evt.getY(), jSlider1.getValue()/6, colorElegido, true));
          } break;
          
          case 4: {
              Estrella aux = new Estrella(evt.getX(), evt.getY(), 1, colorElegido, rootPaneCheckingEnabled);
              listaFormas.add( new Estrella(evt.getX(), evt.getY(), 1, colorElegido, true));
          } break;
          
          case 5: {
              Linea aux = new Linea(evt.getX(), evt.getY(), 1, colorElegido, rootPaneCheckingEnabled);
              listaFormas.add( new Linea(evt.getX(), evt.getY(), jSlider1.getValue(), colorElegido, true));
          } break;
          
          case 6: {
              Cuadrado aux = new Cuadrado(evt.getX(), evt.getY(), 1, colorElegido, rootPaneCheckingEnabled);
              listaFormas.add( new Cuadrado(evt.getX(), evt.getY(), jSlider1.getValue(), colorElegido, true));
          } break;
     }
     
    }//GEN-LAST:event_jPanel1MousePressed

    private void deshacerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deshacerMousePressed
        //como dice el metodo desace el ultimo elemento dibujado
        if (listaFormas.size() > 0){
            listaFormas.remove(listaFormas.size()-1); 
            repaint();
        }
    }//GEN-LAST:event_deshacerMousePressed

    private void borrarTodoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarTodoMousePressed
        //borra todas las figuras dejando en blanco el panel para dibujar
        listaFormas.clear();
        repaint();
    }//GEN-LAST:event_borrarTodoMousePressed

    private void jSlider1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MousePressed
        //el metodo hace que al pulsar el jSlider1 se ponga el valor en el 
        //jLabel1
        jLabel1.setText(String.valueOf(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1MousePressed
    
    private void circuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuloMousePressed
        //dibuja el circulo, es decir la forma o el caso 0
        forma = 0;
    }//GEN-LAST:event_circuloMousePressed

    private void trianguloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trianguloMousePressed
        //dibuja el triangulo, es decir la forma o el caso 1
        forma = 1;
    }//GEN-LAST:event_trianguloMousePressed

    private void coloresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coloresMousePressed
        //abre la paleta de colores
        jDialog1.setSize(800, 600);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_coloresMousePressed

    private void aceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMousePressed
        //boton aceptar de la paleta de colores
        colorElegido = jColorChooser1.getColor();
        jDialog1.setVisible(false);
    }//GEN-LAST:event_aceptarMousePressed

    private void romboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_romboMousePressed
        //dibuja el rombo, es decir la forma o el caso 2
        forma = 2;
    }//GEN-LAST:event_romboMousePressed

    private void cruzMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cruzMousePressed
        //dibuja la cruz, es decir la forma o el caso 3
        forma = 3;
    }//GEN-LAST:event_cruzMousePressed

    private void estrellaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estrellaMousePressed
        //dibuja la estrella, es decir la forma o el caso 4
        forma = 4;
    }//GEN-LAST:event_estrellaMousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if (chequeaPunto(evt.getX(), evt.getY())){
            //hay un elemento en esas coordenadas en las que he hecho clic
            System.out.println("HAY UN OBJETO!!!");
        }
        else{
            //int de alto y ancho
            int ancho = jSlider1.getValue()/2;
            int alto = jSlider1.getValue();
            //formas posibles
            switch(forma){
                case 0:listaFormas.add( new Circulo(evt.getX(), evt.getY(), alto, colorElegido, true) ); break; 
                case 1:listaFormas.add( new Triangulo(evt.getX(), evt.getY(), alto, colorElegido, true) ); break;
                case 2:listaFormas.add( new Rombo(evt.getX(), evt.getY(), ancho, alto, colorElegido, true) ); break;
                case 3:listaFormas.add( new Cruz(evt.getX(), evt.getY(), jSlider1.getValue()/6, colorElegido, true) ); break;
                case 4:listaFormas.add( new Estrella(evt.getX(), evt.getY(), alto, colorElegido, true) ); break;
                case 5:listaFormas.add( new Linea(evt.getX(), evt.getY(), jSlider1.getValue(), colorElegido, true) ); break;
                case 6:listaFormas.add( new Cuadrado(evt.getX(), evt.getY(), jSlider1.getValue(), colorElegido, true) ); break;
            }
        }

        
        repaint();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        //formas posibles
        switch (forma){
            case 0:{
                //leo el ultimo elemento de la lista. Se que se añadio
                //en el mousepressed
                Circulo aux = (Circulo) listaFormas.get(listaFormas.size()-1);
                int radio = (int) (evt.getX() - aux.x);
                aux.width = radio;
                aux.height = radio;
            } break;
            
            case 1:{
                //leo el ultimo elemento de la lista. Se que se añadio
                //en el mousepressed
                Triangulo aux = (Triangulo) listaFormas.get(listaFormas.size()-1);
                //int ancho
                int ancho = (int) (evt.getX() - aux.xpoints[0]);
                //int alto
                int alto = (int) (evt.getY() - aux.ypoints[0]);
                //el punto 0 de x y de y
                int puntoX = aux.xpoints[0];
                int puntoY = aux.ypoints[0];
                
                //int de altura y anchura
                ancho = (int) (evt.getX() - puntoX);
                alto = (int) (evt.getY() - puntoY);
                aux.xpoints[1] = puntoX + ancho;
                    
                aux.xpoints[2] = puntoX + ancho/2;
                aux.ypoints[2] = puntoY + alto;
            } break;
            
            case 2:{
                //leo el ultimo elemento de la lista. Se que se añadio
                //en el mousepressed
                Rombo aux = (Rombo) listaFormas.get(listaFormas.size()-1);
                int ancho = 0;
                int alto = 0;
                   
                if(r == 1){
                
                puntoX = aux.xpoints[0];
                puntoY = aux.ypoints[0];
                r=0;
                }
                               
                ancho = (int) (evt.getX() - puntoX);
                alto = (int) (evt.getY() - puntoY);
                
                //puntos del rombo
                aux.xpoints[0] = puntoX ;
                aux.ypoints[0] = puntoY + alto; 
                
                aux.xpoints[1] = puntoX - ancho/2;
                aux.ypoints[1] = puntoY;

                aux.xpoints[2] = puntoX;
                aux.ypoints[2] = puntoY - alto;

                aux.xpoints[3] = puntoX + ancho/2;
                aux.ypoints[3] = puntoY;
            } break;
            
            case 3:{
                //leo el ultimo elemento de la lista. Se que se añadio
                //en el mousepressed
                Cruz aux = (Cruz) listaFormas.get(listaFormas.size()-1);
                int ancho = (int) (evt.getX() - aux.xpoints[0]);
                int alto = (int) (evt.getY() - aux.ypoints[0]);
                
                if(r == 1){
                
                puntoX = aux.xpoints[0];
                puntoY = aux.ypoints[0];
                r=0;
                }
                
                ancho = (int) (evt.getX() - puntoX);
                alto = (int) (evt.getY() - puntoY);
                aux.reset();
                //puntos de la cruz
                aux.addPoint(puntoX - ancho, puntoY +3*ancho);
                aux.addPoint(puntoX + ancho, puntoY +3*ancho);
                aux.addPoint(puntoX + ancho, puntoY + ancho);
                aux.addPoint(puntoX + 3*ancho, puntoY + ancho);
                aux.addPoint(puntoX + 3*ancho, puntoY - ancho);
                aux.addPoint(puntoX + ancho, puntoY - ancho);
                aux.addPoint(puntoX + ancho, puntoY -3*ancho);
                aux.addPoint(puntoX - ancho, puntoY -3*ancho);
                aux.addPoint(puntoX - ancho, puntoY - ancho);
                aux.addPoint(puntoX - 3*ancho, puntoY - ancho);
                aux.addPoint(puntoX - 3*ancho, puntoY + ancho);
                aux.addPoint(puntoX - ancho, puntoY + ancho);
            } break;
            
            case 4:{
                //leo el ultimo elemento de la lista. Se que se añadio
                //en el mousepressed
                Estrella aux = (Estrella) listaFormas.get(listaFormas.size()-1);
                int ancho = (int) (evt.getX() - aux.xpoints[0]);
                int alto = (int) (evt.getY() - aux.ypoints[0]);
                
                if(r == 1){
                
                puntoX = aux.xpoints[0];
                puntoY = aux.ypoints[0];
                r=0;
                }
                
                ancho = (int) (evt.getX() - puntoX);
                alto = (int) (evt.getY() - puntoY);
                aux.reset();
                
                //puntos de la estrella
                aux.addPoint((int) (puntoX + ancho * Math.cos(0 * 2 * Math.PI /5)),
                (int) (puntoY + ancho * Math.sin(0*2 * Math.PI / 5 )));
                aux.addPoint((int) (puntoX + ancho * Math.cos(2 * 2 * Math.PI /5)),
                (int) (puntoY + ancho * Math.sin(2*2 * Math.PI / 5 )));
                aux.addPoint((int) (puntoX + ancho * Math.cos(4 * 2 * Math.PI /5)),
                (int) (puntoY + ancho * Math.sin(4*2 * Math.PI / 5 )));
                aux.addPoint((int) (puntoX + ancho * Math.cos(1 * 2 * Math.PI /5)),
                (int) (puntoY + ancho * Math.sin(1*2 * Math.PI / 5 )));
                aux.addPoint((int) (puntoX + ancho * Math.cos(3 * 2 * Math.PI /5)),
                (int) (puntoY + ancho * Math.sin(3*2 * Math.PI / 5 )));
                    } break;
                    
            case 5:{
                //leo el ultimo elemento de la lista. Se que se añadio
                //en el mousepressed
                Linea aux = (Linea) listaFormas.get(listaFormas.size()-1);
                int ancho = (int) (evt.getX() - aux.xpoints[0]);
                int alto = (int) (evt.getY() - aux.ypoints[0]);
                
                if(r == 1){
                
                puntoX = aux.xpoints[0];
                puntoY = aux.ypoints[0];
                r=0;
                }
                
                ancho = (int) (evt.getX() - puntoX);
                alto = (int) (evt.getY() - puntoY);
                aux.reset();
                
                //puntos de la linea
                aux.addPoint(puntoX,puntoY-1);
                aux.addPoint(puntoX + ancho ,puntoY-1);
                aux.addPoint(puntoX + puntoX,puntoY);
                

                
            } break;
            
            case 6:{
                //leo el ultimo elemento de la lista. Se que se añadio
                //en el mousepressed
                Cuadrado aux = (Cuadrado) listaFormas.get(listaFormas.size()-1);
                int ancho = 0;
                int alto = 0;
                   
                if(r == 1){
                
                puntoX = aux.xpoints[0];
                puntoY = aux.ypoints[0];
                r=0;
                }
                               
                ancho = (int) (evt.getX() - puntoX);
                alto = (int) (evt.getY() - puntoY);
                
                //puntos del cuadrado
                aux.xpoints[0] = puntoX;
                aux.ypoints[0] = puntoY;

                aux.xpoints[1] = puntoX + ancho;
                aux.ypoints[1] = puntoY;

                aux.xpoints[2] = puntoX + ancho;
                aux.ypoints[2] = puntoY + alto;

                aux.xpoints[3] = puntoX;
                aux.ypoints[3] = puntoY + alto;
            } break;
        }
        
        repaint();
        
    }//GEN-LAST:event_jPanel1MouseDragged

    //metodo para guardar el dibujo del paint
    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        //como se va a guardar el archivo, en formato jpg o png
        jFileChooser1.setFileFilter (new FileNameExtensionFilter("archivos de imagen jpg", "jpg"));
        jFileChooser1.setFileFilter (new FileNameExtensionFilter("archivos de imagen png", "png"));
        
        int seleccion = jFileChooser1.showSaveDialog(this);
        
        switch(seleccion){
            case JFileChooser.APPROVE_OPTION :{
                File fichero = jFileChooser1.getSelectedFile();
                String nombre = fichero.getName();
                String extension = nombre.substring(nombre.lastIndexOf('.')+1, nombre.length());
                
                if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")){
            try {
                ImageIO.write(buffer, "jpg", fichero);
            } catch (IOException ex) {
                Logger.getLogger(VentanaDibujo.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            }break;
        }
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void lineaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lineaMousePressed
        //dibuja la linea, es decir la forma o el caso 5
        forma = 5;
    }//GEN-LAST:event_lineaMousePressed

    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
        //el metodo hace que al mover el jSlider1 se ponga el valor en el 
        //jLabel1
        jLabel1.setText(String.valueOf(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1MouseDragged

    private void cuadradoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadradoMousePressed
        forma = 6;
    }//GEN-LAST:event_cuadradoMousePressed

    
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
//            para como se muestra la ventana
//            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDibujo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDibujo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton borrarTodo;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton circulo;
    private javax.swing.JButton colores;
    private javax.swing.JButton cruz;
    private javax.swing.JButton cuadrado;
    private javax.swing.JButton deshacer;
    private javax.swing.JButton estrella;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton linea;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton rombo;
    private javax.swing.JButton triangulo;
    // End of variables declaration//GEN-END:variables
}
