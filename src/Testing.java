public class Testing {
    public static void main(String[] args)
    {
        Card aceOfSpades = new Card(14, "spades");
        Card twoOfHearts = new Card(2, "hearts");
        System.out.printf("%s%n",aceOfSpades);
        System.out.printf("%s%n",twoOfHearts);
        System.out.printf("Ace is bigger than two: %b%n",
                            aceOfSpades.getFaceValue()>twoOfHearts.getFaceValue());

        DeckOfCards deck = new DeckOfCards();
        System.out.printf("Cards in the deck %d%n", deck.getNumOfCardsInDeck());
        System.out.printf("%s%n", deck.toString());

        deck.shuffle();

        System.out.printf("%nAfter Suffle:%n%s%n", deck.toString());
    }
}
