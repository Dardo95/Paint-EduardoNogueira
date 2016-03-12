/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author xp
 */
public class Estrella extends Polygon{
    
    //color
    public Color color = null;
    //relleno
    public boolean relleno = false;
 
    
    public Estrella (int _x, int _y, int _width,  Color _color, boolean _relleno){
       //Numero de puntos de la figura y sus posiciones
       //Estrella Rellena parcialmente
       addPoint((int) (_x + _width * Math.cos(0 * 2 * Math.PI /5)),
        (int) (_y + _width * Math.sin(0*2 * Math.PI / 5 )));
       addPoint((int) (_x + _width * Math.cos(2 * 2 * Math.PI /5)),
        (int) (_y + _width * Math.sin(2*2 * Math.PI / 5 )));
       addPoint((int) (_x + _width * Math.cos(4 * 2 * Math.PI /5)),
        (int) (_y + _width * Math.sin(4*2 * Math.PI / 5 )));
       addPoint((int) (_x + _width * Math.cos(1 * 2 * Math.PI /5)),
        (int) (_y + _width * Math.sin(1*2 * Math.PI / 5 )));
       addPoint((int) (_x + _width * Math.cos(3 * 2 * Math.PI /5)),
        (int) (_y + _width * Math.sin(3*2 * Math.PI / 5 )));
        
        
        
        this.color = _color;
        this.relleno = _relleno;
        
    }
    
        //pinta y colorea la imagen
        public void pintaYColorea(Graphics2D g2){
            g2.setColor(this.color);
            if (this.relleno) {
                g2.fill(this);
            } else {
                g2.draw(this);
            }
    }
    
}