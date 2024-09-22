import java.text.DecimalFormat;

/**
* House -- Creates an object that holds the information
*           for a house listing.  
* @author Monico Luis
*/
public class House {

   //Holds unique house listing.
   private int mls;
   //Holds number of bedrooms.
   private int bedrooms; 
   //Holds price of the house.
   private double price;  
   //Holds the name of the seller.
   private String seller; 
   
   /**
   * Constructor method; Creates the house object.
   * @param mls An integer that holds the house's listing number.
   * @param bedrooms An integer that holds the amount of bedrooms.
   * @param price A double that holds the price of the house. 
   * @param seller A string that holds the name of the seller. 
   * @exception HouseException Throws exception for invalid inputs. 
   */
   public House(int mls, int bedrooms, double price, 
      String seller) throws HouseException {
      setMls(mls);
      setBedrooms(bedrooms);
      setPrice(price); 
      setSeller(seller); 
   }
   
   /**
   * Set method; Sets the MLS of the house listing. 
   * @param mls An integer that holds the house's listing number. 
   * @exception HouseException Throws exception for invalid inputs. 
   */
   public void setMls(int mls) throws HouseException {
     //Checks the conditions for the MLS. 
      if (mls >= 10001 && mls <= 99999) {
         this.mls = mls;
      }
      else {
         HouseException mlsException = new HouseException("Invalid! The "
            + "MLS needs to be between 10,001 and 99,999.");
         throw (mlsException);
      }
   }
   
   /**
   * Set method; Sets the number of bedrooms of the house.
   * @param bedrooms An integer that holds the number of bedrooms. 
   * @exception HouseException Throws exception for invalid inputs. 
   */
   public void setBedrooms(int bedrooms) throws HouseException {
     //Checks the conditions for the number of bedrooms. 
      if (bedrooms >= 0 && bedrooms <= 5) {
         this.bedrooms = bedrooms; 
      }
      else {
         HouseException bedroomException =  new HouseException("Invalid! "
            + "Number of bedrooms needs to be between 0 and 5.");
         throw (bedroomException);
      }
   }
   
   /**
   * Set method; Sets the price of the house.
   * @param price A double that holds the price of the house. 
   * @exception HouseException Throws exception for invalid inputs. 
   */
   public void setPrice(double price) throws HouseException {
     //Check the conditions for the house's price. 
      if (price >= 0 && price <= 1000000) {
         this.price = price;
      }
      else {
         HouseException priceException = new HouseException("Invalid! " 
            + "Amount needs to be between $0 and $1,000,000.");
         throw (priceException);
      }
   }
      
   /**
   * Set method; Sets the seller of the house.
   * @param seller A string that holds seller of the house. 
   * @exception HouseException Throws exception for invalid inputs. 
   */
   public void setSeller(String seller) throws HouseException {
      seller = seller.trim(); //Trims the seller's name. 
      //Checks the conditions for the seller's name.
      if (seller.length() >= 2) {
         this.seller = seller;
      }
      else {
         HouseException sellerException = new HouseException("Invalid! "
            + "The seller's name must be longer than 2 characters!");
         throw (sellerException);
      }
   }
    
    /**
    * Get method; Gets the MLS of the house.
    * @return mls The MLS of the house.
    */
   public int getMls() {
      return this.mls;
   }
   
    /**
    * Get method; Gets the number of bedrooms of the house.
    * @return bedrooms The number of bedrooms. 
    */
   public int getBedrooms() {
      return this.bedrooms;
   
   }
   
   /**
   * Get method; Gets the price of the house.
   * @return price The price of the house. 
   */
   public double getPrice() {
      return this.price; 
   }
   
   /**
   * Get method; Gets the seller of the house.
   * @return seller The seller of the house. 
   */
   public String getSeller() {
      return this.seller;
   }
   
   /**
   * Returns the string representation of the object. 
   * @return output The string representation of the object.
   */
   public String toString() {
      //Creates an object that will format the price. 
      DecimalFormat priceFormatter = new DecimalFormat("$#,###,##0.00");
      String output = "The MLS is " + this.mls + "."
         + "\nThe number of bedrooms is " + this.bedrooms + "."
         + "\nThe price is " + priceFormatter.format(this.price) + "."
         + "\nThe seller is " + this.seller + ".";
      return output;
   }
   
}