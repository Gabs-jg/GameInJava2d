package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 extends Cenario {

    private Window janela;
    private Scene cenario; // Isso define o arquivo que molda o cenário. Sempre usar essas classes em classes que formam o cenário
    private Jogador jogador;
    private Keyboard teclado;
    private Zumbi zumbi[];

    public Cenario1(Window janela) {
        this.janela = janela; // Pega o mesmo tamanho da janela da classe main
        cenario = new Scene(); // Instancia a cena
        cenario.loadFromFile(URL.scenario("Cenario1.txt")); // Carrega o arquivo de cenário
        jogador = new Jogador(640, 350); // Instancia o jogador em tais cooredenadas
        teclado = janela.getKeyboard();
        zumbi = new Zumbi[10];

        Som.play("musica.wav");
        run(); // Loop infinito, o mesmo da classe main
    }

    private void run() {

        for (int i = 0; i < zumbi.length; i++) {
            zumbi[i] = new Zumbi(100 * i, 100 * i);
        }

        while(true) {
            //cenario.draw();
            jogador.controle(janela, teclado);
            jogador.caminho(cenario);

            cenario.moveScene(jogador);

            jogador.x += cenario.getXOffset();
            jogador.y += cenario.getYOffset();

            for (int i = 0; i < zumbi.length; i++) {
                zumbi[i].caminho(cenario);
                zumbi[i].perseguir(jogador.x, jogador.y);
                zumbi[i].x += cenario.getXOffset();
                zumbi[i].y += cenario.getYOffset();
                zumbi[i].draw();
                jogador.atirar(janela, cenario, teclado, zumbi[i]);
                zumbi[i].morrer();
                zumbi[i].atacar(jogador);
            }

            jogador.draw();
            jogador.vida(janela);
            janela.update();

            mudarCenario();
        }
    }

    private void mudarCenario() {
        if(tileCollision(4, jogador, cenario)) {
            new Cenario2(janela);
        }
    }

}
