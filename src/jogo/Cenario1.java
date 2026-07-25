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

    public Cenario1(Window janela) {
        this.janela = janela; // Pega o mesmo tamanho da janela da classe main
        cenario = new Scene(); // Instancia a cena
        cenario.loadFromFile(URL.scenario("Cenario1.txt")); // Carrega o arquivo de cenário
        jogador = new Jogador(640, 350); // Instancia o jogador em tais cooredenadas
        teclado = janela.getKeyboard();
        Som.play("musica.wav");
        run(); // Loop infinito, o mesmo da classe main
    }

    private void run() {
        while(true) {
            //cenario.draw();
            jogador.controle(janela, teclado);
            jogador.caminho(cenario);

            cenario.moveScene(jogador);

            jogador.x += cenario.getXOffset();
            jogador.y += cenario.getYOffset();

            jogador.draw();
            janela.update();

        }
    }
}
