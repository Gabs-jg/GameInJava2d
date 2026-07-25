package jogo;

import jplay.*;
import jplay.Window;

import java.awt.*;

public class Jogador extends Ator {



    public Jogador(int x, int y) {
        super(URL.sprite("jogador.png"), 20);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000); // Troca de frames na tela
    }

    public void controle(Window janela, Keyboard teclado) {
        if(teclado.keyDown(Keyboard.LEFT_KEY)) {
            if(this.x > 0) {
                this.x -= velocidade;
            }
            if(direcao != 1) {
                setSequence(4, 8);
                direcao = 1;
            }
            movendo = true;
        }

        if(teclado.keyDown(Keyboard.RIGHT_KEY)) {
            if(this.x < janela.getWidth() - 40) {
                this.x += velocidade;
            }
            if(direcao != 2) {
                setSequence(8, 12);
                direcao = 2;
            }
            movendo = true;
        }

        if(teclado.keyDown(Keyboard.UP_KEY)) {
            if(this.y > 0) {
                this.y -= velocidade;
            }
            if(direcao != 4) {
                setSequence(12, 16);
                direcao = 4;
            }
            movendo = true;
        }

        if(teclado.keyDown(Keyboard.DOWN_KEY)) {
            if(this.y < janela.getHeight() - 50) {
                this.y += velocidade;
            }
            if(direcao != 5) {
                setSequence(0, 4);
                direcao = 5;
            }
            movendo = true;
        }

        if(movendo) {
            update();
            movendo = false;
        }
    }

}
