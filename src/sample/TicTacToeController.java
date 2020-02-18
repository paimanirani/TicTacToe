package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeController {
    private Player player1;
    private Player player2;
    private static boolean playerFlag = false;
    private static boolean playable = true;
    private Tile tile;
    private static Tile[][] board;
    private static List<Combo> combos;
    private static Pane root;

    public TicTacToeController(Pane root) {
        player1 = new Player("X");
        player2 = new Player("O");
        this.tile = new Tile();
        this.combos = new ArrayList<>();
        this.root = root;
    }

    public Player getPlayer() {
        playerFlag = !playerFlag;
        if (playerFlag) {
            return player1;
        }
        return player2;

    }


    public void ticTacToeEvent() {
        this.tile.setOnMouseClicked(event -> {
            if (!playable) {
                return;
            }
            if (!"".equals(this.tile.getTileTextValue())) {
                return;
            }
            this.tile.drawText(getPlayer().getValue());
            checkState();
        });
    }


    public void checkState() {
        for (Combo combo : combos) {
            if (combo.isComplete()) {
                playable = false;
                playWinAnimation(combo);
                break;
            }
        }
    }

    private void playWinAnimation(Combo combo) {
        Line line = new Line();
        line.setStartX(combo.getTiles()[0].getCenterX());
        line.setStartY(combo.getTiles()[0].getCenterY());
        line.setEndX(combo.getTiles()[0].getCenterX());
        line.setEndY(combo.getTiles()[0].getCenterY());

        root.getChildren().add(line);

        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
                new KeyValue(line.endXProperty(), combo.getTiles()[2].getCenterX()),
                new KeyValue(line.endYProperty(), combo.getTiles()[2].getCenterY())));
        timeLine.play();
    }


    public void checkHorizontal() {
        for (int i = 0; i < 3; i++) {
            combos.add(new Combo(board[0][i], board[1][i], board[2][i]));
        }
    }


    public void checkVertical() {
        for (int i = 0; i < 3; i++) {
            combos.add(new Combo(board[i][0], board[i][1], board[i][2]));
        }
    }

    public void checkDiagonals() {
        combos.add(new Combo(board[0][0], board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0], board[1][1], board[0][2]));
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }

    public Tile setTile() {
        this.tile.setBorderFeature();
        this.tile.setTextFeature();

        ticTacToeEvent();
        this.tile.setAlignment(Pos.CENTER);
        this.tile.getChildren().addAll(this.tile.getTileText(), this.tile.getTileBorder());
        return this.tile;
    }
}
