// use java JavaPlot3d 1 0 0
//if it doesnt draw blue lines at 0,0 and u get alot of yellow just re run



//code by CW Coleman
//save as JavaPlot.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class JavaPlot3d extends JFrame {
   public JavaPlot3d()
   {
      super( "Java Plot" );
      setSize(dimx,dimy + 30);
      setVisible( true );
   }
   public void paint( Graphics g ){
        //clear stuff. (unnecessary?)
        int x, y, h, k, t;
        int iRed, iGreen, iBlue, aiRed, aiGreen, aiBlue;//integer RGB
        x = 0;  y = 0; h = 0; k = 0; t = 0;

        //blank start
        for (x = 0;x <dimx;x++){
          for (y = 0; y < dimy + 30;y++){
              iRed = 255; iGreen = 255; iBlue = 255;
              g.setColor(new Color(iRed,iGreen,iBlue));
              g.drawLine(x,y,x,y);

          }

      }
      //Graph 3d
      for (x = 0 + posx;x <dimx + posx;x++){
        for (y = 0 + posy; y < dimy + posy;y++){
          iRed = 0; iGreen = 0; iBlue = 0;
          rgb = hex(funct(x,y));
          //get the z value
          iGreen = ((int)funct(x,y));
          //fix bounds with other colors
          if (iGreen>255){
            iRed = ((int)funct(x,y))%256;
            iGreen = ((int)funct(x,y))%256;
          }
          if (iGreen<0){
            iRed =255 + ((int)funct(x,y))%256;
            iBlue = 255 + ((int)funct(x,y))%256;
            iGreen = 0;
          }
          if(funct(x,y) == 0){//color zero
            iRed = 255; iGreen = 255; iBlue = 255;
          }
          if(funct(x,y) == 1){//color one
            iRed = 127; iGreen = 127; iBlue = 127;
          }
          //g.setColor(new Color(iRed,iGreen,iBlue));
          g.setColor(new Color(rgb[0],rgb[1],rgb[2]));
          g.drawLine(x-posx,y+30-posy,x-posx,y+30-posy);

        }
      }
    //make axis
     posx += dimx/2;
     posy += dimy/2;
    iRed = 0; iGreen = 0; iBlue = 255;
    g.setColor(new Color(iRed,iGreen,iBlue));
    if(dimy/2 + 30 - posy>=0 && dimy/2 + 30 - posy <= dimy ){
      g.drawLine(0,dimy/2 +30 - posy,dimx,dimy/2 +30 -posy);
    }
    if(dimx/2 - posx>=0 && dimx/2 - posx<=dimy){
      g.drawLine(dimx/2  - posx,30,dimx/2 - posx,dimy + 30);
    }

  }
  public double funct(int x,int y){
    double dubx=((double)x)*scale;
    double duby=((double)y)*scale;

    return((
      /*
      (int)  Math.sqrt(
              (double)(y*y + x*x)
              )
              *2
      *255/400
      */
      Math.pow(dubx,duby)
      //x*y

    ));
  }
  public int[] hex(double z){
    int rgbtmp[] = new int[3];
    if(z<0){
      z = 256*256*256-z;
    }
    int iz = (int) z;

    int b = iz%256;
    rgbtmp[2] = b;
    iz = iz-b;
    System.out.println(iz);
    if(iz>0){
      int g = iz%(256*256);
      rgbtmp[1] = g;
      iz = iz-g;
    }
    if(iz>0){
      int r = iz%(256*256*256);
      rgbtmp[0] = r;
      iz = iz-r;
    }

    if(rgbtmp[0]>=256){
      rgbtmp[0] = 255;
    }
    System.out.println(z + " " +rgbtmp[0] + " " + rgbtmp[1] + " "+  rgbtmp[2]);
    return(rgbtmp);
  }

// execute application
static int rgb[] = new int[3];
static double scale = 1;
static int posx = 0;
static int posy = 0;
static int dimx = 400;
static int dimy = 400;
  public static void main( String a[] ){

    scale = Double.parseDouble(a[0]); //bigger for 'zoom out'
    posx = Integer.parseInt(a[1]) -dimx/2;//goes right
    posy = Integer.parseInt(a[2]) -dimy/2;//goes down
    JavaPlot3d myobject = new JavaPlot3d();//change this
  	   	// adapter to handle only windowClosing event
        myobject.addWindowListener(
  			   new WindowAdapter() {
				      public void windowClosing( WindowEvent event )
				          {System.exit( 0 );}
                }  // end WindowAdapter
        ); // end call to addWindowListener
   }//end main
 }// end class Painter
