/*
 * Mi segunda clase java

La clase triangulo permite almacenar un triangulo
además de su posición en la pantalla, si está relleno o no
, su color etc
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author Jorge Cisneros
 */
public class Linea extends Polygon{
    
    //color
    public Color color = null;
    //relleno
    public boolean relleno = false;
 
    public Linea (int _x, int _y, int _width,  Color _color, boolean _relleno){
        
        //posicon de los puntos
                addPoint(_x-_width,_y-1);
                //addPoint(_x+_width,_y-1);
                addPoint(_x-_width, _y);
        
        this.color = _color;
        this.relleno = _relleno;
        
    }
    
        //pinta y colorea la linea
        public void pintaYColorea(Graphics2D g2){
            g2.setColor(this.color);
            if (this.relleno) {
                g2.fill(this);
            } else {
                g2.draw(this);
            }
    }
}
