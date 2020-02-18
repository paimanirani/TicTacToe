package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoardMain extends Application {

    private Tile[][] board = new Tile[3][3];
    private TicTacToeController controller;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600, 600);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.controller = new TicTacToeController(root);
                Tile tile = controller.setTile();
                tile.setTranslateX(i * 200);
                tile.setTranslateY(j * 200);
                root.getChildren().add(tile);
                this.board[i][j] = tile;

            }
        }

        controller.setBoard(this.board);
        controller.checkHorizontal();
        controller.checkVertical();
        controller.checkDiagonals();
        return root;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
