package jogo;

import jplay.*;
import jplay.Window;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Jogador extends Ator {

    static double vida = 10000;

    public Jogador(int x, int y) {
        super(URL.sprite("jogador.png"), 20);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000); // Troca de frames na tela
    }

    ControleTiros tiros = new ControleTiros();

    public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo) {
        if(teclado.keyDown(KeyEvent.VK_A)) {
            tiros.adicionaTiro(x + 2, y + 10, direcao, cena);
        }
        tiros.run(inimigo);
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

    Font f = new Font("arial", Font.BOLD, 30);

    public void vida(Window janela) {
        janela.drawText("Vida: " + Jogador.vida, 30, 30, Color.GREEN, f);
    }

}
