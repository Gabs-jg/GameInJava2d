package jogo;

import jplay.Scene;
import jplay.Sound;
import jplay.URL;

import java.util.LinkedList;

public class ControleTiros {

    LinkedList<Tiro> tiros = new LinkedList<>();

    public void adicionaTiro(double x, double y, int caminho, Scene cena) {
        Tiro tiro = new Tiro(x, y, caminho);
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
        somDisparo();
    }

    public void run(Ator inimigo) {
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.removeFirst();
            tiro.mover();
            tiros.addLast(tiro);

            if(tiro.collided(inimigo)) {
                tiro.x = 10.000;
                inimigo.vida -= 250;
            }
        }
    }

    private void somDisparo() {
        new Sound(URL.audio("tiro.WAV")).play();
    }

}
