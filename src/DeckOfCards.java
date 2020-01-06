import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<Card> deck;
    private Image backOfDeckImage;

    public DeckOfCards() {
        backOfDeckImage = new Image("./images/blue_back.jpg");
        List<String> suits = Card.getValidSuits();
        deck = new ArrayList<>();
        for (String suit:suits)
        {
            for (int cardValue = 2; cardValue<=14; cardValue++)
            {
                deck.add(new Card(cardValue, suit));
            }
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public Image getBackOfDeckImage() {
        return backOfDeckImage;
    }

    public void setBackOfDeckImage(Image backOfDeckImage) {
        this.backOfDeckImage = backOfDeckImage;
    }

    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    public int getNumOfCardsInDeck()
    {
        return deck.size();
    }

    public String toString()
    {
        String cards = "";
        for (Card card:deck)
        {
            cards = cards + card + "\n";
        }
        return cards;
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }
}
