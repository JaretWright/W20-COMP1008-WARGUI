import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameOfWarViewController implements Initializable {
    @FXML private Label p1CardRemainingLabel;
    @FXML private Label p2CardRemainingLabel;
    @FXML private ImageView player1PileImage;
    @FXML private ImageView player1ActiveCardImage;
    @FXML private ImageView player2ActiveCardImage;
    @FXML private ImageView player2PileImage;
    private GameOfWar game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new GameOfWar();
        updateCardRemainingLabel();
        player1PileImage.setImage(game.getDeck().getBackOfDeckImage());
        player2PileImage.setImage(game.getDeck().getBackOfDeckImage());
    }

    private void updateCardRemainingLabel()
    {
        p1CardRemainingLabel.setText(String.format("Cards remaining: %d",game.getP1hand().size()));
        p2CardRemainingLabel.setText(String.format("Cards remaining: %d",game.getP2hand().size()));
    }


    @FXML private void playHandButtonPushed()
    {
        //show the card to be played on the GUI
        player1ActiveCardImage.setImage(game.getP1hand().get(0).getImage());
        player2ActiveCardImage.setImage(game.getP2hand().get(0).getImage());

        //play the hand
        game.playHand(new ArrayList<Card>());

        //update the labels
        updateCardRemainingLabel();
    }

    @FXML private void playFullGame()
    {
        while (game.getGameStatus() == GameOfWar.Status.ONGOING)
        {
            game.playHand(new ArrayList<Card>());
        }
    }


}
