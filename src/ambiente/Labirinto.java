package ambiente;

import agente.AgenteLabirinto;
import geral.PosicaoXY;
import java.util.Random;

public class Labirinto {

    private int tamanhoLabirinto;
    private String[][] labirinto;
    private AgenteLabirinto agente;
    private Random random;

    
    
    public Labirinto(int tamanhoLabirinto) {
        this.tamanhoLabirinto = tamanhoLabirinto;
        this.random = new Random();
        this.construirNovoLabirinto();
    }
    
    
    private void construirNovoLabirinto() {
        labirinto = new String[this.tamanhoLabirinto][this.tamanhoLabirinto];
        for (int i = 0; i < this.tamanhoLabirinto; i++) {
            for (int j = 0; j < this.tamanhoLabirinto; j++) {
                if (random.nextBoolean()) {
                    this.labirinto[i][j] = "P"; 
                } else {
                    this.labirinto[i][j] = "A"; 
                }
            }
        }
    }
    
    public void exibirLabirinto() {
        atualizarPosicaoAgente();
        for (int i = 0; i < tamanhoLabirinto; i++) {
            for (int j = 0; j < tamanhoLabirinto; j++) {
                if (labirinto[i][j].equals("*A*")) {
                    System.out.print("|" + labirinto[i][j] + "|");
                } else {
                    System.out.print("| " + labirinto[i][j] + " |");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private void atualizarPosicaoAgente() {
        if (this.agente != null) {
            PosicaoXY posAgente = this.agente.getPosicao();
            if (!labirinto[posAgente.getPosX()][posAgente.getPosY()].equals("L")) {
                labirinto[posAgente.getPosX()][posAgente.getPosY()] = "*A*";
            }
        }
    }

    public int getTamanhoLabirinto() {
        return this.tamanhoLabirinto;
    }

    public String retornarValorPosicaoLabirinto(PosicaoXY posicao) {
        return this.labirinto[posicao.getPosX()][posicao.getPosY()];
    }

    public void setAgente(AgenteLabirinto agente) {
        this.agente = agente;
    }

    public void limpar() {
        if (this.agente != null) {
            PosicaoXY posicao = this.agente.getPosicao();
            labirinto[posicao.getPosX()][posicao.getPosY()] = "L";
        } else {
            throw new IllegalStateException("Agente não configurado no labirinto.");
        }
    }
}