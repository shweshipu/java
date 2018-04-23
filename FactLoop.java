//save as FactLoop.java,then compile, then run by typing java FactLoop
class FactLoop{
  public static void main(String a[]){
    int value = Integer.parseInt(a[0]);
    int product = 1; //note the change to a 1
    int i;
    for(i=1;i<=value;i++){
      product*=i;

    }
    System.out.println(product);
  }
}
