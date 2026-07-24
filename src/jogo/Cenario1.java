package jogo;

import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 {

    private Window janela;
    private Scene cenario; // Isso define o arquivo que molda o cenário. Sempre usar essas classes em classes que formam o cenário

    public Cenario1(Window janela) {
        this.janela = janela; // Pega o mesmo tamanho da janela da classe main
        cenario = new Scene(); // Instancia a cena
        cenario.loadFromFile(URL.scenario("Cenario1.txt")); // Carrega o arquivo de cenário

        run(); // Loop infinito, o mesmo da classe main
    }

    private void run() {
        while(true) {
            cenario.draw();
            janela.update();
        }
    }
}
