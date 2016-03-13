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
 * @author Dardo Nogueira
 */
public class Cuadrado extends Polygon{
    
    //color
    public Color color = null;
    //relleno
    public boolean relleno = false;
 
    
    public Cuadrado (int _x, int _y, int _width,  Color _color, boolean _relleno){
        
        //Numero de puntos de la figura
        this.npoints = 4;
        
        //puntos de la figura
        this.xpoints[0] = _x - _width;
        this.ypoints[0] = _y; 

        this.xpoints[1] = _x - _width;
        this.ypoints[1] = _y - _width;
 
        this.xpoints[2] = _x;
        this.ypoints[2] = _y - _width;
        
        this.xpoints[3] = _x;
        this.ypoints[3] = _y;
        
        
        this.color = _color;
        
        this.relleno = _relleno;
        
    }
    
        //pinta y colorea la figura
        public void pintaYColorea(Graphics2D g2){
            g2.setColor(this.color);
            if (this.relleno) {
                g2.fill(this);
            } else {
                g2.draw(this);
            }
    }
    
}
