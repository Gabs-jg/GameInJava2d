package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Window janela = new Window(800, 600); // Cria uma janela de 800x600px
        GameImage plano = new GameImage(URL.sprite("menu.png")); // Imagem que usa como menu do jogo
        Keyboard teclado = janela.getKeyboard(); // Instancia um teclado a partir da janela.

        while(true) {
            plano.draw(); // Desenha o plano de fundo (menu)
            janela.update(); // Atualiza a janela

            if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                JOptionPane.showMessageDialog(null, "Funcuionado");
            }
        }
    }
}