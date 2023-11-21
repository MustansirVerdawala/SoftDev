package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface{
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("\nHouse Holds:");
        CardPile houseCards = game.getHouseCards();
        for (int i=0; i<houseCards.getCards().size(); i++){
            Card card=houseCards.getCards().get(i);
            System.out.println(card.getFace(card));
        }
        System.out.println("\nYou Hold:");
        CardPile yourCards = game.getYourCards();
        for (int i=0; i<yourCards.getCards().size(); i++){
            Card card=yourCards.getCards().get(i);
            System.out.println(card.getFace(card));
        }
    }

  @Override
    public boolean hitMe() {
        while (true){
            System.out.println("\nAnother House?:");
            String input = user.nextLine();
            if (input.toLowerCase().equals("n")){
                return false;
            } 
            else if (input.toLowerCase().equals("y")){
                return true;
            }
            else{
                System.out.println("\nInvalid Input \nTry Again");
            }
        }
    }

  @Override
    public void gameOver() {
        int houseScore=game.score(game.getHouseCards());
        int yourScore=game.score(game.getYourCards());
        display();
        System.out.println("\nYour Score: "+yourScore);
        System.out.println("\nHouse Score: "+houseScore);
        if (yourScore>21){
            System.out.println("\nHouse Wins");
        }
        else if (houseScore>21 || yourScore>houseScore){
            System.out.println("\nYou Win");
        }
        else{
            System.out.println("\nHouse Wins");
        }
    }

}
