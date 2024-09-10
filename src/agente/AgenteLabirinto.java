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
        // Verifica se há "A" nas células adjacentes
        PosicaoXY proximaAgua = buscarSujeiraProxima("A");
    
        if (proximaAgua != null) {
            // Move para a célula com "A" e limpa
            this.posXY = proximaAgua;
            this.labirinto.limpar();
            this.pilhaMovimentos++;
        } else {
            // Não há "A" nas proximidades, então verifica o tipo de sujeira atual
            String tipoSujeira = verificarTipoSujeira(this.posXY);
    
            if (tipoSujeira.equals("P")) {
                // Se estiver sobre "P", limpa o pó
                this.labirinto.limpar();
                this.pilhaMovimentos++;
            } else {
                // Se não há sujeira, move para a próxima posição
                this.posXY = retornarMovimento();
                atualizarMovimento();
            }
        }
    }
    

    public PosicaoXY buscarSujeiraProxima(String tipoSujeira) {
        int x = this.posXY.getPosX();
        int y = this.posXY.getPosY();
        
        // Verifica se há "A" nas células vizinhas (CIMA, BAIXO, ESQUERDA, DIREITA)
        if (x > 0 && this.labirinto.retornarValorPosicaoLabirinto(new PosicaoXY(x - 1, y)).equals(tipoSujeira)) {
            return new PosicaoXY(x - 1, y); // CIMA
        }
        if (x < this.labirinto.getTamanhoLabirinto() - 1 && this.labirinto.retornarValorPosicaoLabirinto(new PosicaoXY(x + 1, y)).equals(tipoSujeira)) {
            return new PosicaoXY(x + 1, y); // BAIXO
        }
        if (y > 0 && this.labirinto.retornarValorPosicaoLabirinto(new PosicaoXY(x, y - 1)).equals(tipoSujeira)) {
            return new PosicaoXY(x, y - 1); // ESQUERDA
        }
        if (y < this.labirinto.getTamanhoLabirinto() - 1 && this.labirinto.retornarValorPosicaoLabirinto(new PosicaoXY(x, y + 1)).equals(tipoSujeira)) {
            return new PosicaoXY(x, y + 1); // DIREITA
        }
        
        // Se não encontrou "A" nas proximidades, retorna null
        return null;
    }
    

    private void atualizarMovimento() {
        switch (movimento) {
            case CIMA:
                movimento = MovimentosAgenteLabirinto.BAIXO;
                break;
            case BAIXO:
                movimento = MovimentosAgenteLabirinto.ESQUERDA;
                break;
            case ESQUERDA:
                movimento = MovimentosAgenteLabirinto.DIREITA;
                break;
            case DIREITA:
                movimento = MovimentosAgenteLabirinto.CIMA;
                break;
        }
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