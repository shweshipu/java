//why did i make this?

import java.math.*;
import java.util.Scanner;
import java.io.*;
class LogPrimes{
  public static void main(String[] args) throws IOException
    {
      //file reading bit got online https://www.java-forums.org/new-java/37983-stepping-through-text-file-line-line.html
        Scanner s = new Scanner(System.in);

        File f = new File("/home/sjh/Downloads/primes/primes1.txt");
        Scanner numScan = new Scanner(f);

        String line;

        while (numScan.hasNext())
        {
            line = numScan.nextLine();
            String linetest = line.replaceAll("\\s+","");
            int i = 0;
            if(linetest.length() > 0){
              int[] primes=getints(line);
              for(i = 0;i<primes.length-1;i++){
                //System.out.println(primes[i]);
                System.out.println(); //idk what do with this tbh

              }

              /*for(i = 0;i<line.length();i++){
                if(line.substring(i,i+1) != " "){

                }
              }*/
            }
            //System.out.println(line + " ");
        }


    }
    static public int[] getints(String numbers){
      //somewhat from online
      String[] parts = numbers.split(" ");
      int[] n1 = new int[parts.length];
      for(int n = 0; n < parts.length; n++) {
        if(parts[n].length()>0)
          n1[n] = Integer.parseInt(parts[n]);
      }
      int[] n2 = fixzeros(n1);
      return(n2);
    }
    public static int[] fixzeros(int[] array){
      //copied from online https://stackoverflow.com/questions/8777217/remove-all-zeros-from-array
      int targetIndex = 0;
      for( int sourceIndex = 0;  sourceIndex < array.length;  sourceIndex++ )
      {
          if( array[sourceIndex] != 0 )
              array[targetIndex++] = array[sourceIndex];
      }
      int[] newArray = new int[targetIndex];
      System.arraycopy( array, 0, newArray, 0, targetIndex );
      return newArray;
    }
}
