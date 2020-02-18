package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    private Text text;
    private Rectangle border;


    public void setBorderFeature() {
        border = new Rectangle(200, 200);
        border.setFill(null);
        border.setStroke(Color.BLACK);

    }

    public void setTextFeature() {
        text = new Text();
        text.setFont(Font.font(72));

    }

    public void drawText(String player) {
        this.text.setText(player);
    }

    public Text getTileText() {
        return this.text;
    }

    public Rectangle getTileBorder() {
        return this.border;
    }

    public String getTileTextValue() {
        return this.text.getText();
    }

    public double getCenterX() {
        return this.getTranslateX() + 100;
    }

    public double getCenterY() {
        return this.getTranslateY() + 100;
    }

}
