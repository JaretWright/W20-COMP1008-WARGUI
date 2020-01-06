import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DeckViewController implements Initializable {

    @FXML private ImageView deckImage;
    @FXML private ImageView cardImage;
    private DeckOfCards deck;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deck = new DeckOfCards();
        deckImage.setImage(deck.getBackOfDeckImage());
        cardImage.setImage(deck.dealTopCard().getImage());
    }

    @FXML
    private void showNextCard()
    {
        cardImage.setImage(deck.dealTopCard().getImage());
    }

    @FXML
    private void shuffle()
    {
        deck.shuffle();
    }
}
