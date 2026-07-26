package jogo;

import jplay.URL;

public class Zumbi extends Ator {



    public Zumbi(int x, int y) {
        super(URL.sprite("Zumbi0.png"), 16);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
        this.velocidade = 0.03;
    }

    public void perseguir(double x, double y) {
        if(this.x > x && this.y <= y + 50 && this.y >= y - 50) { // pra direita
            moveTo(x, y, velocidade);
            if(direcao != 1) {
                setSequence(4, 8);
                direcao = 1;
            }
            movendo = true;
        }

        else if(this.x < x && this.y <= y + 50 && this.y >= - 50) { // pra esquerda
            moveTo(x, y, velocidade);
            if(direcao != 2) {
                setSequence(9, 12);
                direcao = 2;
            }
            movendo = true;
        }

        else if(this.y > y) { // pra cima
            moveTo(x, y, velocidade);
            if(direcao != 4) {
                setSequence(12, 16);
                direcao = 4;
            }
            movendo = true;
        }

        else if(this.y < y) { // pra baixo
            moveTo(x, y, velocidade);
            if(direcao != 3) {
                setSequence(0, 4);
                direcao = 3;
            }
            movendo = true;
        }

        if(movendo) {
            update();
            movendo = false;
        }
    }

    public void morrer() {
        if(this.vida <= 0) {
            this.velocidade = 0;
            //this.ataque = 0;
            this.direcao = 0;
            this.movendo = false;
            this.x = 1000000;
        }
    }

}
