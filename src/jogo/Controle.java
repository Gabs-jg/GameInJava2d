package jogo;

import jplay.GameObject;
import jplay.TileInfo;

public class Controle {

    public boolean colisao(GameObject obj, TileInfo tile) {
        if((tile.id >= 7) && obj.collided(tile)) { // Pega o id do tile do arquivo Cenario1.txt e verifica se o obj ta colidindo com os tiles não atravessáveis.
            return true;
        }
        return false;
    }

}
