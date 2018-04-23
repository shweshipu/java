//save as SumLoop.java,then compile, then run by typing java SumLoop
class SumLoop{
  public static void main(String a[]){
    int value = Integer.parseInt(a[0]);
    int sum = 0;
    int i;
    for(i=1;i<=value;i++){
      sum+=i;

    }
    System.out.println(sum);
  }
}
