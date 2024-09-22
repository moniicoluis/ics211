public class test{

   public static void main(String[] args) {
      print(30); 
      print2(42);
   }
   
   private static void print(int i) {
      if(i>42)
         return;
      System.out.println(i);
      print(i+3);
   }
   
   public static void print2(int i) {
      if (i < 30) { 
         return;
      }
      else {
         System.out.println(i);
         print2(i - 3); 
      }
   }
}
