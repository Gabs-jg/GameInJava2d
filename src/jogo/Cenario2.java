package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario2 extends Cenario{

    private Window janela;
    private Scene cenario;
    private Jogador jogador;
    private Keyboard teclado;
    private Zumbi zumbi;

    public Cenario2(Window window) {
        janela = window;
        cenario = new Scene();
        cenario.loadFromFile(URL.scenario("interno.txt"));
        jogador = new Jogador(140, 150);
        teclado = janela.getKeyboard();
        zumbi = new Zumbi(1000, 1000);
        Som.play("musica.wav");
        run();
    }

    public void run() {
        while(true) {
            jogador.controle(janela, teclado);
            jogador.caminho(cenario);
            cenario.moveScene(jogador);
            zumbi.caminho(cenario);
            zumbi.perseguir(jogador.x, jogador.y);

            jogador.x += cenario.getXOffset();
            jogador.y += cenario.getYOffset();

            jogador.atirar(janela, cenario, teclado, zumbi);
            jogador.draw();
            janela.update();
        }
    }
}
