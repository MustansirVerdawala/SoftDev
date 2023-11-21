package coe318.lab5;

public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  
  public int rank;
  public int suit;
  public boolean faceUp;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
    this.rank=rank;
    this.suit=suit;
    this.faceUp=faceUp;
}

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return this.faceUp; //FIX THIS
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp=faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return this.rank; //FIX THIS
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return this.suit;//FIX THIS
  }

  public boolean equals(Card c) {
    if (c.getRank()==this.getRank() && c.getSuit()==this.getSuit()){
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }
  
  public int compareTo(Card c) {//DO NOT MODIFY
    if (this.getRank()>=c.getRank()){
        if (this.getRank()==c.getRank()){
            if (this.getSuit()>=c.getSuit()){
                if (this.getSuit()==c.getSuit()){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else{
                return -1;
            }
        }
        else{
            return 1;
        }
    }
    else{
        return -1;
    }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {

      if (this.getRank()<=10){
          return toString(this.getRank());
      }
      else if (this.getRank()==11){
          return "Jack";
      }
      else if (this.getRank()==12){
          return "Queen";
      }
      else if (this.getRank()==13){
          return "King";
      }
      else{
          return "Ace";
      }
      
}

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
    
      if (this.getSuit()==0){
          return "Clubs";
      }
      else if (this.getSuit()==1){
          return "Diamonds";
      }
      else if (this.getSuit()==2){
          return "Hearts";
      }
      else{
          return "Spades";
      }
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  
  public String getFace(Card c){
      if (c.isFaceUp()){
          return c.getRankString() + " of " + c.getSuitString();
      }
      return "?";
  }
  
  
  public String toString(int i) {
    return i+""; //FIX THIS
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }

}
