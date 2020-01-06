import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {
    private int faceValue;
    private String suit, faceName;
    private Image image;

    public Card(int faceValue, String suit) {
        setFaceValue(faceValue);
        setSuit(suit);
        setFaceName();
        image = new Image("./images/"+toString()+".jpg");
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static List<String> getValidSuits()
    {
        List<String> suits = Arrays.asList("spades", "hearts", "diamonds","clubs");
        return suits;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        if (faceValue>=2 && faceValue<=14)
            this.faceValue = faceValue;
        else
            throw new IllegalArgumentException("face value must be in the range 2-14");
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        List<String> suits = getValidSuits();
        if (suits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException("suit must be in the collection: "+suits);
    }

    public String getFaceName() {
        return faceName;
    }

    private void setFaceName() {
        String[] names={"2","3","4","5","6","7","8","9",
                        "10", "jack", "queen", "king", "ace"};
        faceName = names[faceValue-2];
    }

    public String toString()
    {
        return String.format("%s of %s", getFaceName(), getSuit());
    }
}
