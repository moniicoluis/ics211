public class UsingMath{

   public static void main(String arg[ ]){
      
      double d1 = 8.5;   
      double d2 = -27.12;
      int i1=27;
      int i2=8;
      
      MathMethods mm = new MathMethods( );
      
      System.out.println(mm.add(d1,d2));
      System.out.println(mm.absoluteValue(d2));
      System.out.println(mm.isEven(i1));
      System.out.println(mm.isEven(i2));
   }
}