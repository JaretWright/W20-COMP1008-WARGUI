import java.util.ArrayList;
import java.util.EnumMap;

public class GameOfWar {

    public enum Status {ONGOING, DONE}

    private DeckOfCards deck;
    private ArrayList<Card> p1hand;
    private ArrayList<Card> p2hand;
    private Status gameStatus;
    private Card p1Card;
    private Card p2Card;

    public GameOfWar()
    {
        gameStatus = Status.ONGOING;
        deck = new DeckOfCards();
        deck.shuffle();
        p1hand = new ArrayList<>();
        p2hand = new ArrayList<>();

        deck.shuffle();
        for (int count=1; count<=52; count++)
        {
            if (count%2!=0)
                p1hand.add(deck.dealTopCard());
            else
                p2hand.add(deck.dealTopCard());
        }

        System.out.printf("hand 1 cards: %d    hand 2 cards: %d%n",
                        p1hand.size(), p2hand.size());
    }

    private Card getP1Card()
    {
        if (gameStatus == Status.ONGOING)
            return p1hand.remove(0);
        else
            return null;
    }

    private Card getP2Card()
    {
        if (gameStatus == Status.ONGOING)
            return p2hand.remove(0);
        else
            return null;
    }

    public DeckOfCards getDeck() {
        return deck;
    }

    public ArrayList<Card> getP1hand() {
        return p1hand;
    }

    public void playHand(ArrayList<Card> pile)
    {
        System.out.printf("P1 Cards: %d     P2 Cards: %d %n",p1hand.size(), p2hand.size());

        if (gameStatus == Status.ONGOING) {
            p1Card = getP1Card();

            p2Card = getP2Card();

            pile.add(p1Card);
            pile.add(p2Card);
            if (p1Card.getFaceValue() > p2Card.getFaceValue())
                p1hand.addAll(pile);
            else if (p1Card.getFaceValue() < p2Card.getFaceValue())
                p2hand.addAll(pile);
            else // war
            {
                //check if both players have at 4 cards left
                if (p1hand.size() < 4) {
                    p2hand.addAll(p1hand);
                    gameStatus = Status.DONE;
                } else if (p2hand.size() < 4) {
                    p1hand.addAll(p2hand);
                    gameStatus = Status.DONE;
                }
                //both players add 3 cards to the pile
                for (int i = 1; i <= 3; i++) {
                    pile.add(getP1Card());
                    pile.add(getP2Card());
                }
                playHand(pile);
            }
        }
    }

    public ArrayList<Card> getP2hand() {
        return p2hand;
    }

    public Status getGameStatus() {
        return gameStatus;
    }
}
