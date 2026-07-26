package jogo;

import jplay.*;


public class Main {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        Window janela = new Window(width, height); // Cria uma janela de 800x600px
        GameImage plano = new GameImage(URL.sprite("menu.png")); // Imagem que usa como menu do jogo
        Keyboard teclado = janela.getKeyboard(); // Instancia um teclado a partir da janela.

        // Criar menu: Criar uma classe com a implementação acima e chamar no loop infinito

        while(true) {
            plano.draw(); // Desenha o plano de fundo (menu)
            janela.update(); // Atualiza a janela

            if(teclado.keyDown(Keyboard.ENTER_KEY)) { // Se a tecla enter for pressionada ir para outro cenário.
                new Cenario1(janela);
            }


        }


    }
}