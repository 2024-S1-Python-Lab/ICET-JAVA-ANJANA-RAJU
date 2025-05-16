import java.applet.Applet; 
import java.awt.*; 
 
/* <applet code="DrawShapes" width="400" height="400"></applet> */ 
 
public class DrawShapes extends Applet  
{ 
    public void paint(Graphics g)  
   {       
        g.setColor(Color.GREEN);      // Set color  
        g.drawLine(50, 200, 300, 200);      //draw a line 
        g.setColor(Color.RED);    // Set color  
        g.drawRect(50, 50, 150, 100);   //draw a rectangle 
        g.setColor(Color.BLUE);    // Set color   
        g.drawOval(250, 50, 100, 100); //draw a circle (Oval with equal width & height) 
    } 
} 
