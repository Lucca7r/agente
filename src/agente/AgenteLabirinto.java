package agente;

import ambiente.Labirinto;
import geral.PosicaoXY;

public class AgenteLabirinto {

    private Labirinto labirinto;
    private PosicaoXY posXY;
    private MovimentosAgenteLabirinto movimento;
    private int pilhaMovimentos;

    public AgenteLabirinto(Labirinto labirinto) {
        this.labirinto = labirinto;
        this.posXY = new PosicaoXY(0, 0);
        this.movimento = MovimentosAgenteLabirinto.CIMA;
        this.pilhaMovimentos = 0;
    }

    public void setPosicao(PosicaoXY posicao) {
        this.posXY = posicao;
    }

    public void movimentar() {
        boolean existeAgua = existeAguaNoLabirinto();
        
        PosicaoXY proximaAgua = buscarSujeiraProxima("A");
    
        if (existeAgua && proximaAgua != null) {
            this.posXY = proximaAgua;
            this.labirinto.limpar();
            this.pilhaMovimentos++;

        } 
    
        if (!existeAgua) {
            PosicaoXY proximoPo = buscarSujeiraProxima("P");
            if (proximoPo != null) {
                this.posXY = proximoPo;
                this.labirinto.limpar();
                this.pilhaMovimentos++;
            }
        }
    }

    public PosicaoXY buscarSujeiraProxima(String tipoSujeira) {
        for (int i = 0; i < labirinto.getTamanhoLabirinto(); i++) {
            for (int j = 0; j < labirinto.getTamanhoLabirinto(); j++) {
                if (labirinto.retornarValorPosicaoLabirinto(new PosicaoXY(i, j)).equals(tipoSujeira)) {
                    return new PosicaoXY(i, j);
                }
            }
        }

        
        return null;
    }

    public boolean existeAguaNoLabirinto() {
        for (int i = 0; i < labirinto.getTamanhoLabirinto(); i++) {
            for (int j = 0; j < labirinto.getTamanhoLabirinto(); j++) {
                if (labirinto.retornarValorPosicaoLabirinto(new PosicaoXY(i, j)).equals("A")) {
                    return true;
                }
            }
        }
        return false;
    }

    public String verificarTipoSujeira(PosicaoXY posicao) {
        return this.labirinto.retornarValorPosicaoLabirinto(posicao);
    }

    public boolean isPosicaoValida(int x, int y) {
        String valor = this.labirinto.retornarValorPosicaoLabirinto(new PosicaoXY(x, y));
        return !valor.equals("P");
    }

    public PosicaoXY retornarMovimento() {
        int retornoPosX = this.posXY.getPosX();
        int retornoPosY = this.posXY.getPosY();

        switch(movimento) {
            case CIMA:
                if (retornoPosX > 0 && isPosicaoValida(retornoPosX - 1, retornoPosY)) {
                    retornoPosX -= 1;
                } else {
                    movimento = MovimentosAgenteLabirinto.BAIXO;
                }
                break;
            case BAIXO:
                if (retornoPosX < this.labirinto.getTamanhoLabirinto() - 1 && isPosicaoValida(retornoPosX + 1, retornoPosY)) {
                    retornoPosX += 1;
                } else {
                    movimento = MovimentosAgenteLabirinto.ESQUERDA;
                }
                break;
            case ESQUERDA:
                if (retornoPosY > 0 && isPosicaoValida(retornoPosX, retornoPosY - 1)) {
                    retornoPosY -= 1;
                } else {
                    movimento = MovimentosAgenteLabirinto.DIREITA;
                }
                break;
            case DIREITA:
                if (retornoPosY < this.labirinto.getTamanhoLabirinto() - 1 && isPosicaoValida(retornoPosX, retornoPosY + 1)) {
                    retornoPosY += 1;
                } else {
                    movimento = MovimentosAgenteLabirinto.CIMA;
                }
                break;
        }
        return new PosicaoXY(retornoPosX, retornoPosY);
    }

    public PosicaoXY getPosicao() {
        return this.posXY;
    }

    public boolean isAindaLimpando() {
        return pilhaMovimentos < 4;
    }

    public void zerarPilha() {
        this.pilhaMovimentos = 0;
    }
}