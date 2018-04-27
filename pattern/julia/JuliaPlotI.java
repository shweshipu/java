//code by CW Coleman
//save as JuliaPlotI.java
//...............   c    ci limit red green blue redAjust greenAjust blueAjust scale
//java JuliaPlotI .34567 .5 0  10 20 30 10 20 30 250
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JuliaPlotI extends JFrame {
   public JuliaPlotI()
   {
      super( "Julia Set" );
      setSize(1000,1030);
      setVisible( true );
   }

   public void paint( Graphics g ){
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		    // only change code below this line
        // double c1 c2 limit int ired, igreen, iblue,redAjust, greenAjust, blueAjust
      //  double c1 = 0.36;
    //    double c2 = 0.545;
    //    double  limit = 10;

      //  int ired, igreen, iblue,redAjust, greenAjust, blueAjust;
        int ared[] = new int[256];
        int agreen[] = new int[256];
	      int ablue[] = new int[256];
	      int i;
        int rval = 0;
	    	int  j,p;
        int k = 0;
	      double x,y,x1,x2,y1,z;
		    double id, jd;
		    int iterations = 1000;
        g.setColor(new Color(255,255,255));
  			g.fillRect(0,0,1000,1030);
        // build colors
      //  ired = 0; igreen = 100; iblue = 0;
      //  redAjust = 0; greenAjust = -10; blueAjust = 0;
        // change the above
        System.out.println(ired+" "+igreen+" "+iblue);
          for (i = 0; i < 256;i++){
              ared[i] = ired;
            	agreen[i] = igreen;
        			ablue[i] = iblue;
        			ired = ired+redAjust;
        			igreen = igreen+greenAjust;
        			iblue = iblue+blueAjust;
        		      if (ired > 255) ired = 0;if (ired < 0) ired = 255;
                  if (igreen > 255) igreen = 0;if (igreen < 0) igreen = 255;
        		      if (iblue > 255) iblue = 0;if (iblue < 0) iblue =  255;
        	}
		//	g.setColor(new Color(255,255,255));
		//	g.fillRect(0,0,500,500);
		for (j = 0 + camposy ; j < 1000 + camposy ; j++) {
			jd = (double) j;
			y1 = (500 - jd) / scale;
				for (i = 0+camposx; i < 1000 + camposx; i++){
					id = (double) i;
					x1 = (id - 500) / scale;
					x = x1;
					y = y1;
					z = 0.0;
					k = 0;
					do {
						x2 = (x * x) - (y * y) + c1;
						y = (2 * x * y) + c2;
						x = x2;
						z = (x * x) + (y * y);
						k++;
					}while ((k < iterations) & (z < 4.0));
						if (k > limit) {
							if (k > 255) k = 255;
							g.setColor(new Color(ared[k],agreen[k],ablue[k]));
							g.drawLine(i-camposx,j-camposy,i-camposx,j-camposy);
						}
	    	}//end for i
        }//end for j
      // only change code above this line
      // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  }
// execute application
// globals
//double c1, c2, limit, int ired, igreen, iblue,redAjust, greenAjust, blueAjust
static double c1;
static double c2 ;
static double  limit;
static int ired, igreen, iblue,redAjust, greenAjust, blueAjust;
static int scale ;
static int camposx;
static int camposy;
  public static void main( String a[] ){
    c1 = Double.parseDouble(a[0]);
    c2 = Double.parseDouble(a[1]);
    limit = Double.parseDouble(a[2]);
   ired = Integer.parseInt(a[3]);
  igreen = Integer.parseInt(a[4]);
     iblue = Integer.parseInt(a[5]);
     redAjust = Integer.parseInt(a[6]);
     greenAjust = Integer.parseInt(a[7]);
   blueAjust = Integer.parseInt(a[8]);
   scale = Integer.parseInt(a[9]);
   camposx = Integer.parseInt(a[10]);
   camposy = Integer.parseInt(a[11]);
      System.out.println(ired+" "+igreen+" "+iblue);
    JuliaPlotI myobject = new JuliaPlotI();//change this
  	   	// adapter to handle only windowClosing event
        myobject.addWindowListener(
  			   new WindowAdapter() {
				      public void windowClosing( WindowEvent event )
				          {System.exit( 0 );}
                }  // end WindowAdapter
        ); // end call to addWindowListener
   }//end main
 }// end class Painter
