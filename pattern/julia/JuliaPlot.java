//code by CW Coleman
//save as JuliaPlot.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JuliaPlot extends JFrame {
   public JuliaPlot()
   {
      super( "Julia Set" );
      setSize(600,630);
      setVisible( true );
   }
   public void paint( Graphics g ){
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		    // only change code below this line
        double c1 = 0.345;
        double c2 = 0.565;
        double   limit = 10;

        int ired, igreen, iblue,redAjust, greenAjust, blueAjust;

        int ared[] = new int[256];
        int agreen[] = new int[256];
	int ablue[] = new int[256];
	int i;

	int rval = 0;
	    	int  j,p;
		int k = 0;
	    	double x,y,x1,x2,y1,z;
		double id, jd;
		int Iterations = 1000;
      g.setColor(new Color(255,255,255));
			g.fillRect(0,0,600,630);
// build colors
ired = 0; igreen = 100; iblue = 0;
redAjust = 0; greenAjust = -10; blueAjust = 0;
// change the above
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
		for (j = 0 ; j < 600 ; j++) {
			jd = (double) j;
			y1 = (300 - jd) / 150;
				for (i = 0; i < 600; i++){
					id = (double) i;
					x1 = (id - 300) / 150;
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
					}while ((k < Iterations) & (z < 4.0));
						if (k > limit) {
							if (k > 255) k = 255;
								g.setColor(new Color(ared[k],agreen[k],ablue[k]));
							g.drawLine(i,j,i,j);
						}
	    	}//end for i
        }//end for j
      // only change code above this line
      // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


  }

// execute application
  public static void main( String args[] ){
    JuliaPlot myobject = new JuliaPlot();//change this
  	   	// adapter to handle only windowClosing event
        myobject.addWindowListener(
  			   new WindowAdapter() {
				      public void windowClosing( WindowEvent event )
				          {System.exit( 0 );}
                }  // end WindowAdapter
        ); // end call to addWindowListener
   }//end main
 }// end class Painter
