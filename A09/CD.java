public class CD implements Comparable{
   private String sAlbum = "";
   private String sArtist = "";
   private double dPrice = 0.0;
   private int iStock = 0;
   
   public CD(String sArtist, String sAlbum, double dPrice, int iStock)throws Exception{
      this.setAlbum(sAlbum);
      this.setArtist(sArtist);
      this.setPrice(dPrice);
      this.setStock(iStock);
   }
   
   public int compareTo(Object o){
      CD c = (CD)o;
      if(this.getPrice( )< c.getPrice( )) 
         return -1;
      if(this.getPrice( )> c.getPrice( )) 
         return 1;
      return 0; 
   }
   
   public String toString( ){
      String s = "";
      s = s+ "Album: " + this.sAlbum;
      s = s+ "\nArtist: " + this.sArtist;
      s = s+ "\nPrice: " + this.dPrice;
      if(iStock==0){
         s = s+ "\nNot in stock";
      }
      else{
         s = s+ "\nCurrently" + " " + this.iStock + " " + "in stock";
      }
      return s;
   }
   
   public void setAlbum(String newsAlbum)throws Exception{
      if(newsAlbum.trim( ).length( )<1){
         CDException ce = new CDException( );
         ce.setMessage("Album name contains no characters," + "\nCannot create CD");
         throw ce;
      }
      else{
         this.sAlbum=newsAlbum;
      }
   }	
   
   public void setArtist(String newsArtist)throws Exception{
      if(newsArtist.trim( ).length( )<1){
         CDException ce = new CDException( );
         ce.setMessage("Artist name contains no characters," + "\nCannot create CD");
         throw ce;
      }
      else{
         this.sArtist=newsArtist;
      }
   }
     
   
   public boolean equals(Object o){
      CD other = (CD)o;
      if(other.getArtist( ).equals(this.getArtist( ))){ //string equals
         return true;
      }
      return false;       
   }
 
   private void setPrice(double newdPrice)throws Exception{
      if(newdPrice >= 0){
         this.dPrice = newdPrice;
      }
      else{
         CDException ce = new CDException( );
         ce.setMessage("CD price cannot be negative" + "\nCannot create CD");
         throw ce; 
      }	
   }   
   
   public void setStock(int newiStock)throws Exception{
      if(newiStock>=0){
         this.iStock=newiStock;
      }
      else{
         CDException ce = new CDException( );
         ce.setMessage("Stock number cannot be negative.");
         throw ce;
      }	
   }


   public String getArtist( ){
      return this.sArtist;
   }
   
   public double getPrice( ){
      return this.dPrice;
   }
   
   public int getInStock( ){
      return this.iStock;
   }
       
   public String getAlbum( ){
      return this.sAlbum;
   }   
}