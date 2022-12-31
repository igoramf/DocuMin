package documin.documento;

import java.util.ArrayList;

import documin.elementos.Elemento;
/**
 * 
 * @author Igor Falcão
 *
 */
public interface documentoInterface {
	public String getTitulo();
	
	public int contaElementos();
	
	public ArrayList<Elemento> getElementos();
	
	public void moveElementoAcima(int posicao);
	
	public void moveElementoAbaixo(int posicao);
	
	public boolean removeElemento(int posicao);
	
	public int criaElemento(Elemento e);
	
	public String[] exibirDocumento();
	
	public Elemento getElemento(int elementoPosicao);
	
	public boolean estaCheio();

	public int getTamanhoMaximo();
}
