//code by CW Coleman
//save as JavaPlot.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JavaPlot3d extends JFrame {
   public JavaPlot3d()
   {
      super( "Java Plot" );
      setSize(400,400);
      setVisible( true );
   }
   public void paint( Graphics g ){
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		    // only change code below this line
        int x, y, h, k, t;
        int iRed, iGreen, iBlue, aiRed, aiGreen, aiBlue;//integer RGB
        x = 0;  y = 0; h = 0; k = 0; t = 0;

        //blank start
        for (x = 0;x <400;x++){
          for (y = 0; y < 400;y++){
              iRed = 155; iGreen = 155; iBlue = 155;
              g.setColor(new Color(iRed,iGreen,iBlue));
              g.drawLine(x,y,x,y);

          }

      }//end for


      /*
      iRed = 255; iGreen = 255; iBlue = 255;
        g.setColor(new Color(iRed,iGreen,iBlue));
        h = -200;
        k = 0;
      for (x = 0;x < 400;x++){
        k =  3*h -10;
        h++;

        g.drawLine(h+200,200-k,h+200,200-k);
        System.out.println(h+"<-x k->"+k);
      }
      */

      //Graph 3d

      for (x = 0;x <400;x++){
        for (y = 0; y < 400;y++){
          iRed = 0; iGreen = 0; iBlue = 0;
          //get the z value
          iGreen = funct(x,y);
          //fix bounds with other colors
          if (iGreen>255){
            iRed = 255;
            iGreen = 255;
          }
          if (iGreen<0){
            iRed = 255;
            iBlue = 255;
            iGreen = 0;
          }
          g.setColor(new Color(iRed,iGreen,iBlue));
          g.drawLine(x,y,x,y);

        }
      }
    //make axis
    iRed = 0; iGreen = 0; iBlue = 255;
    g.setColor(new Color(iRed,iGreen,iBlue));
    g.drawLine(0,200,400,200);
    g.drawLine(200,0,200,400);

  }
  public int funct(int x,int y){
    return(y/x);
  }

// execute application
  public static void main( String args[] ){
    JavaPlot myobject = new JavaPlot();//change this
  	   	// adapter to handle only windowClosing event
        myobject.addWindowListener(
  			   new WindowAdapter() {
				      public void windowClosing( WindowEvent event )
				          {System.exit( 0 );}
                }  // end WindowAdapter
        ); // end call to addWindowListener
   }//end main
 }// end class Painter
