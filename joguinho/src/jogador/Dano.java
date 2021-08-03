package jogador;

import java.util.Random;

public class Dano extends Caixa 
{
	
	@Override
	public void abertura(Jogador jogador)
	{
		Random r = new Random();
		int al = r.nextInt(4) + 1;
		
		jogador.setForca(jogador.getForca() - al);
		
		if(jogador.getForca() <= 0)
		{
			jogador.setVida(jogador.getVida() - 1);
			jogador.setForca(10);
		}
	}
}
