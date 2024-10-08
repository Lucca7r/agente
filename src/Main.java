
import agente.AgenteLabirinto;
import ambiente.Labirinto;
import geral.PosicaoXY;

public class Main{

	public static void main(String[] args) throws InterruptedException	 {
		
		Labirinto labirinto = new Labirinto(4);	
		labirinto.exibirLabirinto();
		
		AgenteLabirinto agente = new AgenteLabirinto(labirinto);
		agente.setPosicao(new PosicaoXY(2,2));
		labirinto.setAgente(agente);

		while(agente.isAindaLimpando()) {
			agente.zerarPilha();
			agente.movimentar(); 
			labirinto.exibirLabirinto();
			Thread.sleep(1500);
		}
		return;
	}

}
