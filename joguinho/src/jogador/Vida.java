package jogador;

public class Vida extends Caixa 
{
	@Override
	public void abertura(Jogador jogador)
	{
		jogador.setVida(jogador.getVida() + 1);
	}
}
