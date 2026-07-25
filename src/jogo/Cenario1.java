package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 {

    private Window janela;
    private Scene cenario; // Isso define o arquivo que molda o cenário. Sempre usar essas classes em classes que formam o cenário
    private Jogador jogador;
    private Keyboard teclado;
    private Zumbi zumbi;

    public Cenario1(Window janela) {
        this.janela = janela; // Pega o mesmo tamanho da janela da classe main
        cenario = new Scene(); // Instancia a cena
        cenario.loadFromFile(URL.scenario("Cenario1.txt")); // Carrega o arquivo de cenário
        jogador = new Jogador(640, 350); // Instancia o jogador em tais cooredenadas
        teclado = janela.getKeyboard();
        zumbi = new Zumbi(300, 300);

        Som.play("musica.wav");
        run(); // Loop infinito, o mesmo da classe main
    }

    private void run() {
        while(true) {
            //cenario.draw();
            jogador.controle(janela, teclado);
            jogador.caminho(cenario);
            zumbi.caminho(cenario);
            zumbi.perseguir(jogador.x, jogador.y);

            cenario.moveScene(jogador);

            jogador.x += cenario.getXOffset();
            jogador.y += cenario.getYOffset();

            zumbi.x += cenario.getXOffset();
            zumbi.y += cenario.getYOffset();

            jogador.draw();
            zumbi.draw();
            janela.update();

        }
    }
}
