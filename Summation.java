class SumObject{
  int sumMethod(int v){
    if (v<=1){
      return 1;
    }else{
      System.out.print(".");
      return (v+(sumMethod(v-1)));
    }
  }
}
class Summation{
  public static void main(String a[]){
    int sumvalue = 0;
    int n = 30;
    SumObject s = new SumObject();
    sumvalue = s.sumMethod(n);
    System.out.println("\n" + sumvalue);
  }
}
