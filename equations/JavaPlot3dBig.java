// use java JavaPlot3dBig 1 0 0
//if it doesnt draw blue lines at 0,0 and u get alot of yellow just re run



//code by CW Coleman / sh Steven / Sam
//save as JavaPlot.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.math.*;
//import lib.*;

public class JavaPlot3dBig extends JFrame {
   public JavaPlot3dBig()
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
          //System.out.println(x + " " + y);
          iRed = 0; iGreen = 0; iBlue = 0;
          rgb = hex(funct(x,-y));

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



  public BigDecimal funct(int inx,int iny){
    BigDecimal x=new BigDecimal(inx);
    BigDecimal y=new BigDecimal(iny);
    x =x.multiply(BigDecimal.valueOf(scale));
    y =y.multiply(BigDecimal.valueOf(scale));
    //System.out.println(x + " " + y);
    MathContext mc = new MathContext(4);
    BigDecimal z=new BigDecimal("1");
    /*try{
      z = x.divide(y);
    }catch (Exception e) {
      z = BigDecimal.valueOf(0);
    }*/


    //z = x.multiply(y);
    //z = x.multiply(x).multiply(x).add(y.multiply(y).multiply(y));
    //z = x.multiply(x).add(y.multiply(y));
    //z = x.multiply(x).subtract(y.multiply(y));
    //z = x.multiply(x).multiply(x).subtract(y.multiply(y).multiply(y));
    z = julia(x,y);
    return(z);
  }
  public BigDecimal julia(BigDecimal x , BigDecimal y){
    // y is bi
    // x is a
    // from coleman's juliaplot.java
    int iterations = 1000000;
    BigDecimal z=new BigDecimal("0");
    BigDecimal x2=new BigDecimal("0");
    int k = 0;
    int limit = iterations; // important? need to have manipulatable? is this z ?
    BigDecimal c=new BigDecimal(inc);
    BigDecimal ci=new BigDecimal(inci);
    do {
      x2 = x.multiply(x).subtract( y.multiply(y)).add(c);
      y = x.multiply(y).multiply(BigDecimal.valueOf(2)).add(ci);
      x = x2;
      z = x.multiply(x).add(y.multiply(y));
      k++;
      //System.out.println(x +" "+ y + " " + z);
      x = x.setScale(5,RoundingMode.HALF_UP);
      y = y.setScale(5,RoundingMode.HALF_UP);
    }while ((k < iterations) & ( -1 == z.compareTo(BigDecimal.valueOf(4.0))));
    return(BigDecimal.valueOf(k * 1000));
  }

  public int[] hex(BigDecimal z){
    int[] rgbtmp = {0,0,0};
    int iz = z.intValue();

    while(iz<0){
      iz += 256*256*256;
    }
    String hex=Integer.toHexString(iz);
    //System.out.println(hex + "  " + iz);

    hex ="0" + hex;
    if(iz>0){
      rgbtmp[2] = (int) Long.parseLong(hex.substring(hex.length()-2,hex.length()), 16);
    }
    if(iz>256-1){
      rgbtmp[1] = (int) Long.parseLong(hex.substring(hex.length()-4,hex.length()-2), 16);
    }
    if(iz>256*256-1){
      rgbtmp[0] = (int) Long.parseLong(hex.substring(hex.length()-6,hex.length()-4), 16);
    }
    return(rgbtmp);
  }

// execute application
static int rgb[] = new int[3];
static double scale = 1;
static int posx = 0;
static int posy = 0;
static int dimx = 1000;
static int dimy = 1000;
static double inc = 0.2;
static double inci = 0.2;
  public static void main( String a[] ){

    scale = Double.parseDouble(a[0]); //bigger for 'zoom out'
    posx = Integer.parseInt(a[1]) -dimx/2;//goes right
    posy = Integer.parseInt(a[2]) * -1 -dimy/2;//goes down
    inc = Double.parseDouble(a[3]);
    inci = Double.parseDouble(a[4]);
    JavaPlot3dBig myobject = new JavaPlot3dBig();//change this
  	   	// adapter to handle only windowClosing event
        myobject.addWindowListener(
  			   new WindowAdapter() {
				      public void windowClosing( WindowEvent event )
				          {System.exit( 0 );}
                }  // end WindowAdapter
        ); // end call to addWindowListener
   }//end main
 }// end class Painter
