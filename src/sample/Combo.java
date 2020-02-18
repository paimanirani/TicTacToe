package sample;

public class Combo {
    private Tile[] tiles;

    public Combo(Tile... tiles) {
        this.tiles = tiles;
    }

    public boolean isComplete() {
        if (tiles[0].getTileTextValue().isEmpty())
            return false;
        return tiles[0].getTileTextValue().equals(tiles[1].getTileTextValue()) && tiles[0].getTileTextValue().equals(tiles[2].getTileTextValue());
    }

    public Tile[] getTiles() {
        return tiles;
    }

}
